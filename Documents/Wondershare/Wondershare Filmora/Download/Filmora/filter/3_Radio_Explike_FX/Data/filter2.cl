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


	// Filter Blue Explosion
__kernel void filter_BlueExplosion(__read_only image2d_t merge,   		// image merge
								   __read_only image2d_t image,   		// image buffer
								   __global uchar* table,   			// input buffer table
								   __write_only image2d_t retImage,   	// image result	
								   __private int alpha,					// blend factor, scrope[0-100]	
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

	float4 color0 = INPUT(merge, param, uv);
	float4 color1 = INPUTSRC(image, param,uv);

	uchar sr = color0.x * 255;
	uchar sg = color0.y * 255;
	uchar sb = color0.z * 255;
	uchar dr = color1.x * 255;
	uchar dg = color1.y * 255;
	uchar db = color1.z * 255;
	
	uchar ret_b = table[(db << 8) + sb];
	uchar ret_g = table[(dg << 8) + sg];
	uchar ret_r = table[(dr << 8) + sr];
	
	float factor = (float)(alpha)/100.0f;
	
	ret_b = (uchar)(ret_b * factor + (1.0f - factor) * db);
	ret_g = (uchar)(ret_g * factor + (1.0f - factor) * dg);
	ret_r = (uchar)(ret_r * factor + (1.0f - factor) * dr);
	
	float4 retColor = (float4)((ret_r) / 255.0f, (ret_g) / 255.0f, (ret_b) / 255.0f, color1.w);
	
	write_imagef(retImage, (int2)(w, h), retColor);
}