package com.TestPack;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class CenterController extends AnchorPane{
		@FXML Button sebuahButton;
		
		Button[] button = new Button[10];
		//button[1] = new Button();
		private IntegerProperty scoreProp = new SimpleIntegerProperty(this, "score",0);
		
		@FXML Label sebuahLabel;
		
		FXMLLoader fxmlLoader;
		
		public CenterController() {
		  fxmlLoader = new FXMLLoader(getClass().getResource("centerLayout2.fxml"));
		    fxmlLoader.setRoot(this);
		    fxmlLoader.setController(this);
		    try {
		        fxmlLoader.load();
		    } catch (IOException exception) {
		        throw new RuntimeException(exception);
		    }
		    button[1] = sebuahButton;
		    
		    
		}
		
		public void handle(ActionEvent e) {
			TranslateTransition tt = new TranslateTransition(Duration.millis(500), sebuahButton);
		     tt.setToY(-100);
		     //tt.setCycleCount((int) 4f);
		     System.out.println("Before Play : "+sebuahButton.getLayoutY());
		     tt.play();
		     tt = new TranslateTransition(Duration.millis(500), sebuahButton);
		     tt.setFromY(-100);
		     tt.setDelay(Duration.millis(1000));
		     tt.setToY(0);
		     tt.play();
			
		}

		public IntegerProperty getScoreProp() {
			return scoreProp;
		}

		public void setScore(int x) {
			this.scoreProp.set(x);
		}
		
		public int getScore() {
			return this.scoreProp.get();
			
		}
		
	}