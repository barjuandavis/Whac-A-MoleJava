package com.TestPack;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

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


public class CenterController extends SplitPane {
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
			if (e.getSource() == button[1]) {
				setScore(getScore()+1);
				int x = getScore();
				System.out.println("Button ID : 1" );
				sebuahLabel.setText("Score " + x);
				}
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