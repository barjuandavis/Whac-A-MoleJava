package com.JavaProj;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class TopController extends HBox {
		public TopController() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layoutAtas.fxml"));
		    fxmlLoader.setRoot(this);
		    fxmlLoader.setController(this);
		    try {
		        fxmlLoader.load();
		    } catch (IOException exception) {
		        throw new RuntimeException(exception);
		    }
		}
	}