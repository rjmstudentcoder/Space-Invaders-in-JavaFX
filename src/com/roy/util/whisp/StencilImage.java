package com.roy.util.whisp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StencilImage {
	public Image image;
	public ImageView imageView;
	public Vector2 size;
	public Vector2 spriteSize;
	public Vector2 spriteOffset;
	public void setOffset(Vector2 newOffset) {
		spriteOffset = newOffset;
		imageView.setViewport(new javafx.geometry.Rectangle2D(spriteOffset.x, spriteOffset.y, spriteSize.x, spriteSize.y));
	}
	public StencilImage(Vector2 newSpriteSize, Image newImage) {
		imageView = new ImageView(image);
		spriteSize = newSpriteSize;
		size = spriteSize;
		setOffset(new Vector2(0, 0));
		image = newImage;
	}
}
