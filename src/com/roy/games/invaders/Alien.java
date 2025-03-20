package com.roy.games.invaders;

import com.roy.util.whisp.StencilImage;
import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Alien {
	Vector2 origin;
	Vector2 position;
	float motionAngle;
	StencilImage image;
	float spriteSwapTick;
	float laserTick;
	boolean dead;
	double deathTick;
	
	Alien(Vector2 newOrigin, Image newImage, Vector2 imageSize) {
		position = newOrigin;
		origin = new Vector2(newOrigin);
		image = new StencilImage(imageSize, newImage);
		spriteSwapTick = 0;
		laserTick = 0;
		dead = false;
		deathTick = 0;
	}

	void update(double dt) {
		if (dead) {
			deathTick += dt;
			image.setOffset(new Vector2(48, 0));
			image.spriteSize = new Vector2(16, 8);
		} else {
			spriteSwapTick += dt;
			if (spriteSwapTick > 1) {
				spriteSwapTick = 0;
				if (image.spriteOffset.y < 1) {
					image.setOffset(new Vector2(image.spriteOffset.x, image.spriteSize.y));
				} else {
					image.setOffset(new Vector2(image.spriteOffset.x, 0));
				}
			}
			motionAngle +=dt * 2;
			position.x = (float) (origin.x + (1 - Math.abs((motionAngle / Math.PI) % 2 - 1)) * 10);
		}
	}
}
