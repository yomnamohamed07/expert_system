// Filter Glow
__kernel void filter_Glow(__read_only image2d_t image,   		// image image
						  __global uchar4* blur,     			// input blur table
						  __write_only image2d_t retImage,   	// image result
						  __private int alpha)	 				// blend factor, scrope[0-100]	
{
	int w = get_global_id(0);
	int h = get_global_id(1);
	int width = get_image_width(image);
	int height = get_image_height(image);
	const sampler_t sampler = CLK_NORMALIZED_COORDS_FALSE | CLK_ADDRESS_CLAMP_TO_EDGE | CLK_FILTER_NEAREST;

	if(w>=width||h>=height)
		return;	

	float factor = (float)(alpha)/100.0f;
	float4 color = read_imagef(image, sampler, (int2)(w, h));	
	uchar sr = color.x * 255;
	uchar sg = color.y * 255;
	uchar sb = color.z * 255;
	uchar sa = color.w * 255;
	
	int offset = h * width + w;
	uchar bb = blur[offset].s0;
	uchar bg = blur[offset].s1;
	uchar br = blur[offset].s2;
	uchar ba = blur[offset].s3;
	
	float b = (float)(255 - ((255 - sb) * (255 - bb)) / 255.0f )/255.0f;
	float g = (float)(255 - ((255 - sg) * (255 - bg)) / 255.0f )/255.0f;
	float r = (float)(255 - ((255 - sr) * (255 - br)) / 255.0f )/255.0f;
	float a = color.w;
	
	write_imagef(retImage, (int2)(w, h), color * (1.0f - factor) + (float4)(r,g,b,a) * factor);
}