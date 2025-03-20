package com.roy.games.invaders;

import com.roy.util.whisp.StencilImage;
import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Laser {
	Vector2 position;
	float motionAngle;
	StencilImage image;
	float spriteSwapTick = 0;
	Vector2 initialSpriteOffset;
	Vector2 velocity;
	boolean evil;
	boolean dead;
	double deathTick;
	
	Laser(Vector2 newPosition, Vector2 newVelocity, Image newImage, Vector2 imageSize, Vector2 spriteOffset, boolean isEvil) {
		position = new Vector2(newPosition);
		image = new StencilImage(imageSize, newImage);
		image.setOffset(spriteOffset);
		initialSpriteOffset = new Vector2(spriteOffset);
		velocity = newVelocity;
		evil = isEvil;
		dead = false;
		deathTick = 0;
	}

	void update(double dt) {
		if (dead) {
			deathTick += dt;
			image.setOffset(new Vector2(6, 0));
			image.spriteSize = new Vector2(6, 8);
			image.size = new Vector2(6, 8);
		} else {
			spriteSwapTick += dt;
			if (spriteSwapTick > 0.1) {
				spriteSwapTick = 0;
				if (image.spriteOffset.x < initialSpriteOffset.x + image.spriteSize.x * 3) {
					image.setOffset(new Vector2(image.spriteOffset.x + image.spriteSize.x, image.spriteOffset.y));
				} else {
					image.setOffset(new Vector2(initialSpriteOffset.x, initialSpriteOffset.y));
				}
			}
			position.x += velocity.x * dt;
			position.y += velocity.y * dt;
		}
	}
}
