package AlienRanch;

import entities.Entity;

public class Aim extends Entity {
	int movespeed = 9;

	public Aim() {
		super("/sprites/target.png", 60, 60);
		x = 50;
		y = 50;
	}

	public void move(int i) {
		if (i == 0) {
			yvel = -movespeed;
		} else if (i == 1) {
			xvel = movespeed;
		} else if (i == 2) {
			yvel = movespeed;
		} else if (i == 3) {
			xvel = -movespeed;
		}
	}

	public void update() {
		if (x + xvel < 0) {
			x = 0;
		} else if (x + width + xvel > 960) {
			x = 960 - width;
		} else {
			x += xvel;
		}
		if (y + yvel < 80) {
			y = 80;
		} else if (y + height + yvel > 540) {
			y = 540 - height;
		} else {
			y += yvel;
		}

	}

}
