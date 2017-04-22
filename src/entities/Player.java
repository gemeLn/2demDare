package entities;

import java.awt.event.KeyEvent;

import main.InputHandler;

public class Player extends Entity {
	private int GROUND = 500;
	public int moveSpeed = 5;
	public int jumpHeight = 15;
	public int height = 100;
	public int width = 100;
	public boolean inAir = true;

	public Player(String link, int width, int height) {
		super(link, width, height);
		this.height = height;
		this.width = width;
		// TODO Auto-generated constructor stub
	}

	public void jump() {
		inAir = true;
		yvel = -jumpHeight;
	}

	public void update() {
		if (x + xvel < 0) {
			x = 0;
		} else if (x + width + xvel > 960) {
			x = 960 - width;
		} else {
			x += xvel;
		}
		if (y + yvel + height > GROUND) {
			inAir = false;
			yvel = 0;
			y = GROUND - height;
		} else {
			if (inAir) {
				yvel++;
			}
		}
		y += yvel;
		hitbox.update(x, y);
	}

}
