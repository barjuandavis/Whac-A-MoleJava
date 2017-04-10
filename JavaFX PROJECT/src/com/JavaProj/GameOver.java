package com.JavaProj;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GameOver extends AnchorPane{
	@FXML Label lastWave;
	@FXML Label lastScore;
	
	public GameOver(int wave, long score) {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameOverLayout.fxml"));
		    fxmlLoader.setRoot(this);
		    fxmlLoader.setController(this);
		    try {
		        fxmlLoader.load();
		        lastWave.setText("Last Wave : " + wave);
		        lastScore.setText("Score : " + score);
		    } catch (IOException exception) {
		        throw new RuntimeException(exception);
		    }
		}
}
