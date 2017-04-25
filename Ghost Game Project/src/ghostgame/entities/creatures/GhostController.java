package ghostgame.entities.creatures;

import ghostgame.gfx.Animation;

import ghostgame.gfx.Assets;

import java.awt.Graphics;

import java.awt.image.BufferedImage;


/**
  * Kelas yang mengatur keseluruhan dari ghost (model dan view nya).
  * @author Kevin Iswara - 13515085.
  */

public class GhostController {

  private Ghost ghost;
  private GhostView view;
  private Animation ghostDown, ghostUp, ghostLeft, ghostRight;
  
  /**
    * Constructor dengan parameter.
    * @param ghost Nilai yang akan dimasukan ke dalam atribut ghost.
    * @param view Nilai yang akan dimasukan ke dalam atribut view.
    */
  
  public GhostController(Ghost ghost, GhostView view) {
    this.ghost = ghost;
    this.view = view;
    view.setGhostController(this);
    
    if (ghost instanceof Ghost1) {
      ghostDown = new Animation(500, Assets.ghost1_down);
      ghostUp = new Animation(500, Assets.ghost1_up);
      ghostLeft = new Animation(500, Assets.ghost1_left);
      ghostRight = new Animation(500, Assets.ghost1_right);
    }
    else if (ghost instanceof Ghost2) {
      ghostDown = new Animation(500, Assets.ghost2_down);
      ghostUp = new Animation(500, Assets.ghost2_up);
      ghostLeft = new Animation(500, Assets.ghost2_left);
      ghostRight = new Animation(500, Assets.ghost2_right);
    }
    else {
      ghostDown = new Animation(500, Assets.ghost3_down);
      ghostUp = new Animation(500, Assets.ghost3_up);
      ghostLeft = new Animation(500, Assets.ghost3_left);
      ghostRight = new Animation(500, Assets.ghost3_right);
    }
  }
  
  /**
    * I.S. Nilai ghost sembarang.
    * F.S. Nilai ghost terdefinisi.
    * @param ghost Nilai yang akan dimasukan ke dalam ghost.
    */
  
  public void setGhost(Ghost ghost) {
    this.ghost = ghost;
  }

  /**
    * Mengembalikan objek ghost yang ada di dalam controller.
    * @return Nilai objek ghost yang diatur oleh controller.
    */
  public Ghost getGhost() {
    return ghost;
  }
  
  /**
    * I.S. Nilai view sembarang.
    * F.S. Nilai view terdefinisi.
    * @param view Nilai yang akan dimasukan ke dalam view.
    */
  
  public void setGhost(GhostView view) {
    this.view = view;
  }

  /**
    * Mengembalikan objek view yang ada di dalam controller.
    * @return Nilai objek view yang diatur oleh controller.
    */
  public GhostView getGhostView() {
    return view;
  }
  
  /** 
   * I.S. atribut atk pada ghost sembarang.
   * F.S. atribut atk pada ghost terdefinisi.
   * @param atk Nilai yang akan dimasukkan ke atk atribut ghost.
   */

  public void setGhostAtk(int atk) {
    ghost.setAtk(atk);
  }

 /** 
   * Mengembalikan atk dari sebuah objek Ghost.
   * @return Nilai dari atk atribut ghost.
   */

  public int getGhostAtk() {
    return ghost.getAtk();
  }

  /**
    * Menghapus objek Ghost.
    */

  public void die() {
    ghost.die();
  }
    
  /**
    * Meng-update kondisi objek Ghost untuk setiap satuan waktu.
    */

  public void tick() {
    //Animations
    ghostDown.tick();
    ghostUp.tick();
    ghostRight.tick();
    ghostLeft.tick();
    //Finding movement
    changeMovement();
    //Movement
    ghost.move();
    //checkCollision;
  }
  
  /**
    * Fungsi yang mengembalikan gambar (frame) dari ghost sesuai dengan arah geraknya.
    * Jika arah gerak sedang ke atas (yMove negatif) maka mengembalikan frame dari 
    * ghostUp.
    * Jika arah gerak sedang ke bawah (yMove positif) maka mengembalikan frame dari 
    * ghostDown.
    * Jika arah gerak sedang ke kanan (xMove positif) maka mengembalikan frame dari 
    * ghostRight.
    * Jika arah gerak sedang ke kiri (xMove negatif) maka mengembalikan frame dari 
    * ghostLeft.
    * @return Frame yang bersesuaian dengan ghost yang akan ditampilkan.
    */

  public BufferedImage getCurrentAnimationFrame() {
    if (ghost.getxMove() < 0) {
      return ghostLeft.getCurrentFrame();
    } else if (ghost.getxMove() > 0) {
      return ghostRight.getCurrentFrame();
    } else if (ghost.getyMove() < 0) {
      return ghostUp.getCurrentFrame();
    } else {
      return ghostDown.getCurrentFrame();
    }
  }

  /**
    * Fungsi untuk mengubah xMove atau yMove.
    */

  public void changeMovement() {
    ghost.changeMovement();
  }

  /**
    * Fungsi yang menampilkan gambar (frame) dari ghost.
    * @param g Nilai grafik yang mencetak gambar (frame) dari ghost.
    */

  public void render(Graphics g) {
    view.render(ghost, g);
  }
}
