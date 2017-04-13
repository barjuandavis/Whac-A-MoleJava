package com.JavaProj;

import java.util.Random;

// Hardcore Mode
public class MoleUtils2 {
	public static int normal = 0;
	public static int tanker = 0;
	public static int healer = 0;
	public static int toxic = 0;
	public static int boss = 0;
	
	public static int moleLT = 2000;
	public static int bossLT = 20000;
	
	public static int randomizeHole() {
		return (int) (1+Math.random()*9);
	}
	
	public static int moleAtWave(int wave)
	{
		System.out.println("Wave " + wave);
		
		if(wave%10 == 0)
		{
			normal = 1;
			bossLT = 20000;
			return 1;
		}
		
		int n = wave/10;
		int nMole = wave+(5*n)+10;
		moleLT = 2000- (wave*15);
		
		switch (n)
		{
			case 0 :
				healer = 0;
				toxic = 0;
				tanker = nMole - healer - toxic;
				break;
				
			case 1 :
				healer = 0;
				toxic = nMole/10*1;
				tanker = nMole - healer - toxic;
				break;
				
			case 2 :
				healer = 0;
				toxic = nMole/10*2;
				tanker = nMole - healer - toxic;
				break;
				
			case 3 :
				healer = nMole/10*1;
				toxic = nMole/10*2;
				tanker = nMole - healer - toxic;
				break;
				
			case 4 :
				healer = 0;
				toxic = nMole/10*1;
				tanker = nMole - healer - toxic;
				break;
				
			case 5 :
				healer = nMole/10*2;
				toxic = nMole/10*2;
				tanker = nMole - healer - toxic;
				break;
				
			case 6 :
				healer = nMole/10*1;
				toxic = nMole/10*3;
				tanker = nMole - healer - toxic;
				break;
				
			case 7 :
				healer = 0;
				toxic = nMole/10*2;
				normal = nMole - healer - toxic;
				break;
				
			case 8 :
				healer = nMole/10*1;
				toxic = nMole/10*5;
				normal = nMole - healer - toxic;
				break;
				
			case 9 :
				healer = 0;
				toxic = nMole/10*6;
				normal = nMole - healer - toxic;
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
			div = 2 + rand.nextInt(4);
			
			if(div == 2)
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
	
}

