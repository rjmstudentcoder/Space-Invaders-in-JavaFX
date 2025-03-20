package com.roy.games.invaders;

import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Player extends Entity {
	public int controlDeltaX = 0;
	public float minX;
	public float maxX;

	public Player(Image newImage, Vector2 newPos, float newMinX, float newMaxX) {
		super(newPos, Vector2.zero(), newImage,  new Vector2(16, 8), Vector2.zero());
		minX = newMinX;
		maxX = newMaxX;
		setAnimationInfo(0.5, 2, 0, false);
	}
	
	public void kill() {
		super.kill();
		image.setOffset(new Vector2(16, 0));
	}

	public void update(double dt) {
		super.update(dt);
		if (!dying) {
			float difference = (float) (position.x + (controlDeltaX * dt * 100));
			position.x = Math.min(Math.max(difference, minX), maxX);
		} else {
			if (deathTick > afterlife / 3 && deathTick < (afterlife / 3) * 2 ) {
				image.setOffset(new Vector2(32, 0));
			} else if (deathTick > (afterlife / 3) * 2) {
				image.setOffset(new Vector2(48, 0));
			}
		}
	}
}
