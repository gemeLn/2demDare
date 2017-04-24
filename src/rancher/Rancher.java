package rancher;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import entities.Entity;
import graphics.Screen;
import graphics.Texture;
import main.Main;
import main.SoundPlayer;

public class Rancher {
	Font font = new Font("Sans-Serif", 1, 30);
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
	int spiderCount;
	final int totalTick = 3660;
	int timerTick = totalTick;
	SoundPlayer soundPlayer;

	public String tickToTime(int tick) {
		int total = (int) (tick / 60);
		int minutes = (int) (total / 60);
		String seconds = String.valueOf(total - 60 * minutes);
		if (seconds.length() == 1) {
			seconds = "0" + seconds;
		}
		return String.valueOf(minutes) + ":" + seconds;

	}

	public Rancher() {
		bg = new Texture("/sprites/sewers.png", 960, 540);
		for (int i = 0; i < 9; i++) {
			spiders.add(new Spider());
		}
		spiderCount = spiders.size();
		timerTick = totalTick;
		//soundPlayer = new SoundPlayer("/sounds/ow.mp3");
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
				public void run() {
					System.out.println("fire");
					laserOn = true;
					laser.x = tempx - laser.w / 2;
					laser.y = tempy - laser.h;
					for (Spider e : spiders) {
						if (e.hitbox.contains(new Point(tempx, tempy))) {
							System.out.println("HIT");
							//soundPlayer.play();
							remove.add(e);
							spiderCount--;
							if (spiderCount == 0) {
								Main.getInstance().state = Main.State.City;
								Main.getInstance().level.dialouge("Wow you sure killed them quickly",
										"Thanks for the help here is something to pay you back");
							}
						}
					}
					clear();
				}
			}, 400);
			lastfired = System.currentTimeMillis();
		}
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, bg);
		for (Spider e : spiders) {
			e.render(screen);
		}
		screen.drawTexture(aim.x - 30, aim.y - 30, aim.sprite);
		if (laserOn) {
			laser.render(screen);
		}
		screen.drawString(tickToTime(timerTick), 470, 50, font, Color.RED);
	}

	public void update() {
		timerTick--;
		if (timerTick == 0) {
			Main.getInstance().state = Main.State.City;
			Main.getInstance().level.dialouge("That's too bad, you didn't kill them all in time",
					"Those pesky pests will stay there forever");
		}
		aim.update();
		for (Entity e : spiders) {
			e.update();
		}
		if (laserOn) {
			laser.update();
		}
	}

}
