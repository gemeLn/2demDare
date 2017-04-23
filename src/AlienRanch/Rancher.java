package AlienRanch;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import entities.Entity;
import graphics.Screen;
import graphics.Texture;

public class Rancher {
	public boolean laserOn = false;
	Laser laser = new Laser();
	Timer timer = new Timer();
	long lastfired = 0;
	int delay = 1000;
	int tempx, tempy;
	Texture bg;
	Random r = new Random();
	ArrayList<Spider> spiders = new ArrayList<Spider>();
	ArrayList<Spider> remove = new ArrayList<Spider>();
	public Aim aim = new Aim();

	public Rancher() {
		bg = new Texture("/sprites/ranch.png", 960, 540);
		for (int i = 0; i < 7; i++) {
			spiders.add(new Spider());
		}
	}

	public void clear() {
		for (int i = 0; i < remove.size(); i++) {
			spiders.remove(remove.get(i));
		}
		remove.clear();
	}

	public void fire() {
		if (lastfired + delay < System.currentTimeMillis()) {
			tempx = aim.x;
			tempy = aim.y;
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					System.out.println("fire");
					for (Spider e : spiders) {
						laserOn = true;
						laser.x = tempx - laser.w / 2 + aim.width / 2;
						laser.y = tempy - laser.h + aim.height / 2;
						if (e.hitbox.contains(new Point(tempx, tempy))) {
							System.out.println("HIT");
							remove.add(e);
						}
					}
					clear();

				}
			}, 500);
			lastfired = System.currentTimeMillis();
		}
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, bg);
		for (Spider e : spiders) {
			e.render(screen);
		}
		screen.drawTexture(aim.x, aim.y, aim.sprite);
		if (laserOn) {
			laser.render(screen);
		}
	}

	public void update() {
		aim.update();
		for (Entity e : spiders) {
			e.update();
		}
		if (laserOn) {
			laser.update();
		}
	}

}
