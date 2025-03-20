package com.roy.games.invaders;

import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Laser extends Entity {

	boolean evil;

	public Laser(Vector2 newPosition, Vector2 newVelocity, Image newImage, Vector2 imageSize, Vector2 spriteOffset, boolean isEvil) {
		super(newPosition, newVelocity, newImage, imageSize, spriteOffset);
		evil = isEvil;
		setAnimationInfo(0.2, 0.3, 3, false);
	}
	
	public void kill() {
		super.kill();
		image.setOffset(new Vector2(6, 0));
		image.spriteSize = new Vector2(6, 8);
		image.size = new Vector2(6, 8);
	}
}
