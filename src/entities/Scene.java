package entities;

import graphics.Texture;

public class Scene {
	Texture sprite;

	public Texture getTexture() {
		return sprite;
	}

	public Scene(String path) {
		sprite = new Texture(path, 960, 520);
	}
}
