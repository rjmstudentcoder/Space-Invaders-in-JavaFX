package com.roy.games.invaders;

import com.roy.util.whisp.Vector2;

import javafx.scene.image.Image;

public class Alien {
	Vector2 origin;
	Vector2 position;
	float motionAngle;
	Image image;
	
	void update(double dt) {
		motionAngle += dt;
		position = Vector2.add(new Vector2((float)Math.sin(motionAngle), 0), origin) ;
	}
}
