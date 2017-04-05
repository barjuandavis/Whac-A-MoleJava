package com.TestPack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class AnotherController extends VBox implements Initializable {

	
	public AnotherController() {
		System.out.println("Called");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("centerLayout.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    try {
	        fxmlLoader.load();
	        System.out.println("Loaded");
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
