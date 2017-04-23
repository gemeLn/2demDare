package entities;

import java.util.ArrayList;
import java.util.List;

import graphics.SpriteSheet;
import main.Main;

public class Player extends Entity {
	public int moveSpeed = 5;

	public boolean inAir = true;
	static SpriteSheet spriteSheet;
	public static boolean walk = false;
	int tick;

	public Player(String link, int width, int height) {
		super(link, 2880, 192);
		spriteSheet = new SpriteSheet(sprite, 96, 96);
		this.width = width;
		this.height = height;
		jumpHeight = 15;
		sprite = spriteSheet.getTexture(0, 0);
		tick = 0;
		dir = 0;
	}

	public void update() {
		if (x + xvel < 0) {
			Main.getInstance().level.nextScene();
			x = 960 - width;
		} else if (x + width + xvel > 960) {
			Main.getInstance().level.prevScene();
			x = 0;
		} else {
			x += xvel;
		}
		gravity();
		// if (walk){
		walk();
		// }

	}

	public void interact() {
		if (!Main.getInstance().level.run) {
			Main.getInstance().level.advance();
		} else {
			List<Entity> entities = Main.getInstance().level.entities;
			for (int i = 1; i < entities.size(); i++) {
				if (hitbox.intersects(entities.get(i).hitbox)) {
					entities.get(i).interact();
					break;
				}
			}
		}
	}

	public void walk() {
		sprite = spriteSheet.getTexture(tick, dir);
		tick += 1;
		System.out.println(tick);

		if (tick >= 30) {
			tick = 0;
			walk = false;
		}
	}

}
