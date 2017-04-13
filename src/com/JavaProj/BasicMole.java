package com.JavaProj;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class BasicMole extends Mole {
    
    public BasicMole(InputStream x,int wave) throws FileNotFoundException {
		super(1,MoleUtils.getLifeTime(wave),100,1,x);
		// TODO Auto-generated constructor stub
	}

}
