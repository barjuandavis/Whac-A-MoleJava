package com.JavaProj;

import java.util.Random;

//import javafx.event.Event;

public class MoleUtils {
	public static int normal = 0;
	public static int tanker = 0;
	public static int healer = 0;
	public static int toxic = 0;
	public static int boss = 0;
	static GameController gc;
	
	public static int moleLT = 3000;
	public static int bossLT = 30000;
	
	public static int randomizeHole() {
		return (int) (1+Math.random()*9);
	}
	
	public static int moleAtWave(int wave, int diff)
	{
		//System.out.println("Wave " + wave);
		
		int nMole; 
		
		if (diff==1)
		{
			if(wave%10 == 0)
			{
				normal = 1;
				bossLT = 30000-(wave*20);
				return 1;
			}
			
			int n = wave/10;
			nMole = wave+(5*n)+3;
			moleLT = 3000- (wave*20);
			
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
		} else {
			if(wave%10 == 0)
			{
				normal = 1;
				bossLT = 25000-(wave*20);
				return 1;
			}
			
			int n = wave/10;
			nMole = wave+(5*n)+5;
			moleLT = 3000- (wave*30);
			
			switch (n)
			{
				case 5 :
					healer = 0;
					tanker = nMole/10*4;
					toxic = nMole/10*3;
					normal = nMole - healer - tanker - toxic;
					break;
					
				case 6 :
					healer = 0;
					tanker = nMole/10*4;
					toxic = nMole/10*4;
					normal = nMole - healer - tanker - toxic;
					break;
					
				case 7 :
					healer = 0;
					tanker = nMole/10*5;
					toxic = nMole/10*4;
					normal = nMole - healer - tanker - toxic;
					break;
					
				case 8 :
					healer = 0;
					tanker = nMole/10*6;
					toxic = nMole/10*4;
					normal = nMole - healer - tanker - toxic;
					break;
					
				case 9 :
					healer = 0;
					tanker = nMole/10*6;
					toxic = nMole/10*6;
					normal = nMole - healer - tanker - toxic;
					break;
			}
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
					System.out.println(normal);
					return (int) 1;
				}
			}
			else if(div == 2)
			{
				if(tanker > 0)
				{
					--tanker;
					System.out.println(tanker);
					return (int) 2;
				}
			}
			else if(div == 3)
			{
				if(healer > 0)
				{
					--healer;
					System.out.println(healer);
					return (int) 3;
				}
			}
			else if(div == 4)
			{
				if(toxic > 0)
				{
					--toxic;
					System.out.println(toxic);
					return (int) 4;
				}
			}
		}
		}
	}
	
	public static long getLifeTime(int wave) {
		return (moleLT-wave*15);
	}
	
	public static long getBossLifeTime(int wave) {
		return (bossLT-wave*15);
	}
}
