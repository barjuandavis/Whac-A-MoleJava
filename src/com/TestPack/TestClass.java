package com.TestPack;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TestClass extends Application {

	Scene mainScene;
	
	AnotherController x;
	
	@Override
	public void start(Stage stage) throws Exception {
		CenterController a = new CenterController();
		mainScene = new Scene(a,600,400);
		
		
		
		
		stage.setScene(mainScene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}

