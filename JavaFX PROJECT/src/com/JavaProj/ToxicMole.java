package com.JavaProj;

import java.io.InputStream;

public class ToxicMole extends Mole {

	public ToxicMole(InputStream ImageIS, int i) {
		super(1, MoleUtils.getLifeTime(i), 100, 4, ImageIS);
		// TODO Auto-generated constructor stub
	}

}
