package com.JavaProj;

import java.util.Random;

//import javafx.event.Event;

public class MoleUtils {
	public static int normal = 0;
	public static int tanker = 0;
	public static int healer = 0;
	public static int toxic = 0;
	public static int boss = 0;
	
	public static int randomizeHole() {
		return (int) (1+Math.random()*9);
	}
	
	public static int moleAtWave(int wave)
	{
		System.out.println("Wave " + wave);
		
		if(wave%10 == 0)
		{
			normal = 1;
			return 1;
		}
		
		int n = wave/10;
		int nMole = wave+(5*n)+3;
		
		switch (n)
		{
			case 0 :
				healer = 0;
				tanker = 0;
				toxic = 0;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 1 :
				healer = 0;
				tanker = 0;
				toxic = nMole/10*3;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 2 :
				healer = 0;
				tanker = 0;
				toxic = nMole/10*4;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 3 :
				healer = nMole/10*2;
				tanker = 0;
				toxic = nMole/10*2;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 4 :
				healer = 0;
				tanker = nMole/10*3;
				toxic = nMole/10*1;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 5 :
				healer = nMole/10*2;
				tanker = nMole/10*2;
				toxic = nMole/10*2;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 6 :
				healer = nMole/10*2;
				tanker = nMole/10*3;
				toxic = nMole/10*3;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 7 :
				healer = nMole/10*1;
				tanker = nMole/10*3;
				toxic = nMole/10*3;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 8 :
				healer = nMole/10*1;
				tanker = nMole/10*6;
				toxic = nMole/10*3;
				normal = nMole - healer - tanker - toxic;
				break;
				
			case 9 :
				healer = 0;
				tanker = nMole/10*6;
				toxic = nMole/10*4;
				normal = nMole - healer - tanker - toxic;
				break;
		}
		return nMole;
	}
	
	public static int moleDiversity(int wave)
	{
		Random rand = new Random();
		if(wave%10 == 0)
		{
			--normal;
			return 1;
			//return (int) 5;  	// 5 => Boss
		}
		else
		{
			int div;
			while (true)
			{
			div = 1 + rand.nextInt(4);
			
			if(div==1)
			{
				if(normal > 0)
				{
					--normal;
					return (int) 1;
				}
			}
			else if(div == 2)
			{
				if(tanker > 0)
				{
					--tanker;
					return (int) 2;
				}
			}
			else if(div == 3)
			{
				if(healer > 0)
				{
					--healer;
					return (int) 3;
				}
			}
			else if(div == 4)
			{
				if(toxic > 0)
				{
					--toxic;
					return (int) 4;
				}
			}
		}
		}
	}
	
	
	public static int maxMoleSpawn(int wave) {
		// ONLY FOR HARDCORE MODE
		int base = 2;
		if (wave > 10) base = 3;
		return base;
	}
	
	
}
