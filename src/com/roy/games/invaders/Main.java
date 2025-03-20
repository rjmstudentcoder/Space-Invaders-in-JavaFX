package com.roy.games.invaders;

import com.roy.util.whisp.WspStencil;
import com.roy.util.whisp.Vector2;

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
	
	 public void start(Stage stage) 
	    { 
	        // set title for the stage 
	        stage.setTitle("creating canvas"); 
	  
	        // create a canvas 
	        Canvas canvas = new Canvas(); 
	  
	        // set height and width 
	        canvas.setHeight(400); 
	        canvas.setWidth(400); 
	  
	        // graphics context 
	        GraphicsContext graphics_context =  
	            canvas.getGraphicsContext2D(); 
	  
	        // set fill for rectangle 
	        graphics_context.setFill(Color.PINK); 
	        graphics_context.fillRect(40, 40, 100, 100); 
	  
	        // set fill for rectangle 
	        graphics_context.setFill(Color.RED); 
	        graphics_context.fillRect(20, 20, 70, 70); 
	  
	        // set fill for oval 
	        graphics_context.setFill(Color.BLUE); 
	        graphics_context.fillOval(30, 30, 70, 70); 
	  
	        // create a Group 
	        Group group = new Group(canvas); 
	  
	        // create a scene 
	        Scene scene = new Scene(group, 400, 400); 
	  
	        // set the scene 
	        stage.setScene(scene); 
	  
	        stage.show(); 
	    } 
}

