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

vec4 INPUTSRC(image2d_t src_data,__global FilterParam* param, vec2 tc)
{
	tc = (vec2)(tc.x, tc.y)*(vec2)(param->origROI[2], param->origROI[3]) + (vec2)(param->origROI[0], param->origROI[1]);
	return read_imagef(src_data, sampler, tc);
}

vec4 INPUT(image2d_t src_data, vec2 tc)
{
	return read_imagef(src_data, sampler, tc).zyxw;
}

// auchor: RSQ
// data:   2017/6/30
__kernel void MAIN(
      __read_only image2d_t input1,
	  __read_only image2d_t input2,
      __write_only image2d_t dest_data,
      __global FilterParam* param,
	  int strength)
{	
	int W = get_global_size(0);
	int H = get_global_size(1);
	int textH = param->height[0];;
	float iGlobalTime = param->cur_time / param->total_time;
	
	int w = get_global_id(0);
	int h = get_global_id(1);
	float2 iresolution = (float2)(W,H);
	int2 gl_FragCoord = (int2)(get_global_id(0), get_global_id(1));
	vec2 fragCoord = (vec2)(get_global_id0( param), get_global_id1( param));
	vec2 tc = (vec2)(fragCoord.x + 0.5f, fragCoord.y + 0.5f)/iresolution.xy;
	vec2 u_imgWH = iresolution;
	float u_raiusRatio = 0.55f;

    float width =  u_imgWH.x;//u_imgWH.x;
    float height = u_imgWH.y;
    float maxHalfWH = max(width/2.0f, height/2.0f);
    
    float innerRadius = fmax(u_raiusRatio-0.4f, 0.0f) * maxHalfWH;
    float outterRadius = (1.1f * u_raiusRatio + 0.1f) * maxHalfWH; 
    
    float innerRadius2 = innerRadius * innerRadius;
    float outterRadius2 = outterRadius * outterRadius;
    
    float curDistX = (tc.x - 0.5f) * width;
    float curDistY = (tc.y - 0.5f) * height;
    float curDist2 = curDistX * curDistX + curDistY * curDistY;
    float alpha = 0.0f;
    
    if(curDist2 > outterRadius2)
    {
        alpha = 0.0f; //black
    }
    else
    {
        float curDist = sqrt(curDist2);
        
        innerRadius = outterRadius - innerRadius;
        alpha = (outterRadius - curDist) / innerRadius;
    }
    
    vec4 base = INPUTSRC(input1, param, tc);
	vec4 inBGRA = base;
    float gray = dot(base.zyx, (vec3)(0.114f, 0.587f, 0.299f));    
    vec4 blend = INPUT(input2, (vec2)(tc.x, 1.0f - tc.y));
    base = Screen((vec4)((vec3)(gray), 1.0f), blend);
    alpha = 1.0f - alpha;
    base = mix(base, blend, alpha);
	
	float4 outputCol = (float4)(inBGRA.xyz*(1.0f - (float)strength/100.0f) + base.xyz*(float)strength/100.0f, inBGRA.w);
	write_imagef(dest_data, gl_FragCoord, outputCol); 
}
