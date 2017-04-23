package ghostgame.entities.creatures;

/** 
  * File : Ghost1.java.
  * Kelas yang merepresentasikan hantu pertama yang ada pada game ini.
  * @author Kevin Iswara - 13515085.
  */

import ghostgame.Handler;

public class Ghost1 extends Ghost {
	
	/**
	  * Constructor.
	  * @param handler Nilai yang menghubungkan World dengan Entity.
	  * @param x Nilai absis (posisi) dari Ghost1.
	  * @param y Nilai ordinar (posisi) dari Ghost1.
	  */

	public Ghost1(Handler handler, float x, float y) {
		super(handler, x, y);
		speed = 2.5f;
		//damage
		atk = 1;
	}

	/**
	  * Fungsi untuk mengubah xMove atau yMove.
	  */

	public void changeMovement() {
		
	}
}