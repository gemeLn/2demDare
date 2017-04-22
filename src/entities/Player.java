package entities;

import java.util.ArrayList;
import java.util.List;

import graphics.SpriteSheet;
import main.Main;

public class Player extends Entity {
	public int moveSpeed = 5;

	public boolean inAir = true;

	public Player(String link, int width, int height) {
		super(link, 960, 64);
		SpriteSheet spriteSheet = new SpriteSheet(sprite, 32, 32);
		this.width = width;
		this.height = height;
		jumpHeight = 15;
		sprite = spriteSheet.getTexture(0,0);
	}

	public void update() {

		gravity();

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

}
