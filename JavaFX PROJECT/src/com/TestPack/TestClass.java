package com.TestPack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestClass extends Application {

	Scene mainScene;
	
	AnotherController x;
	
	@Override
	public void start(Stage stage) throws Exception {
		CenterController a = new CenterController();
		mainScene = new Scene(a,600,400);
		Scene anotherScene;
		VBox change = new VBox();
		Label aLabel = new Label("GAME OVER :(");
		aLabel.setFont(Font.font("Calibri", 40));
		change.getChildren().add(aLabel);
		anotherScene= new Scene(change,600,400);
		
		a.getScoreProp().addListener(e -> {
			if (a.getScore() % 10 == 0) {
				System.out.println("WULULULULULU");
				stage.setScene(anotherScene);
			}
			
		});
		stage.setScene(mainScene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}

