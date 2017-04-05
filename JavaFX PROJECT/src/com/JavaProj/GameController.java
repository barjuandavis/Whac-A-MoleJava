package com.JavaProj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class GameController extends VBox implements Initializable {
	
	@FXML ImageView target1;
	@FXML ImageView target2;
	@FXML ImageView target3;
	@FXML ImageView target4;
	@FXML ImageView target5;
	@FXML ImageView target6;
	@FXML ImageView target7;
	@FXML ImageView target8;
	@FXML ImageView target9;
	@FXML Label scoreLabel;
	@FXML Label lifeLabel;
	@FXML ProgressBar healthBar1;
	@FXML ProgressBar healthBar2;
	@FXML ProgressBar healthBar3;
	@FXML ProgressBar healthBar4;
	@FXML ProgressBar healthBar5;
	@FXML ProgressBar healthBar6;
	@FXML ProgressBar healthBar7;
	@FXML ProgressBar healthBar8;
	@FXML ProgressBar healthBar9;
	private long score;
	private Mole mole;
	private int life;
	private int wave;
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
	boolean[] activeHole = new boolean[10];
	
	
	public GameController(int life, long score, int wave) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("centerLayout.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	    setLife(life);
	    setScore(score);
	    setWave(wave);
	}
	
	public long getScore() {return this.score;}
	public void setScore(long x) {this.score = x;}
	public int getWave() {return this.wave;}
	public void setWave(int wave) {this.wave = wave;}
	public void setLife(int life){this.life = life;}
	public int getLife() {return this.life;} 
	
	
	
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
				System.out.println("Current mole is a BasicMole.");
			break;
			case 2:
				System.out.println("Current mole is a TankMole.");
			break;
			case 3:
				System.out.println("Current mole is a HealerMole.");
				this.life++;
			break;
			case 4: 
				System.out.println("Current mole is a ToxicMole.");
				this.life--;
			break;
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		randomizeMole();
		lifeLabel.setText("Life = "+this.life);
		scoreLabel.setText("Score = " + this.score);
		int targetHole = MoleUtils.randomizeHole();
		clearHole();
		setMoleInHole(targetHole);
	}
	
	public void setMoleInHole(int x) {
		switch(x) {
		case 1: target1.setImage(mole);
		target1.setVisible(true);
				healthBar1.setProgress(mole.getFullLife());
				if (mole.getLife()>1)
					healthBar1.setVisible(true);
				activeHole[1] = true;
				break;
		case 2: target2.setImage(mole);
		target2.setVisible(true);
		if (mole.getLife()>1)
				healthBar2.setVisible(true);
				healthBar2.setProgress(mole.getFullLife());
				activeHole[2] = true;
				break;
		case 3: target3.setImage(mole);
		target3.setVisible(true);
		if (mole.getLife()>1)
				healthBar3.setVisible(true);
				healthBar3.setProgress(mole.getFullLife());
				activeHole[3] = true;
				break;
		case 4: target4.setImage(mole);
		target4.setVisible(true);
		if (mole.getLife()>1)
				healthBar4.setVisible(true);
				healthBar4.setProgress(mole.getFullLife());
				activeHole[4] = true;
				break;
		case 5: target5.setImage(mole);
		target5.setVisible(true);
		if (mole.getLife()>1)
				healthBar5.setVisible(true);
				healthBar5.setProgress(mole.getFullLife());
				activeHole[5] = true;
				break;
		case 6: target6.setImage(mole);
		target6.setVisible(true);
		if (mole.getLife()>1)
				healthBar6.setVisible(true);
				healthBar6.setProgress(mole.getFullLife());
				activeHole[6] = true;
				break;
		case 7: target7.setImage(mole);
		target7.setVisible(true);
		if (mole.getLife()>1)
				healthBar7.setVisible(true);
				healthBar7.setProgress(mole.getFullLife());
				activeHole[7] = true;
				break;
		case 8: target8.setImage(mole);
		target8.setVisible(true);
		if (mole.getLife()>1)
				healthBar8.setVisible(true);
				healthBar8.setProgress(mole.getFullLife());
				activeHole[8] = true;
				break;
		case 9: target9.setImage(mole);
		target9.setVisible(true);
		if (mole.getLife()>1)
				healthBar9.setVisible(true);
				healthBar9.setProgress(mole.getFullLife());
				activeHole[9] = true;
				break;
		}
	}
	
	public void clearHole() {
		for (int i=1; i<=9; i++) {
			clearHole(i);
		}
		
	}
	
	public void clearHole(int i) {

		switch(i) {
		case 1: target1.setImage(null);
				target1.setVisible(false);
				activeHole[1] =false;
				healthBar1.setVisible(false);
				break;
		case 2: target2.setImage(null);
				target2.setVisible(false);
				activeHole[2] =false;
				healthBar2.setVisible(false);
				break;
		case 3: target3.setImage(null);
				target3.setVisible(false);
				activeHole[3] =false;
				healthBar3.setVisible(false);
				break;
		case 4: target4.setImage(null);
				target4.setVisible(false);
				activeHole[4] =false;
				healthBar4.setVisible(false);
				break;
		case 5: target5.setImage(null);
		target5.setVisible(false);
				activeHole[5] =false;
				healthBar5.setVisible(false);
				break;
		case 6: target6.setImage(null);
		target6.setVisible(false);
				activeHole[6] =false;
				healthBar6.setVisible(false);
				break;
		case 7: target7.setImage(null);
		target7.setVisible(false);
				activeHole[7] =false;
				healthBar7.setVisible(false);
				break;
		case 8: target8.setImage(null);
		target8.setVisible(false);
				activeHole[8] =false;
				healthBar8.setVisible(false);
				break;
		case 9: target9.setImage(null);
		target9.setVisible(false);
				activeHole[9] =false;
				healthBar9.setVisible(false);
				break;
		}
		
	}
	
	public void handle(MouseEvent e) {
		int target = 0;
		behaveGood();
		if (e.getSource() == target1 && activeHole[1] == true) {
			target = 1;
			healthBar1.setProgress((double)mole.getLife()/mole.getFullLife());
		} 
		else if (e.getSource() == target2 && activeHole[2] == true) {
			target = 2;
			healthBar2.setProgress((double)mole.getLife()/mole.getFullLife());
		} 
		else if (e.getSource() == target3 && activeHole[3] == true) {
			target = 3;
			healthBar3.setProgress((double)mole.getLife()/mole.getFullLife());
		}
		else if (e.getSource() == target4 && activeHole[4] == true) {
			target = 4;
			healthBar4.setProgress((double)mole.getLife()/mole.getFullLife());
		}
		else if (e.getSource() == target5 && activeHole[5] == true) {
			target = 5;
			healthBar5.setProgress((double)mole.getLife()/mole.getFullLife());
		}
		else if (e.getSource() == target6 && activeHole[6] == true) {
			target = 6;
			healthBar6.setProgress((double)mole.getLife()/mole.getFullLife());
		}
		else if (e.getSource() == target7 && activeHole[7] == true) {
			target = 7;
			healthBar7.setProgress((double)mole.getLife()/mole.getFullLife());
		}
		else if (e.getSource() == target8 && activeHole[8] == true) {
			target = 8;
			healthBar8.setProgress((double)mole.getLife()/mole.getFullLife());
		}
		else if (e.getSource() == target9 && activeHole[9] == true) {
			target = 9;
			healthBar9.setProgress((double)mole.getLife()/mole.getFullLife());
		}
		System.out.println("Target : " + target);
		if (target != 0) {	
		
		scoreLabel.setText("Score = " + score);
		lifeLabel.setText("Life = " + life);
		
		if (mole.isDead()) {
			clearHole(target);
			int targetHole = MoleUtils.randomizeHole();
			while(targetHole == target) targetHole = MoleUtils.randomizeHole();
			randomizeMole();
			setMoleInHole(targetHole);
			}
		}
	}
	
}
