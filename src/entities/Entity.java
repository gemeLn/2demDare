package entities;

import java.awt.Color;
import java.util.ArrayList;

import graphics.Screen;
import graphics.Texture;

public class Entity {
	public Hitbox hitbox = new Hitbox(3, 0, 0, 1, 1, 100);
	public ArrayList<Hitbox> hurtArray = new ArrayList<>();
	public int x, y, xvel, yvel = 0;
	public Texture sprite;

	public Entity(String link) {
		sprite = new Texture(link, 100, 100);
		x = 100;
		y = 100;
	}

	public void update() {
		hitbox.update(x, y);
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
		screen.drawRect(1, 1, 100, 100, 0xFFFFFFF);

	}
}
