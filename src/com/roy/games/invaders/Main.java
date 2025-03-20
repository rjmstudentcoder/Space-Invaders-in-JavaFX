package com.roy.games.invaders;

import com.roy.util.whisp.WspStencil;
import com.roy.util.whisp.Vector2;

import javafx.animation.AnimationTimer;
import javafx.application.Application; 
import javafx.scene.Scene; 
//import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 
import javafx.event.ActionEvent; 
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
	public float i;
	
	public void drawImage(String image, Vector2 position, Vector2 size, int rotation) {
		
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
		i += dt * 100;
	}
	
	public void draw(double dt) {
		graphics_context.setFill(Color.WHITE); 
		graphics_context.fillRect(0, 0, 192, i); 
	}

	 public void start(Stage stage) { 
	        stage.setTitle("Space Invaders"); 

	        canvas = new Canvas(); 
	        canvas.setHeight(160); 
	        canvas.setWidth(192); 

	        graphics_context =  canvas.getGraphicsContext2D(); 
	        graphics_context.setFill(Color.BLACK); 
	        graphics_context.fillRect(0, 0, 192, 160); 

	        Group group = new Group(canvas); 
	        Scene scene = new Scene(group, 192, 160); 
	        stage.setScene(scene); 
	        stage.show(); 
		        
	        i = 0; // Remove later.
	       
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

