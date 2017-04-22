package entities;

import main.Main;

public class AlienCitizen extends Entity {
	private int GROUND = 300;
	public int height = 100;
	public int width = 100;

	public AlienCitizen(String link, int width, int height) {
		super(link, width, height);
		this.height = height;
		this.width = width;
		x = 600;
		y = 500;
	}

	public void update() {
		gravity();
		hitbox.update(x, y);
	}

	public void interact() {
		Main.getInstance().level.dialouge("Hello Human", "Wasup");

	}
}
