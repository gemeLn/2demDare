package entities;

import java.util.Random;

import main.Main;

public class AlienCitizen extends Entity {
	private int GROUND = 300;
	public int height = 100;
	public int width = 100;
	int randomDialog;
	Random random = new Random();

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
		randomDialog = random.nextInt(4);
		switch(randomDialog){
		case 0:
			Main.getInstance().level.dialouge("Alien: Hello Human", "Me: Wasup");
			break;
		case 1:
			Main.getInstance().level.dialouge("Alien: Who are you?", "Me: Human...");
			break;
		case 2:
			Main.getInstance().level.dialouge("Alien: ...", "Me: ...");
			break;
		case 3:
			Main.getInstance().level.dialouge("Alien: Lmao", "Me: ??");
			break;
		case 4:
			Main.getInstance().level.dialouge("Alien: Pranked", "Me: Where is camera?");
			break;
		}
		

	}
}
