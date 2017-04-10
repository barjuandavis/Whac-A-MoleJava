package com.JavaProj;


import java.io.InputStream;
import javafx.scene.image.Image;

public class Mole extends Image {
    private int life; // how much hit needed to kill a specific mole
    private long lifeTime; //in msecs
    private long bounty;
    private int moleID;
    private int fullLife;
    //private String ImageURL;
    
    public Mole(int life, long lifeTime, long bounty,int moleID, InputStream ImageIS) {
    	super(ImageIS);
    	setLife(life);
    	setLifeTime(lifeTime);
    	setBounty(bounty);
    	setMoleID(moleID);
    	setFullLife(life);
    }
    
    
    public int getLife() {return this.life;}
    public void setLife(int life) {this.life = life;}
    public long getLifeTime() {return this.life;}
    public void setLifeTime(long life) {this.lifeTime = life;}
    public boolean isDead(){return (life == 0);}
    public long getBounty() {return this.bounty;}
    public void setBounty(long bounty) {this.bounty = bounty;}
	public int getMoleID() {return this.moleID;}
	private void setMoleID(int moleID) {this.moleID = moleID;}
	public int getFullLife() {return this.fullLife;}
	private void setFullLife(int fullLife) {this.fullLife = fullLife;} 
  
}
