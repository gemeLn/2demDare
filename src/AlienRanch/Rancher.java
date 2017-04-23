package AlienRanch;

import java.util.ArrayList;
import java.util.Random;

import entities.Entity;
import graphics.Screen;
import graphics.Texture;

public class Rancher {
	Texture bg;
	Random r = new Random();
	ArrayList<Entity> entities = new ArrayList<Entity>();

	public Rancher() {
		bg = new Texture("/sprites/ranch.png", 960, 540);
		for (int i = 0; i < 7; i++) {
			entities.add(new Spider());
		}
	}

	public void render(Screen screen) {
		//screen.drawTexture(0, 0, bg);
		for (Entity e : entities) {
			e.render(screen);
		}
	}

	public void update() {
		for (Entity e : entities) {
			e.update();
		}
	}

}
