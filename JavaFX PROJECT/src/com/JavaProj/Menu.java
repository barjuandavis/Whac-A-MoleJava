package com.JavaProj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class Menu extends AnchorPane {
	
	@FXML ImageView cloud;
	@FXML Button start;
	@FXML Button highScore;
	@FXML Button exit;
	
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
	    	System.out.println("Nicky haha");
	    	
	    });
	    
	    highScore.setOnAction(e -> {
	    	System.out.println("Nicky hehe");
	    	
	    });
	    
	    exit.setOnAction(e -> {
	    	System.out.println("Nicky hoho");
	    	
	    });
	}
	
}
