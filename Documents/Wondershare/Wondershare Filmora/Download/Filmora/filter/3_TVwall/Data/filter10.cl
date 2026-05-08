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

const sampler_t sampler = CLK_NORMALIZED_COORDS_FALSE | CLK_ADDRESS_CLAMP_TO_EDGE | CLK_FILTER_NEAREST;
	
vec4 INPUT(image2d_t ovelay1,  __global FilterParam* param, vec2 tc)
{
	return read_imagef(ovelay1, sampler, (vec2)(tc.x,tc.y) );
}

// Filter TVWall
__kernel void filter_TVWall(__read_only image2d_t image,   		// input image
							__write_only image2d_t retImage,   	// image result
							__private int horizonetalCnts,
							__private int verticalCnts,
							__private int alpha,		// blend factor, scrope[0-100]	
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
	vec2 fragCoord = (vec2)(w, h);
	
	if(w >= width || h >= height)
		return;
	float4 origCol = INPUT(image, param, fragCoord);
	
	int roiX0 = param->origROI[0]* param->width[0];
	int roiY0 = param->origROI[1]* param->height[0];
	int roiWidth = param->origROI[2]* param->width[0];
	int roiHeight = param->origROI[3]* param->height[0];
	
	int blockWidth = W / horizonetalCnts;
	int blockHeight = H / verticalCnts;
	
	float2 onePixel = 1.0f/resolution.xy;	
	vec2 scaleCor = fmod((vec2)((fragCoord.x -  roiX0 + onePixel.x * (horizonetalCnts - 1))*horizonetalCnts, (fragCoord.y -  roiY0 + onePixel.y * (verticalCnts - 1))*verticalCnts), 
				(vec2)(roiWidth,roiHeight)) + (vec2)(roiX0, roiY0);
	
	float4 scaleCol = INPUT(image, param, scaleCor);
	if(w == roiX0 || w == (roiX0 + blockWidth) || w == (roiX0 + blockWidth * 2) || h == 0 || h == blockHeight || h == (blockHeight * 2))
		scaleCol.xyz = (float3)(0.0f);
	
	float factor = alpha/100.0f;
	
	write_imagef(retImage, (int2)(w, h), scaleCol*factor + origCol*(1.0f - factor));
}
