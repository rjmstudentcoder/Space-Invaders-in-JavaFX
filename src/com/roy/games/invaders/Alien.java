package com.roy.games.invaders;

import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Alien extends Entity {
	Vector2 origin;
	float motionAngle;
	float laserTick;
	
	Alien(Vector2 newOrigin, Image newImage, Vector2 imageSize) {
		super(newOrigin,Vector2.zero(), newImage, imageSize, Vector2.zero());
		origin = new Vector2(newOrigin);
		laserTick = 0;
		setAnimationInfo(0.2, 1, 1, true);
	}
	
	public void kill() {
		super.kill();
		image.setOffset(new Vector2(48, 0));
	}

	public void update(double dt) {
		super.update(dt);
		if (!dying) {
			motionAngle +=dt * 2;
			position.x = (float) (origin.x + (1 - Math.abs((motionAngle / Math.PI) % 2 - 1)) * 10);
		}
	}
}
