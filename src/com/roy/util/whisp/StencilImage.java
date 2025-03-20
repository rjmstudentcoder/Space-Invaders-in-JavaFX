package com.roy.util.whisp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StencilImage {
	public Image image;
	public Vector2 size;
	public Vector2 spriteSize;
	public Vector2 spriteOffset;

	public void setOffset(Vector2 newOffset) {
		spriteOffset = newOffset;
	}

	public StencilImage(Vector2 newSpriteSize, Image newImage) {
		spriteSize = newSpriteSize;
		size = spriteSize;
		setOffset(new Vector2(0, 0));
		image = newImage;
	}
}
