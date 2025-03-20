package com.roy.games.invaders;

import com.roy.util.whisp.StencilImage;
import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Player {
	public StencilImage image;
	public Vector2 position;
	public int controlDeltaX = 0;
	public float minX;
	public float maxX;

	public Player(Vector2 newPos, float newMinX, float newMaxX) {
		image = new StencilImage(new Vector2(16, 8),
				new Image(getClass().getResource("/assets/images/sprites/player.png").toExternalForm()));
		position = newPos;
		minX = newMinX;
		maxX = newMaxX;
	}

	public void update(double dt) {
		float difference = (float) (position.x + (controlDeltaX * dt * 100));
		position.x = Math.min(Math.max(difference, minX), maxX);
	}
}
