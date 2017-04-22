package main;

import java.util.ArrayList;
import java.util.List;

import entities.AlienCitizen;
import entities.Entity;
import entities.Player;
import graphics.Screen;

public class Level {
	public static int GROUND = 500;
	Player player = new Player("/sprites/teemo.png", 100, 100);
	AlienCitizen alien1 = new AlienCitizen("/sprites/teemo.png", 100, 100);
	public List<Entity> entities = new ArrayList<Entity>();

	public Level() {

		entities.add(player);
		entities.add(alien1);

	}

	public void update() {
		for (int i = entities.size() - 1; i > 0; i--)
			entities.get(i).update();
	}

	public void render(Screen screen) {
		for (Entity e : entities) {
			e.render(screen);
		}
	}
}
