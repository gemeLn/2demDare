package entities;

import java.util.Random;

import graphics.SpriteSheet;
import main.Main;
import rancher.Rancher;

public class SpiderAlien extends Entity {
	public int height = 100;
	public int width = 100;
	public int moveSpeed;
	int tick = 0;
	int dur;
	int randomDialog;
	public boolean dialogOnce = true;
	public boolean switchit = false;
	Random random = new Random();
	SpriteSheet spriteSheet;

	public SpiderAlien(String link, int width, int height, int x, int y, int moveSpeed, int dur) {
		super(link, 384, 192);
		spriteSheet = new SpriteSheet(sprite, 96, 96);
		this.x = x;
		this.y = y;
		this.moveSpeed = moveSpeed;
		hitbox = new Hitbox(3, 0, 0, 64, 64, 100);
		this.dur = dur;
		xvel = moveSpeed;
		sprite = spriteSheet.getTexture(0, 0);
	}

	public void update() {
		x += xvel;
		// System.out.println(y + yvel + height);
		gravity();
		if (tick > dur) {
			tick = 0;
			xvel *= -1;
			dir += 1 - (dir * 2);
		}
		walk();
		tick++;
		if (switchit) {
			if (Main.getInstance().level.dialongOver) {
				Main.getInstance().rancher = new Rancher(1);
				Main.getInstance().state = Main.State.Rancher;
				switchit = false;
			}
		}
	}

	public void walk() {
		sprite = spriteSheet.getTexture((tick / 10) % 4, dir);
	}

	public void interact() {
		if (dialogOnce) {
			Main.getInstance().level.dialouge("Blue Alien: Hi, can you help me?", "Me: Sure! Whats wrong",
					"Blue Alien: There are so many spider,", "Blue Alien: in the sewer. " + "Can you use this",
					"Blue Alien: laser to extermiate them?", "Me: Sure!");
			switchit = true;
		} else {
			Main.getInstance().level.dialouge("Blue Alien: Thanks again!");
		}
	}

	public void gravity() {
		if (y + yvel + height > GROUND) {
			inAir = false;
			yvel = 0;
			y = GROUND - height;
		} else {
			if (inAir) {
				yvel++;
			}
		}
		y += yvel;
		hitbox.update(x, y);
	}
}
