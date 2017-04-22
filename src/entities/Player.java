package entities;

import java.awt.event.KeyEvent;

import main.InputHandler;

public class Player extends Entity {
	private int GROUND = 300;
	public int moveSpeed = 5;
	public int jumpHeight = 15;

	public Player(String link) {
		super(link);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		x += xvel;
		if (y + yvel > GROUND) {
			yvel = 0;
		} else {
			yvel++;
		}
		y += yvel;
		hitbox.update(x, y);
	}

}
