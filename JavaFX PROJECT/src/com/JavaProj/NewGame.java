package com.JavaProj;

import java.io.IOException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class NewGame extends AnchorPane {
	
	@FXML Button casual;
	@FXML Button hardCore;
	@FXML Button back;
	
	IntegerProperty gameClicked = new SimpleIntegerProperty(this, "diffChosen", 0);
	
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
	    	//gc.setWave(1);
	    	gameClicked.set(1);
	    });
	    
	    hardCore.setOnAction(e -> {
	    	gameClicked.set(2);
	    });
	    
	    back.setOnAction(e -> {
	    	gameClicked.set(3);	    	
	    });
	}

	public IntegerProperty getNewGameClickedProperty() {
		return gameClicked;
	}
}
