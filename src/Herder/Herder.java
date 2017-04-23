package Herder;

import java.util.ArrayList;

import entities.Entity;
import entities.Hitbox;
import graphics.Screen;
import main.Main;

public class Herder {
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public IGPlayer player = new IGPlayer();
	public Hitbox hitbox;
	boolean gameEnd;

	public Herder() {

		entities.add(player);
		for (int i = 0; i < 7; i++) {
			entities.add(new Sheep());
		}
		hitbox = new Hitbox(3, 0, 0, 200, 200, 100);
		hitbox.update(380, 170);
	}

	public void update() {
		gameEnd = true;
		entities.get(0).update();
		for (int i = 1; i < entities.size(); i++) {
			entities.get(i).update();
			if (hitbox.contains(entities.get(i).hitbox) == false) {
				gameEnd = false;
			}
		}
		if (gameEnd) {
			Main.getInstance().state = Main.State.City;
			Main.getInstance().level.dialouge("Thanks for getting all my sheep back",
					"As a reward, here is a spaceship part!");
		}
	}

	public void render(Screen screen) {
		for (Entity e : entities) {
			e.render(screen);
		}
		screen.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0x000000);
	}
}
