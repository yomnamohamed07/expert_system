#define vec2 float2
#define vec4 float4
#define rgb xyz
#define rgba xyzw

typedef struct
{
	int width[8];
	int height[8];
	float cur_time;
	float total_time;
	float origROI[4];
	float resultROI[4];
	float angle;
}FilterParam;

const sampler_t sampler = CLK_NORMALIZED_COORDS_TRUE | CLK_ADDRESS_CLAMP_TO_EDGE | CLK_FILTER_NEAREST;

static int get_global_id0(__global FilterParam* param)
{
	return get_global_id(0) - param->origROI[0]* param->width[0];
}

static int get_global_id1(__global FilterParam* param)
{
	return get_global_id(1) - param->origROI[1]* param->height[0];
}

vec4 INPUTSRC(image2d_t src_data, __global FilterParam* param, vec2 tc)
{
	tc = (vec2)(tc.x, tc.y)*(vec2)(param->origROI[2], param->origROI[3]) + (vec2)(param->origROI[0], param->origROI[1]);
	return read_imagef(src_data, sampler, tc);
}
	
vec4 INPUT(image2d_t ovelay1,  __global FilterParam* param, vec2 tc)
{
	return read_imagef(ovelay1, sampler, (vec2)(tc.x,tc.y) );
}


// Filter FourSeason
__kernel void filter_FourSeason(__read_only image2d_t image,   		// input image
								__global uchar* crossR,   			// image buffer tableR
								__global uchar* crossG,   			// image buffer tableG
								__global uchar* crossB,   			// image buffer tableB
								__global uchar* ProR,   			// image buffer ProR
								__global uchar* ProG,   			// image buffer ProG
								__global uchar* ProB,   			// image buffer ProB
								__global uchar* clipTable,			// image buffer clip table
								__write_only image2d_t retImage,   	// image result
								__private int aPercent_warm,
								__private int aGOffset_warm,
								__private int aPercent_cool,
								__private int aGOffset_cool,
								__private int alpha,				// blend factor, scrope[0-100]	
								__global FilterParam* param)	 			
{
	int w = get_global_id(0);
	int h = get_global_id(1);
	int width = get_image_width(image);
	int height = get_image_height(image);
	int W = get_global_size(0);
	int H = get_global_size(1);
	
	if(w >= width || h >= height)
			return;
	float2 resolution = (float2)(W,H);
	vec2 fragCoord = (vec2)(get_global_id0( param), get_global_id1( param));
	vec2 uv = ((vec2)(fragCoord.x, fragCoord.y) + (vec2)(0.5f))/resolution.xy;

	float4 color = INPUTSRC(image, param, uv);
	uchar sr = convert_uchar_sat(color.x * 255.0f);
	uchar sg = convert_uchar_sat(color.y * 255.0f);
	uchar sb = convert_uchar_sat(color.z * 255.0f);
	uchar sa = convert_uchar_sat(color.w * 255.0f);

	int clip = W / 4;
	float scale = W / 640.0f;
	if(scale < 1.0f)
		scale = 1.0f;
	int lineWidth = scale * 4.0f;
	uchar4 retColor;
	
	w = fragCoord.x;
	h = fragCoord.y;
	if(w < clip - lineWidth)
	{
		retColor.x = crossR[sr];
		retColor.y = crossG[sg];
		retColor.z = crossB[sb];
		retColor.w = sa;
	}
	else if(w >= (clip - lineWidth) && w < clip)
	{
		retColor = (uchar4)(0, 0, 0, 0);
	}
	else if( w >= clip && w < (2 * clip - lineWidth))
	{
		retColor.x = ProR[sr];
		retColor.y = ProG[sg];
		retColor.z = ProB[sb];
		retColor.w = sa;
	}
	else if( w >= (2 * clip - lineWidth) && w < (2 * clip))
	{
		retColor = (uchar4)(0, 0, 0, 0);
	}
	else if( w >= (2 * clip) && w < (3 * clip - lineWidth))
	{
		int index_R = sr + aPercent_warm;
		int index_G = sg - aGOffset_warm;
		int index_B = sb - aPercent_warm;
	
		if(index_R < 0)	index_R = 0;
		else if(index_R > 511)	index_R = 511;
		
		if(index_G < 0)	index_G = 0;
		else if(index_G > 511)	index_G = 511;
		
		if(index_B < 0)	index_B = 0;
		else if(index_B > 511)	index_B = 511;
		
		retColor.x = clipTable[index_R];
		retColor.y = clipTable[index_G];
		retColor.z = clipTable[index_B];
		retColor.w = sa;
	}
	else if( w >= (3 * clip - lineWidth) && w < (3 * clip))
	{
		retColor = (uchar4)(0, 0, 0, 0);
	}
	else
	{
		int index_R = sr + aPercent_cool;
		int index_G = sg - aGOffset_cool;
		int index_B = sb - aPercent_cool;
		
		if(index_R < 0)	index_R = 0;
		else if(index_R > 511)	index_R = 511;
		
		if(index_G < 0)	index_G = 0;
		else if(index_G > 511)	index_G = 511;
		
		if(index_B < 0)	index_B = 0;
		else if(index_B > 511)	index_B = 511;
		
		retColor.x = clipTable[index_R];
		retColor.y = clipTable[index_G];
		retColor.z = clipTable[index_B];
		retColor.w = sa;
	}	
	
	float factor = (float)(alpha)/100.0f;
	float4 ret = ((convert_float4(retColor)) / 255.0f) * factor + (1.0f - factor) * color;
	
	write_imagef(retImage, (int2)(get_global_id(0), get_global_id(1)), ret);
}
