package com.roy.util.whisp.objects;

import com.roy.util.whisp.WspStencil;

public class Sprite2D extends Collider2D {
	
	String image;
	
	public void draw(WspStencil canvas) {
		canvas.drawImage(this.image, this.position, this.size, this.rotation);
	}
	
}
