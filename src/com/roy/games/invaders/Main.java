package com.roy.games.invaders;

import com.roy.util.whisp.WspStencil;
import com.roy.util.whisp.StencilImage;
import com.roy.util.whisp.Vector2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.Group;

import java.util.ArrayList;

public class Main extends Application implements WspStencil {
	public Vector2 scaleMultiplier;
	public float aspectRatio;
	public Vector2 resolution;
	public long clock;
	public Canvas canvas;
	int selectedAlien;
	GraphicsContext graphics_context;
	Image laserImage;
	Player player;
	ArrayList<Alien> aliens;
	ArrayList<Laser> lasers;

	public void drawImage(StencilImage image, Vector2 position, Vector2 size, int rotation) {
		graphics_context.drawImage(image.image, image.spriteOffset.x, image.spriteOffset.y, image.spriteSize.x,
				image.spriteSize.y, Math.floor(position.x - size.x / 2) * scaleMultiplier.x, Math.floor(position.y - size.y / 2) * scaleMultiplier.x, size.x * scaleMultiplier.x, size.y * scaleMultiplier.x);
	};

	public Vector2 getScreenResolution() {
		return this.resolution;
	};

	public Vector2 getScaleMultiplier() {
		return this.scaleMultiplier;
	};

	public float getAspectRatio() {
		return this.aspectRatio;
	};

	public void update(double dt) {
		player.update(dt);
		for (int i=0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			alien.update(dt);
			if (alien.dead) {
				aliens.remove(alien);
				break;
			} else if (alien.laserTick > 1) {
				alien.laserTick = 0;
				lasers.add(new Laser(new Vector2(Vector2.add(alien.position, new Vector2(0, 5))), new Vector2(0, 20), laserImage, new Vector2(3, 8), new Vector2(0, 0), true));
			}
		}
		boolean shouldExitLoop = false;
		for (int i=0; i < lasers.size(); i++) {
			if (shouldExitLoop) {
				break;
			}
			Laser laser = lasers.get(i);
			laser.update(dt);
			if (laser.dead) {
				lasers.remove(laser);
				break;
			} else if (laser.evil == false) {
				for (int i2=0; i2 < aliens.size(); i2++) {
					Alien alien = aliens.get(i2);
					Vector2 distance = Vector2.sub(alien.position, laser.position);
					if (!alien.dying) {
						if (Math.abs(distance.x) < alien.image.spriteSize.x/2 && Math.abs(distance.y) < alien.image.spriteSize.y/2) {
							alien.kill();
							laser.kill();
							shouldExitLoop = true;
							break;
						}
					}
				}
			}
		}

		if (selectedAlien < aliens.size()) {
			if (selectedAlien == -1 || aliens.get(selectedAlien).laserTick == 0) {
				selectedAlien = (int) (Math.random() * aliens.size());
				aliens.get(selectedAlien).laserTick = (float)0.1;
			}
			aliens.get(selectedAlien).laserTick += dt;
		} else {
			selectedAlien = (int) (Math.random() * aliens.size());
		}
	
	}

	public void draw(double dt) {
		drawImage(player.image, player.position, player.image.size, 0);
		for (int i=0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			drawImage(alien.image, alien.position, alien.image.size, 0);
		}
		for (int i=0; i < lasers.size(); i++) {
			Laser laser = lasers.get(i);
			drawImage(laser.image, laser.position, laser.image.size, 0);
		}
		graphics_context.setFill(Color.WHITE);
		graphics_context.fillRect(0, 0, resolution.x * scaleMultiplier.x, 1 * scaleMultiplier.y);
	}

	public void start(Stage stage) {
		stage.setTitle("Space Invaders");
		
		scaleMultiplier = new Vector2(3, 3);
		
		resolution = new Vector2(192, 160);
		aspectRatio = resolution.y / resolution.x;

		canvas = new Canvas();
		canvas.setHeight(resolution.y * scaleMultiplier.x);
		canvas.setWidth(resolution.x * scaleMultiplier.y);

		graphics_context = canvas.getGraphicsContext2D();
		graphics_context.setImageSmoothing(false);
		graphics_context.setFill(Color.BLACK);
		graphics_context.fillRect(0, 0, resolution.x, resolution.y);

		Group group = new Group(canvas);
		Scene scene = new Scene(group, resolution.x * scaleMultiplier.x, resolution.y * scaleMultiplier.y);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
		player = new Player(new Vector2(resolution.x / 2, resolution.y - 20), 0, resolution.x);
		lasers = new ArrayList<Laser>();
		laserImage = new Image(getClass().getResource("/assets/images/sprites/lasers.png").toExternalForm());
		selectedAlien = -1;
		aliens = new ArrayList<Alien>();
		Image alienImage = new Image(getClass().getResource("/assets/images/sprites/aliens.png").toExternalForm());
		for (int y=1; y < 4; y++) {
			for (int x=1; x < 10; x++) {
				Alien newAlien = new Alien(new Vector2(x * 20 - 5, y * 20), alienImage, new Vector2(16, 8));
				if (y > 1) {
					newAlien.motionAngle += (Math.PI  / 2) * y +( x )  / 2;
				}
				newAlien.setSpriteOffsetOrigin(new Vector2((y - 1)*newAlien.image.spriteSize.x, 0));
				aliens.add(newAlien);
			}
		}

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				KeyCode code = keyEvent.getCode();
				if (code == KeyCode.LEFT && player.controlDeltaX != 1) {
					player.controlDeltaX = -1;
				} else if (code == KeyCode.RIGHT && player.controlDeltaX != -1) {
					player.controlDeltaX = 1;
				} else if (code == KeyCode.Z || code == KeyCode.SPACE) {
					lasers.add(new Laser(new Vector2(Vector2.add(player.position, new Vector2(0, -5))), new Vector2(0, -20), laserImage, new Vector2(3, 8), new Vector2(24, 0), false));
				}
			}
		});

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				EventType<KeyEvent> event = keyEvent.getEventType();
				KeyCode code = keyEvent.getCode();
				if (event == KeyEvent.KEY_RELEASED) {
					if (code == KeyCode.LEFT && player.controlDeltaX == -1) {
						player.controlDeltaX = 0;
					} else if (code == KeyCode.RIGHT && player.controlDeltaX == 1) {
						player.controlDeltaX = 0;
					}
				}
			}
		});

		clock = System.nanoTime();
		AnimationTimer animator = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				long current_time = System.nanoTime();
				double dt = (double) ((current_time - clock) / 1000000000.0);
				if (0.03 <= dt) {
					update(dt);
					graphics_context.setFill(Color.BLACK);
					graphics_context.fillRect(0, 0, resolution.x * scaleMultiplier.x, resolution.y * scaleMultiplier.y);
					draw(dt);
					clock = current_time;
				}

			}
		};
		animator.start();

	}
}
