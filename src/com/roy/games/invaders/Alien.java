package com.roy.games.invaders;

import com.roy.util.whisp.StencilImage;
import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Alien {
	Vector2 origin;
	Vector2 position;
	float motionAngle;
	StencilImage image;
	float spriteSwapTick = 0;
	
	Alien(Vector2 newOrigin, Image newImage, Vector2 imageSize) {
		position = newOrigin;
		origin = new Vector2(newOrigin);
		image = new StencilImage(imageSize, newImage);
	}

	void update(double dt) {
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
