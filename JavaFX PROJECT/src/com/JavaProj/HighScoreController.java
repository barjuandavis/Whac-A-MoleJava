package com.JavaProj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScoreController {
	private int currWave;
	private long currScore;
	private int topCasualWave;
	private int topHardWave;
	private long topCasualScore;
	private long topHardScore;
	
	
	public void setCurrentScore (int wave, long score) {
		this.currWave = wave;
		this.currScore = score;
	}
	
	public long getTopCasualScore () {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return topCasualScore;
	}
	public long getTopHardScore () {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return topHardScore;
	}
	
	public int getTopCasualWave () {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(this.topCasualWave);
		return this.topCasualWave;
	}
	
	public int getTopHardWave () {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(this.topHardWave);
		return this.topHardWave;
	}
	
	public void setTopScore (int wave, long score, int diff) {
		if (diff==1) 
		{
			getTopCasualScore();
			setCurrentScore (wave, score);
			if (currScore > topCasualScore) {
				this.topCasualScore = currScore;
				this.topCasualWave = currWave;
				System.out.println("New highscore!");
				writeFile();
			}
		} else {
			getTopHardScore();
			setCurrentScore (wave, score);
			if (currScore > topHardScore) {
				this.topHardScore = currScore;
				this.topHardWave = currWave-50;
				System.out.println("New highscore!");
				writeFile();
			}
		}
		
	}
	
	public void readFile () throws FileNotFoundException {
		InputStream inputFile = getClass().getResourceAsStream("score.txt");
		Scanner read = new Scanner (inputFile);
		read.useDelimiter(",");
		
		while (read.hasNext()) {
			String tempWave1 = read.next();
			String tempScore1 = read.next();
			String tempWave2 = read.next();
			String tempScore2 = read.next();
			this.topCasualWave = Integer.parseInt(tempWave1.trim());
			this.topCasualScore = Long.parseLong(tempScore1.trim());
			this.topHardWave = Integer.parseInt(tempWave2.trim());
			this.topHardScore = Long.parseLong(tempScore2.trim());
		}
		
		read.close();
	}
	
	public void writeFile () {
		try {
			PrintWriter writer = new PrintWriter ("bin/com/JavaProj/score.txt", "UTF-8");
			writer.println(this.topCasualWave+","+this.topCasualScore+","+this.topHardWave+","+this.topHardScore);
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	
}
