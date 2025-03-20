package com.roy.util.whisp.objects;

import com.roy.util.whisp.WspStencil;
import com.roy.util.whisp.Vector2;

public class Collider2D implements Object2D {
	
	public Vector2 position;
	public Vector2 size;
	public int rotation;
	private boolean destroyed;
	
	public void update(double deltaTime) {
		// Empty
	}
	
	public void draw(WspStencil canvas) {
		// Empty
	}
	
	public void onInput() {
		// Empty
	}
	
	public boolean isDestroyed() {
		return this.destroyed;
	}
	
	public void destroy() {
		this.destroyed = true;
	}
	
}
