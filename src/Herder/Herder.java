package Herder;

import java.util.ArrayList;

import AlienRanch.Spider;
import entities.Entity;
import graphics.Screen;

public class Herder {
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public IGPlayer player = new IGPlayer();
	
	public Herder(){
		
		entities.add(player);
		for (int i = 0; i < 7; i++) {
			entities.add(new Sheep());
		}
	}
	
	public void update() {
		for(Entity e : entities){
			e.update();
		}
	}

	public void render(Screen screen) {
		for(Entity e : entities){
			e.render(screen);
		}
	}
}
