package com.JavaProj;

import java.io.IOException;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GameOver extends AnchorPane{
	@FXML private Label lastWave;
	@FXML private Label lastScore;
	
	HighScoreController hs = new HighScoreController();
	
	private BooleanProperty backToMenuProperty = new SimpleBooleanProperty(this,"backToMenu",false);
	public BooleanProperty getBackToMenuProperty() {return this.backToMenuProperty;}
	@FXML
	public void backToMenuSignal() {
		backToMenuProperty.set(true);
	}
	public GameOver(int wave, long score, int diff) {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameOverLayout.fxml"));
		    fxmlLoader.setRoot(this);
		    fxmlLoader.setController(this);
		    try {
		        fxmlLoader.load();
		        if (diff==1)
		        {
		        	lastWave.setText("Last Wave : " + wave);
			        lastScore.setText("Score : " + score);
		        } else {
		        	lastWave.setText("Last Wave : " + (wave-50));
			        lastScore.setText("Score : " + score);
		        }
		    } catch (IOException exception) {
		        throw new RuntimeException(exception);
		    }
		    
		    hs.setTopScore(wave, score, diff);
		}
}
