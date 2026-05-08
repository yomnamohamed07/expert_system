
const sampler_t sampler = CLK_NORMALIZED_COORDS_TRUE | CLK_ADDRESS_CLAMP_TO_EDGE | CLK_FILTER_LINEAR;
#define vec2 float2
#define vec3 float3
#define vec4 float4

vec4 Screen(vec4 base, vec4 blend)
{
    vec4 white = (vec4)(1.0f);
    vec4 result = white - ((white - blend) * (white - base));
    return result;
}

vec4 INPUT(image2d_t src_data, __global FilterParam* param, vec2 tc)
{
	tc = (vec2)(tc.x, tc.y)*(vec2)(param->origROI[2], param->origROI[3]) + (vec2)(param->origROI[0], param->origROI[1]);
	return read_imagef(src_data, sampler, tc);
}


__kernel void MAIN(
	   __read_only image2d_t input1,
      __write_only image2d_t dest_data,
      __global FilterParam* param,
	  float fade,
	  int alpha)
{
	int W = get_global_size(0);
	int H = get_global_size(1);
	int textH = param->height[0];;
	float iGlobalTime = param->cur_time;
	
	int w = get_global_id(0);
	int h = get_global_id(1);
	float2 iresolution = (float2)(W,H);
	int2 gl_FragCoord = (int2)(get_global_id(0), get_global_id(1));
	vec2 fragCoord = (vec2)(get_global_id0( param), get_global_id1( param));
	vec2 tc = (vec2)(fragCoord.x + 0.5f, fragCoord.y + 0.5f)/iresolution.xy;
	
    vec2 uv = tc;
	
	float amount = 0.0f;
	
	amount = (1.0f + sin(iGlobalTime*6.0f)) * 0.5f;
	amount *= 1.0f + sin(iGlobalTime*16.0f) * 0.5f;
	amount *= 1.0f + sin(iGlobalTime*19.0f) * 0.5f;
	amount *= 1.0f + sin(iGlobalTime*27.0f) * 0.5f;
	amount = pow(amount, 3.0f);

	amount *= 0.05f;
	
	amount *= fade;
	
    vec3 col;
    col.x = INPUT(input1, param, (vec2)(uv.x+amount,uv.y) ).x;
    col.y = INPUT(input1, param,  uv ).y;
    col.z = INPUT(input1, param , (vec2) (uv.x-amount,uv.y) ).z;

	col *= (1.0f - amount * 0.5f);
	
	float4 inBGRA = INPUT(input1, param, tc);
	
	float4 outputCol = (float4)(inBGRA.xyz*(1.0f - (float)alpha/100.0f) + col*(float)alpha/100.0f, inBGRA.w);
	
	write_imagef(dest_data, gl_FragCoord, outputCol); 
}
