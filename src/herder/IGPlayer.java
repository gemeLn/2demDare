package herder;

import java.util.ArrayList;

import entities.Entity;
import entities.Hitbox;
import graphics.Screen;
import graphics.SpriteSheet;

public class IGPlayer extends Entity {
	ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();
	public SpriteSheet spriteSheet;
	int tick;

	public IGPlayer() {
		super("/sprites/PlayerGame.png", 320, 80);
		spriteSheet = new SpriteSheet(sprite, 80, 80);
		sprite = spriteSheet.getTexture(0, 0);
		x = 50;
		y = 50;
		hitboxes.add(new Hitbox(3, 0, 0, 40, 160, 100));
		hitboxes.add(new Hitbox(3, 0, 0, 40, 160, 100));
		hitboxes.add(new Hitbox(3, 0, 0, 160, 40, 100));
		hitboxes.add(new Hitbox(3, 0, 0, 160, 40, 100));
		moveSpeed = 5;
	}

	public void update() {
		tick++; 
		hitboxes.get(0).update(x + 80, y - 40);
		hitboxes.get(1).update(x - 40, y - 40);
		hitboxes.get(2).update(x - 40, y - 40);
		hitboxes.get(3).update(x - 40, y + 80);

		if (x + xvel < -5 || x + xvel > 885)
			x -= xvel;
		if (y + yvel < 30 || y + yvel > 465)
			y -= yvel;
		x += xvel;
		y += yvel;
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
	}
}
