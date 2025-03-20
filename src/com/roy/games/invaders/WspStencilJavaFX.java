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

public class WspStencilJavaFX extends Application implements WspStencil {
	public Vector2 scaleMultiplier;
	public float aspectRatio;
	public Vector2 resolution;
	
	
	public WspStencilJavaFX(Vector2 newResolution) {
		this.resolution = newResolution;
	}
	
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
	        canvas.setHeight(192); 
	        canvas.setWidth(160); 
	  
	        // graphics context 
	        GraphicsContext graphics_context =  
	            canvas.getGraphicsContext2D(); 
	  
	        // set fill for rectangle 
	        graphics_context.setFill(Color.BLACK); 
	        graphics_context.fillRect(0, 0, 160, 192); 
	  
	        // create a Group 
	        Group group = new Group(canvas); 
	  
	        // create a scene 
	        Scene scene = new Scene(group, 192, 160); 
	  
	        // set the scene 
	        stage.setScene(scene); 
	  
	        stage.show(); 
	    } 
}
