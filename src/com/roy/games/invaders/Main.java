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
import javafx.scene.canvas.*;
import javafx.scene.paint.Color; 
import javafx.scene.Group; 

public class Main extends Application implements WspStencil {
	public Vector2 scaleMultiplier;
	public float aspectRatio;
	public Vector2 resolution;
	public long clock;
	public Canvas canvas;
	GraphicsContext graphics_context;
	Player player;
	Alien aliens;
	
	public void drawImage(StencilImage image, Vector2 position, Vector2 size, int rotation) {
		graphics_context.drawImage(image.image, image.spriteOffset.x, image.spriteOffset.y, image.spriteSize.x, image.spriteSize.y,  position.x, position.y, size.x, size.y);
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
	}
	
	public void draw(double dt) {
		drawImage(player.image, player.position, player.image.size, 0);
		graphics_context.setFill(Color.WHITE); 
		graphics_context.fillRect(0, 0, 192, 1); 
	}

	 public void start(Stage stage) { 
	        stage.setTitle("Space Invaders"); 
	        
	        resolution = new Vector2(192, 160);
	        aspectRatio = resolution.y / resolution.x;

	        canvas = new Canvas(); 
	        canvas.setHeight(resolution.y); 
	        canvas.setWidth(resolution.x);

	        graphics_context =  canvas.getGraphicsContext2D(); 
	        graphics_context.setFill(Color.BLACK); 
	        graphics_context.fillRect(0, 0, resolution.x, resolution.y); 

	        Group group = new Group(canvas); 
	        Scene scene = new Scene(group, resolution.x, resolution.y); 
	        stage.setScene(scene); 
	        stage.show(); 
	        
	        player = new Player(new Vector2( resolution.x / 2, 0 ), 0, resolution.x);

	        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent keyEvent) {
	            	KeyCode code = keyEvent.getCode();
	            	if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
		                if ( code == KeyCode.LEFT && player.controlDeltaX != 1) {
		                	player.controlDeltaX = -1;
		                } else if ( code == KeyCode.RIGHT && player.controlDeltaX != -1 ) {
		                	player.controlDeltaX = 1;
		                }
	            	} else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
	            		 if ( code == KeyCode.LEFT && player.controlDeltaX == -1) {
	            			 player.controlDeltaX = 0;
			              } else if ( code == KeyCode.RIGHT && player.controlDeltaX == 1 ) {
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
	                	draw(dt);
	                	clock = current_time;
	                }
	                
	            }
	        };
	        animator.start();
	  
	    } 
}

