package main;

import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import graphics.Screen;

public class Level {
	List<Entity> entities = new ArrayList<Entity>();

	public Level() {
		Entity teemo = new Entity("/sprites/teemo.png");
		entities.add(teemo);

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++)
			entities.get(i).update();
	}

	public void render(Screen screen) {
		for (Entity e : entities) {
			e.render(screen);
		}
	}
}
