package AlienRanch;

import java.util.Random;

import entities.Entity;
import graphics.SpriteSheet;
import graphics.Texture;

public class Spider extends Entity {
	SpriteSheet sheet;
	int tick;
	Random r = new Random();

	public Spider() {
		super("/sprites/spider.png", 200, 100);
		sheet = new SpriteSheet(sprite, 100, 100);
		sprite = sheet.getTexture(0, 0);
	}

	public int sign() {
		if (r.nextInt(2) == 0) {
			return -1;
		}
		return 1;
	}

	public void update() {
		tick++;
		if (tick > 30) {
			tick = 0;
			xvel = sign() * (r.nextInt(7) + 1);
			yvel = sign() * r.nextInt(7);
		}

		if (x + xvel < 0) {
			x = 0;
		} else if (x + width + xvel > 960) {
			x = 960 - width;
		} else {
			x += xvel;
		}
		if (y + yvel < 0) {
			y = 0;
		} else if (y + height + yvel > 540) {
			y = 540 - height;
		} else {
			y += yvel;
		}

	}

}
