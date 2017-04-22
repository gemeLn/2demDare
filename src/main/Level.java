package main;

import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import entities.Player;
import graphics.Screen;

public class Level {
	Player player = new Player("/sprites/teemo.png");
	List<Entity> entities = new ArrayList<Entity>();

	public Level() {

		entities.add(player);

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
