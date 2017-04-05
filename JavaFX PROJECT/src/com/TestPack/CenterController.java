package com.TestPack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class CenterController extends SplitPane implements Initializable {
		@FXML
		Button sebuahButton;
		
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
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			
		}
		
		public void handle(ActionEvent e) {
			if (e.getSource() == sebuahButton) {
				fxmlLoader = new FXMLLoader(getClass().getResource("centerLayout.fxml"));
				AnotherController x = new AnotherController();
				fxmlLoader.setRoot(x);
				fxmlLoader.setController(x);
				try {
					fxmlLoader.load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}