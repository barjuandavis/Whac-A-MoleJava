package com.JavaProj;

import java.io.IOException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class Menu extends AnchorPane {
	
	@FXML ImageView cloud;
	@FXML Button start;
	@FXML Label highScore;
	@FXML Label wave;
	@FXML Button exit;
	
	IntegerProperty menuClicked = new SimpleIntegerProperty(this, "menuChosen", 0);
	
	HighScoreController hs = new HighScoreController();
	
	public Menu() { 
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	    
	    start.setOnAction(e -> {
	    	//gc.setWave(1);
	    	menuClicked.set(1);
	    });
	    
	    highScore.setText("Highscore : "+ hs.getTopScore());
	    wave.setText("Wave : " + hs.getTopWave());
	    exit.setOnAction(e -> {
	    	menuClicked.set(2);
	    });
	}
	
	public IntegerProperty getMenuClickedProperty() {
		return menuClicked;
	}
	
}
