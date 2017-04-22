package entities;

import java.util.ArrayList;

import graphics.Screen;
import graphics.Texture;

public class Entity {
	public ArrayList<Hitbox> hitArray = new ArrayList<Hitbox>();
	public ArrayList<Hitbox> hurtArray = new ArrayList<>();
	public int x, y;
	public Texture sprite;

	public void update() {
	}

	public void render(Screen screen) {
	}
}
