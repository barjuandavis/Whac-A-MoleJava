package com.JavaProj;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

public class Hole {
	private ImageView target;
	private ProgressBar healthBar;
	private Mole mole;
	
	public Hole(Mole mole) {
		setMole(mole);
	}

	public Mole getMole() {
		return mole;
	}

	public void setMole(Mole mole) {
		this.mole = mole;
		target.setImage(mole);
		healthBar.setProgress((double)mole.getLife()/mole.getFullLife());
		if (this.mole.getFullLife() <= 1) healthBar.setVisible(false);
	}
	
	public void giveDamage() {
		this.mole.setLife(this.mole.getLife()-1);
		healthBar.setProgress((double)this.mole.getLife()/this.mole.getFullLife());
	}
	
	public void clearHole() {
		target.setImage(null);
		this.mole = null;
		healthBar.setProgress(0);
		healthBar.setVisible(false);
	}

}
