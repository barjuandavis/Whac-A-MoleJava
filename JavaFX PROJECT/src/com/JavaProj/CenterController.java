package com.JavaProj;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class CenterController extends VBox {
		public CenterController() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("centerLayout.fxml"));
		    fxmlLoader.setRoot(this);
		    fxmlLoader.setController(this);
		    try {
		        fxmlLoader.load();
		    } catch (IOException exception) {
		        throw new RuntimeException(exception);
		    }
		}
		
	}