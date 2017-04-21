package entities;

import java.awt.Rectangle;

public class Hitbox extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int dmg, xdif, ydif, dir;
	public long duration;
	public long timeStarted;
	public int xvel = 0;
	public int yvel = 0;
	public boolean dead = false;

	public Hitbox(int dmg, int xdif, int ydif, int w, int h, int duration) {
		this.dmg = dmg;
		this.width = w;
		this.height = h;
		this.duration = duration;
		this.xdif = xdif;
		this.ydif = ydif;
		timeStarted = System.currentTimeMillis();

	}

	public boolean expired() {
		if (dead)
			return true;
		return (System.currentTimeMillis() > (timeStarted + duration));
	}

	public void update(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
