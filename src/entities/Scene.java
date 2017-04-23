package entities;

import java.util.ArrayList;

import graphics.Texture;

public class Scene {
	Texture sprite;

	public Texture getTexture() {
		return sprite;
	}

	public ArrayList<Entity> entities = new ArrayList<Entity>();

	public Scene(String path) {
		sprite = new Texture(path, 960, 520);
	}

	public ArrayList<Entity> getList() {
		return entities;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}
}
