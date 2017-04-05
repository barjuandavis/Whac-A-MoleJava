package com.JavaProj;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	Scene scene;
	GameController gc;
	
	
	void setNewNormalGame() throws IOException {
		gc = new GameController(9, 0, 1);
		scene = new Scene(gc, 640, 480);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
			setNewNormalGame();
	        stage.setResizable(false);
	        stage.setTitle("Whac-A-Mole");
	        stage.setScene(scene);
	        stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

}
