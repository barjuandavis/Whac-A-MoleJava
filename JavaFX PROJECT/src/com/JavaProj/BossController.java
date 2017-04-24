package com.JavaProj;

import java.io.IOException;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BossController extends AnchorPane {
	
	@FXML private ImageView targetBoss;
	@FXML private Label lifeLabel;
	@FXML private Label scoreLabel;
	@FXML private Label waveLabel;
	@FXML private ProgressBar timeBar;
	@FXML private ProgressBar healthBar;
	
	private long score;
	private IntegerProperty life = new SimpleIntegerProperty(this,"life",0);
	private BooleanProperty isBossDead = new SimpleBooleanProperty(this,"isBossDead",false);
	private Mole mole;
	private int wave;
	private Service<Void> waitDelay;
//private Thread aThread;
//	private boolean activeHole = false;
	
	public long getScore() {return this.score;}
	public void setScore(long x) {this.score = x;}
	public int getWave() {return this.wave;}
	public void setWave(int wave) {this.wave = wave;waveLabel.setText("Wave " + getWave());}
	public Mole getMole() {return mole;}
	public void setLife(int life){this.life.set(life);}
	public int getLife() {return this.life.get();}
	public BooleanProperty getBossDeadProperty() {return this.isBossDead;}
	protected void setBossDead(boolean x) {this.isBossDead.set(x);}
	public IntegerProperty getLifeProperty() {return this.life;}
	public Service<Void> getWaitDelayService() {return waitDelay;}
	
	public BossController(int life, long score,int wave){
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bossLayout.fxml"));
		    fxmlLoader.setRoot(this);
		    fxmlLoader.setController(this);
		    try {
		        fxmlLoader.load();
		      //  System.out.println("fxml loaded!");
		    } catch (IOException exception) {
		        throw new RuntimeException(exception);
		    }
	//	System.out.println(wave);
		setBoss(wave);
		setWave(wave);
		setScore(score);
		setLife(life);
		lifeLabel.setText("Life = "+ getLife());
		scoreLabel.setText("Score = " + getScore());
		waitDelay = new Service<Void>() {
			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call()  {
						
						if (getLife() > 0) {
					//	System.out.println(mole.getLifeTime());
						for (long i=mole.getLifeTime(); i>=0; i--) {
							try {
							updateMessage("Life = "+getLife());
							updateProgress(i,mole.getLifeTime());
							Thread.sleep(1);
							new Thread(this).start();
							if (i == 0) {
								if (getLife() > 1) {setLife(getLife()-1);	
								 i = mole.getLifeTime();
								} else {
									setLife(getLife()-1);
									}
								}
								
							} catch (InterruptedException e) {
								if (isCancelled()) {
								timeBar.progressProperty().unbind();
								return null;
								}
							}
						  }
						}
						return null;	
					}
				};
			}
		};
		waitDelay.setOnSucceeded(e->{
			setLife(getLife()-1);		
			});
		timeBar.progressProperty().bind(waitDelay.progressProperty());
		lifeLabel.textProperty().bind(waitDelay.messageProperty());
		waitDelay.restart();
		//new Thread((Runnable) waitDelay).start();
	}
	
	
	public void setBoss(int wave){
		wave = wave/10;
		switch(wave) {
		case 1: mole = new BossMole(getClass().getResourceAsStream("Boss1.png")); break;
		case 2: mole = new BossMole(getClass().getResourceAsStream("Boss2.png")); break;
		case 3: mole = new BossMole(getClass().getResourceAsStream("Boss3.png"));break;
		case 4: mole = new BossMole(getClass().getResourceAsStream("Boss4.png"));break;
		case 5: mole = new BossMole(getClass().getResourceAsStream("Boss5.png"));break;
		case 6: mole = new BossMole(getClass().getResourceAsStream("Boss6.png"));break;
		case 7: mole = new BossMole(getClass().getResourceAsStream("Boss7.png"));break;
		case 8: mole = new BossMole(getClass().getResourceAsStream("Boss8.png"));break;
		case 9: mole = new BossMole(getClass().getResourceAsStream("Boss9.png"));break;
		case 10: mole = new BossMole(getClass().getResourceAsStream("Boss10.png"));break;
		}
		targetBoss.setImage(mole);
		healthBar.setProgress(mole.getFullLife());
		
	}
	
	public void behaveGood() { //when HIT
		mole.setLife(mole.getLife()-1);
		if (mole.isDead()) {
		score += mole.getBounty();
		setBossDead(true);
		}
	}
	
	
	
	public void setMoleInHole() {
		targetBoss.setImage(mole);
		targetBoss.setVisible(true);
		healthBar.setProgress(mole.getFullLife());
		if (mole.getLife()>1)
			healthBar.setVisible(true);
	//	activeHole = true;
	}
		
	public void clearHole() {

		targetBoss.setImage(null);
		targetBoss.setVisible(false);
		//activeHole = false;
		healthBar.setVisible(false);		
	}
	
	public void handle(MouseEvent e) {
		behaveGood();
		if (e.getSource() == targetBoss) {
			healthBar.setProgress((double)mole.getLife()/mole.getFullLife());
		} 		
		if (mole.isDead()) {
			scoreLabel.setText("Score = " + score);
			waitDelay.cancel();
			}
		}
	
}
