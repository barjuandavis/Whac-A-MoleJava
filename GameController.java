package com.JavaProj;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class GameController extends VBox {
	
	@FXML private ImageView target1;
	@FXML private ImageView target2;
	@FXML private ImageView target3;
	@FXML private ImageView target4;
	@FXML private ImageView target5;
	@FXML private ImageView target6;
	@FXML private ImageView target7;
	@FXML private ImageView target8;
	@FXML private ImageView target9;
	@FXML private Label scoreLabel;
	@FXML private Label lifeLabel;
	@FXML private Label moleLabel;
	@FXML private Label waveLabel;
	@FXML private ProgressBar healthBar1;
	@FXML private ProgressBar healthBar2;
	@FXML private ProgressBar healthBar3;
	@FXML private ProgressBar healthBar4;
	@FXML private ProgressBar healthBar5;
	@FXML private ProgressBar healthBar6;
	@FXML private ProgressBar healthBar7;
	@FXML private ProgressBar healthBar8;
	@FXML private ProgressBar healthBar9;
	ImageView[] target = new ImageView[10];
	ProgressBar[] healthBar = new ProgressBar[10];
	Hole[] hole = new Hole[10];
	private long score;
	private Mole mole;
	//private int life;
	private IntegerProperty life = new SimpleIntegerProperty(this, "life");
	private int wave;
	private IntegerProperty molePerWave = new SimpleIntegerProperty(this, "molePerWave");
	/*
	 * MoleID :
	 * 1 = BasicMole
	 * 2 = TankMole
	 * 3 = HealerMole
	 * 4 = ToxicMole
	 * 
	 * 
	 * 
	 */
	private boolean[] activeHole = new boolean[10];
	
	
	public GameController(int life, long score, int wave) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("centerLayout.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	   setStyle(getStyle() + " -fx-background-image: url(file:///D:/Java_workspace/JavaFX%20PROJECT/src/com/JavaProj/BG.jpg) ");
	    setLife(life);
	    setScore(score);
	    setWave(wave);
	    setMolePerWave(MoleUtils.moleAtWave(wave));
	    lifeLabel.setText("Life = " + getLife());
		scoreLabel.setText("Score = " + getScore());
		moleLabel.setText("Mole = " + getMolePerWave());
		waveLabel.setText("Wave " + getWave());
		target[1] = target1;target[2] = target2;target[3] = target3;target[4] = target4;target[5] = target5;target[6] = target6;target[7] = target7; target[8] = target8;target[9] = target9;
		healthBar[1] = healthBar1; healthBar[2] = healthBar2; healthBar[3] = healthBar3; healthBar[4] = healthBar4; healthBar[5] = healthBar5; healthBar[6] = healthBar6; healthBar[7] = healthBar7;healthBar[8] = healthBar8;healthBar[9] = healthBar9;
		randomizeMole();
		int targetHole = MoleUtils.randomizeHole();
		clearHole();
		setMoleInHole(targetHole);
	}
	
	public long getScore() {return this.score;}
	public void setScore(long x) {this.score = x;}
	public int getWave() {return this.wave;}
	public void setWave(int wave) {this.wave = wave;waveLabel.setText("Wave " + getWave());}
	public int getMolePerWave() {return molePerWave.get();}
	public void setMolePerWave(int molePerWave) {this.molePerWave.set(molePerWave);}
	public IntegerProperty getMolePerWaveProperty() {return this.molePerWave;}
	public void setLife(int life){this.life.set(life);}
	public int getLife() {return this.life.get();}
	public IntegerProperty getLifeProperty() {return this.life;}
	
	public void randomizeMole() {
		int choose = MoleUtils.moleDiversity(wave);
		
		//System.out.println(choose);
		try {
		switch(choose) {
		case 1: mole = new BasicMole(getClass().getResourceAsStream("BasicMole.png")); break;
		case 2: mole = new TankMole(getClass().getResourceAsStream("TankMole.png")); break;
		case 3: mole = new HealerMole(getClass().getResourceAsStream("HealerMole.png"));break;
		case 4: mole = new ToxicMole(getClass().getResourceAsStream("ToxicMole.png"));break;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Not found : " + mole.isError());
			//e.printStackTrace(); // jangan lupa diapus yaaa :)
		}
	}
	
	public void behaveGood() { //when HIT
		mole.setLife(mole.getLife()-1);
		if (mole.isDead()) {
		score += mole.getBounty();
		switch(mole.getMoleID()) {
			case 1: 
			//	System.out.println("Current mole is a BasicMole.");
			break;
			case 2:
				//System.out.println("Current mole is a TankMole.");
			break;
			case 3:
				//System.out.println("Current mole is a HealerMole.");
				setLife(getLife()+1);
			break;
			case 4: 
				//System.out.println("Current mole is a ToxicMole.");
				setLife(getLife()-1);
			break;
			}
		}
	}
	
	public void setMoleInHole(int x) {
		if (getMolePerWave() > 0) {
		target[x].setImage(mole);
		target[x].setVisible(true);
		healthBar[x].setProgress(mole.getFullLife());
		if (mole.getLife()>1) healthBar[x].setVisible(true);
		activeHole[x] = true;
		}
	}
	
	public void clearHole() {
		for (int i=1; i<=9; i++) {
			clearHole(i);
		}
		
	}
	
	public void clearHole(int i) {
		target[i].setImage(null);
		target[i].setVisible(false);
		activeHole[i] =false;
		healthBar[i].setVisible(false);	
	}
	
	public void handle(MouseEvent e) {
		int tar = 0;
		for (int i=1; i<=9; i++) {
			if (e.getSource() == target[i]) {
				tar = i;
				break;
			}
		}
		behaveGood();
		if (activeHole[tar] == true) {
			healthBar[tar].setProgress((double)mole.getLife()/mole.getFullLife());
		} 
		//System.out.println("Target : " + target);
		if (tar != 0) {	
		scoreLabel.setText("Score = " + getScore());
		lifeLabel.setText("Life = " + getLife());
		if (mole.isDead()) {
			clearHole(tar);
			setMolePerWave(getMolePerWave()-1);
			moleLabel.setText("Mole = " + getMolePerWave());
			int targetHole = MoleUtils.randomizeHole();
			while(targetHole == tar) targetHole = MoleUtils.randomizeHole();
			randomizeMole();
			setMoleInHole(targetHole);
			}
		}
	}
	
}
