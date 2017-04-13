package com.JavaProj;

import java.io.InputStream;

public class HealerMole extends Mole {

	public HealerMole(InputStream ImageIS, int i) {
		super(1, MoleUtils.getLifeTime(i), 50, 3, ImageIS);
		// TODO Auto-generated constructor stub
	}

}
