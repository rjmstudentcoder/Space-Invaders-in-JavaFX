package com.roy.games.invaders;

import com.roy.util.whisp.StencilImage;
import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Entity {
	public Vector2 position;
	public float motionAngle;
	public StencilImage image;
	public Vector2 initialSpriteOffset;
	public Vector2 velocity;
	public boolean dying;
	public boolean dead;
	public double deathTick;
	public double afterlife;
	public double spriteSwapTick;
	public double spriteSwapSpeed;
	public int spriteFrames;
	public boolean animationAxis;

	public void kill() {
		dying = true;
	}

	public Entity(Vector2 newPosition, Vector2 newVelocity, Image newImage, Vector2 imageSize, Vector2 spriteOffset) {
		position = new Vector2(newPosition);
		image = new StencilImage(imageSize, newImage);
		image.setOffset(spriteOffset);
		initialSpriteOffset = new Vector2(spriteOffset);
		velocity = newVelocity;
		dead = false;
		dying = false;
		deathTick = 0;
		afterlife = 0.5;
		spriteSwapSpeed = 0.5;
		spriteFrames = 3;
		animationAxis = false;
	}

	public void setSpriteOffsetOrigin(Vector2 offset) {
		initialSpriteOffset = new Vector2(offset);
		image.setOffset(offset);
	}

	public void setAnimationInfo(double newAfterlife, double newSwapSpeed, int newSpriteFrames, boolean axis) {
		afterlife = newAfterlife;
		spriteSwapSpeed = newSwapSpeed;
		spriteFrames = newSpriteFrames;
		animationAxis = axis;
	}

	public void update(double dt) {
		if (dying) {
			deathTick += dt;
			if (deathTick > afterlife) {
				dead = true;
			}
		} else {
			spriteSwapTick += dt;
			if (spriteSwapTick > spriteSwapSpeed) {
				spriteSwapTick = 0;
				if (animationAxis == false) {
					if (image.spriteOffset.x < initialSpriteOffset.x + image.spriteSize.x * spriteFrames) {
						image.setOffset(new Vector2(image.spriteOffset.x + image.spriteSize.x, image.spriteOffset.y));
					} else {
						image.setOffset(new Vector2(initialSpriteOffset.x, initialSpriteOffset.y));
					}
				} else {
					if (image.spriteOffset.y < initialSpriteOffset.y + image.spriteSize.y * spriteFrames) {
						image.setOffset(new Vector2(image.spriteOffset.x, image.spriteOffset.y + image.spriteSize.y));
					} else {
						image.setOffset(new Vector2(initialSpriteOffset.x, initialSpriteOffset.y));
					}
				}

			}
			position.x += velocity.x * dt;
			position.y += velocity.y * dt;
		}
	}
}
