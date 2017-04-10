package com.JavaProj;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class NewGame extends AnchorPane {
	
	@FXML Button casual;
	@FXML Button hardCore;
	@FXML Button back;
	
	public NewGame() {
		

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewGame.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	    
	    casual.setOnAction(e -> {
	    	System.out.println("casual mode");
	    	
	    });
	    
	    hardCore.setOnAction(e -> {
	    	System.out.println("hardcore mode");
	    	
	    });
	    
	    back.setOnAction(e -> {
	    	System.out.println("back to menu");
	    	
	    });
	}
}
