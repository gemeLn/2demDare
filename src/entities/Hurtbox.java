package entities;

import java.awt.Rectangle;

public class Hurtbox extends Rectangle {
	private static final long serialVersionUID = 1L;

	public Hurtbox(int w, int h, int x, int y) {
		width = w;
		height = h;
		this.x = x;
		this.y = y;

	}

	public Hurtbox() {

	}

	public void update(int x, int y) {
		this.x = x;
		this.y = y;

	}
}
