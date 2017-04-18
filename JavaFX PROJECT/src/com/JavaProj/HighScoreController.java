package com.JavaProj;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScoreController {
	private int currWave;
	private long currScore;
	private int topWave;
	private long topScore;
	
	
	public void setCurrentScore (int wave, long score) {
		this.currWave = wave;
		this.currScore = score;
	}
	
	public long getTopScore () {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return topScore;
	}
	
	public int getTopWave () {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(this.topWave);
		return this.topWave;
	}
	
	public void setTopScore (int wave, long score) {
		getTopScore();
		setCurrentScore (wave, score);
		if (currScore > topScore) {
			this.topScore = currScore;
			this.topWave = currWave;
			System.out.println("New highscore!");
			writeFile();
		}
	}
	
	public void readFile () throws FileNotFoundException {
		InputStream inputFile = getClass().getResourceAsStream("score.txt");
		Scanner read = new Scanner (inputFile);
		read.useDelimiter(",");
		
		while (read.hasNext()) {
			String tempWave = read.next();
			String tempScore = read.next();
			this.topWave = Integer.parseInt(tempWave.trim());
			this.topScore = Long.parseLong(tempScore.trim());
		}
		
		read.close();
	}
	
	public void writeFile () {
		try {
			PrintWriter writer = new PrintWriter ("bin/com/JavaProj/score.txt", "UTF-8");
			writer.println(this.topWave+" , "+this.topScore);
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	
}
