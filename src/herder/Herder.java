package herder;

import java.util.ArrayList;

import entities.Entity;
import entities.Hitbox;
import graphics.Screen;
import graphics.Texture;
import main.Main;

public class Herder {
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public IGPlayer player = new IGPlayer();
	public Hitbox hitbox = new Hitbox(3, 0, 0, 200, 200, 100);;
	boolean gameEnd;
	int round, sheepAdd;
	Texture BG = new Texture("/sprites/ranch.png", 960, 540);

	public Herder() {
		entities.add(player);	
		hitbox.update(380, 170);
		for (int i = 0; i < 7; i++) {
			entities.add(new Sheep(hitbox));
		}
		round = 0;
		sheepAdd = 2;
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
			if(round < 3){
				for (int i = 1; i < entities.size(); i++){
					entities.remove(1);
				}
				for (int j = 0; j < 7 + (sheepAdd*round); j++){
					entities.add(new Sheep(hitbox));
				}
				round++;
				System.out.println(round);
			}else {
			Main.getInstance().state = Main.State.City;
			Main.getInstance().level.dialouge("Thanks for getting all my sheep back",
					"As a reward, here is a spaceship part!");
			Main.getInstance().level.core++;
			}
		}
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, BG);
		for (Entity e : entities) {
			e.render(screen);
		}
		screen.fillRectBlend(hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0xFF3434);
	}
}
