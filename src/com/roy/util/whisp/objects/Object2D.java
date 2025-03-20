package com.roy.util.whisp.objects;

import com.roy.util.whisp.WspStencil;

public interface Object2D {
	
	public void update(double deltaTime);

	public void draw(WspStencil canvas);

	public void onInput();
	
}
