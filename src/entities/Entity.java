package entities;

import java.awt.Color;
import java.util.ArrayList;

import graphics.Screen;
import graphics.Texture;

public class Entity {
	public Hitbox hitbox = new Hitbox(3, 0, 0, 64, 64, 100);
	public ArrayList<Hitbox> hurtArray = new ArrayList<>();
	public int x, y, xvel, yvel = 0;
	public Texture sprite;

	public Entity(String link, int width, int height) {
		sprite = new Texture(link, width, height);
		x = 100;
		y = 100;
	}

	public void update() {
		hitbox.update(x, y);
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
		screen.drawRect(1, 1, 100, 100, 0xFFFFFFF);
		screen.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0x000000);
	}
}
