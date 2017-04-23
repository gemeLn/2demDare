package AlienRanch;

import entities.Entity;

public class Aim extends Entity {

	public Aim() {
		super("/sprites/target.png", 60, 60);
		x = 50;
		y = 50;
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
