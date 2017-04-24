package rancher;

import java.util.Random;

import entities.Entity;
import entities.Hitbox;
import graphics.SpriteSheet;
import graphics.Texture;

public class Spider extends Entity {
	SpriteSheet sheet;
	int tick, i;
	Random r = new Random();

	public Spider() {
		super("/sprites/spider.png", 200, 100);
		x = r.nextInt(600) + 100;
		y = r.nextInt(300) + 50;
		i = 0;
		sheet = new SpriteSheet(sprite, 100, 100);
		sprite = sheet.getTexture(0, 0);
		hitbox = new Hitbox(3, 5, 15, 90, 65, 100);
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
			xvel = sign() * (r.nextInt(3) + 1);
			yvel = sign() * (r.nextInt(3) + 1);
			if(i == 0) {
				sprite = sheet.getTexture(1, 0);
				i = 1;
			} else{
				sprite = sheet.getTexture(0, 0);
				i = 0;
			}
		}

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
		hitbox.update(x, y);
	}

}
