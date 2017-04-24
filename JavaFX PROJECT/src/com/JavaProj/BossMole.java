package com.JavaProj;

import java.io.InputStream;

public class BossMole extends Mole {
	public BossMole (InputStream x, int wave) {
		super (100, MoleUtils.getBossLifeTime(wave), 1000, 5, x);
	}
}
