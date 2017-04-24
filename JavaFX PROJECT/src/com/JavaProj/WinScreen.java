package com.JavaProj;

import java.io.IOException;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class WinScreen extends AnchorPane{
	@FXML private Label lastScore;
	
	HighScoreController hs = new HighScoreController();
	
	private BooleanProperty backToMenuProperty = new SimpleBooleanProperty(this,"backToMenu",false);
	public BooleanProperty getBackToMenuProperty() {return this.backToMenuProperty;}
	@FXML
	public void backToMenuSignal() {
		backToMenuProperty.set(true);
	}
	
	public WinScreen (long score) {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WinScreen.fxml"));
		    fxmlLoader.setRoot(this);
		    fxmlLoader.setController(this);
		    try {
		        fxmlLoader.load();
		        lastScore.setText("Score : " + score);
		    } catch (IOException exception) {
		        throw new RuntimeException(exception);
		    }
		    
		    hs.setTopScore(100, score);
		}
}
