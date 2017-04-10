package com.JavaProj;

//import javafx.event.Event;

public class MoleUtils {
	public static int randomizeHole() {
		return (int) (1+Math.random()*9);
		
	}
	
	public static int moleAtWave(int wave) {
		final int baseMole = 10;
		return (baseMole+wave);
	}
	
	public static int moleDiversity(int wave) {
		final int low = 1;
		int hi = 3;
		if (wave > 10) {
			hi = 4;
		}
		return (int) (Math.random() * (hi - low)) + low;
	}
	
	public static int maxMoleSpawn(int wave) {
		// ONLY FOR HARDCORE MODE
		int base = 2;
		if (wave > 10) base = 3;
		return base;
	}
	
	
}
