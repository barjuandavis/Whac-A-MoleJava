package com.JavaProj;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	 Scene scene;
	 GameController gc;
	 BossController bc;
	 GameOver go;
	 Menu menu;
	 NewGame game;
	 WinScreen ws;
	static Stage stage;
	
	void setNewNormalGame() {
		setGame(3,0,1,1);
	}
	
	void setNewHardGame() {
		setGame(1,0,51,2);
	}
	/*
	 * setBossGame, setNormalGame, setHardcoreGame :
	 * method-method ini gunanya untuk menginstasiasi masing-masing controller dan 
	 * memasukkan controller tsb ke dalam scene tiap kali dipanggil.
	 */
	 void setBossGame(int life, long score, int wave, int diff) {
		bc = new BossController(life,score,wave,diff);
		scene = new Scene(bc,640,480);
		stage.setScene(scene);
		bc.getBossDeadProperty().addListener(e-> {
			if (bc.getWave()==100) {
				setWinScreen(bc.getScore(), diff);
			} else
			if (bc.getMole().isDead()) {
			setGame(bc.getLife(),bc.getScore(),bc.getWave()+1,diff);
			}
		});
		bc.getLifeProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				if (bc.getLife() == 0) {
					setGameOver(bc.getWave(),bc.getScore(),diff);
				}
			}
		});
	}
	
	 void setGame(int life, long score, int wave, int diff) {
		gc = new GameController(life,score,wave,diff);
		scene = new Scene(gc,640,480);
		stage.setScene(scene);
		gc.getMolePerWaveProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				if(gc.getMolePerWave() == 0 && gc.getWave() % 10 != 0) {
					gc.setWave(gc.getWave()+1);
					gc.setMolePerWave(MoleUtils.moleAtWave(gc.getWave(),diff));
				} else
				if ((gc.getWave()) % 10 == 0) {
					setBossGame(gc.getLife(),gc.getScore(),gc.getWave(),gc.getDiff());
				}
			}
		});
		gc.getLifeProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				if (gc.getLife() == 0) {
					setGameOver(gc.getWave(),gc.getScore(),gc.getDiff());
				}

			}
		});
		
	}
	
	 
	 
	 void setGameOver(int wave, long score, int diff) {
		go = new GameOver(wave, score, diff);
		scene = new Scene(go,640,480);
		stage.setScene(scene);
		go.getBackToMenuProperty().addListener(e->{
			setMainMenu();
		});
	}
	 
	void setWinScreen (long score, int diff) {
		ws = new WinScreen (score, diff);
		scene = new Scene (ws,640,480);
		stage.setScene(scene);
		ws.getBackToMenuProperty().addListener(e->{
			setMainMenu();
		});
	}
	 
	 void setDifficulty() {
		game = new NewGame();
		scene = new Scene(game,640,480);
		stage.setScene(scene);
		game.getNewGameClickedProperty().addListener(e-> {
			if (game.getNewGameClickedProperty().get() == 1) {
				setNewNormalGame();
			} else if (game.getNewGameClickedProperty().get() == 2) {
				setNewHardGame();
			} else if (game.getNewGameClickedProperty().get() == 3) {
				setMainMenu();
			}
		});
	}
	
	void setMainMenu() {
		menu = new Menu();
		scene = new Scene(menu, 640, 480);
		menu.getMenuClickedProperty().addListener(e-> {
			if (menu.getMenuClickedProperty().get() == 1) {
				setDifficulty();				
			} else if(menu.getMenuClickedProperty().get() == 2) {
					//System.out.println("Trying to close");
					System.exit(0);
			}
		});
		Main.stage.setScene(scene);	
	}
	
	
	@Override  
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
			Main.stage = stage;
			setMainMenu();
			
			Main.stage.setMaxHeight(480);
			Main.stage.setMaxWidth(640);
	        Main.stage.setResizable(false);
	        
	        Main.stage.setTitle("Whac-A-Mole");
	        Main.stage.setScene(scene);
	        Main.stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

}
