package com.roy.util.whisp;

public interface WspStencil {

	void drawImage(StencilImage image, Vector2 position, Vector2 size, int rotation);
	
	Vector2 getScreenResolution();
	
	Vector2 getScaleMultiplier();
	
	float getAspectRatio();
	
}