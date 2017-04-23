package herder;

import java.util.Random;

import entities.Entity;
import entities.Hitbox;
import graphics.SpriteSheet;
import main.Main;

public class Sheep extends Entity {
	int tick, ticktimer, dir;
	public boolean inHit = false;

	public Sheep() {
		super("/sprites/sheepsheet.png", 320, 80);
		width = 80;
		Random r = new Random();
		spriteSheet = new SpriteSheet(sprite, 80, 80);
		sprite = spriteSheet.getTexture(0, 0);
		x = r.nextInt(300) + 100;
		y = r.nextInt(200) + 100;
		moveSpeed = 5;
		hitbox = new Hitbox(3, 0, 10, 80, 60, 100);
		tick = 0;
		dir = 0;
		ticktimer = r.nextInt(20) + 5;
	}

	public void update() {

		if (hitbox.intersects(Main.getInstance().herder.player.hitboxes.get(2)) && y > 20) {
			yvel = -moveSpeed;
			sprite = spriteSheet.getTexture(0, 0);
		} else if (hitbox.intersects(Main.getInstance().herder.player.hitboxes.get(3)) && y < 440) {
			yvel = moveSpeed;
			sprite = spriteSheet.getTexture(2, 0);
		}
		if (hitbox.intersects(Main.getInstance().herder.player.hitboxes.get(0)) && x < 860) {
			xvel = moveSpeed;
			sprite = spriteSheet.getTexture(1, 0);
		} else if (hitbox.intersects(Main.getInstance().herder.player.hitboxes.get(1)) && x > 20) {
			xvel = -moveSpeed;
			sprite = spriteSheet.getTexture(3, 0);
		}
		if (xvel != 0 || yvel != 0) {
			tick++;
			if (tick > ticktimer) {
				xvel = 0;
				yvel = 0;
				tick = 0;
			}
		}
		x += xvel;
		y += yvel;
		if (x > 860 || x < 20)
			x -= xvel;
		if (y < 20 || y > 440)
			y -= yvel;
		hitbox.update(x, y);
	}

	public void move() {

	}
}
