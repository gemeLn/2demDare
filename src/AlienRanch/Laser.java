package AlienRanch;

import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import main.Main;

public class Laser {
	SpriteSheet sheet;
	Texture sprite;
	public int x, y, w, h = 0;

	public Laser() {
		w = 100;
		h = 160;
		sheet = new SpriteSheet(new Texture("/sprites/laser.png", 7 * w, h), w, h);
		sprite = sheet.getTexture(1, 0);
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
	}

	long tick = 0;

	public void update() {
		tick++;
		if (tick == 10) {
			sprite = sheet.getTexture(1, 0);
		} else if (tick == 13) {
			sprite = sheet.getTexture(2, 0);
		} 
		else if (tick == 17) {
			sprite = sheet.getTexture(3, 0);
		} 
		else if (tick == 22) {
			sprite = sheet.getTexture(4, 0);
		}
		else if (tick == 29) {
			sprite = sheet.getTexture(5, 0);
		} 
		else if (tick == 35) {
			sprite = sheet.getTexture(6, 0);
		} else if (tick == 42) {
			tick = 0;
			sprite = sheet.getTexture(0, 0);
			Main.getInstance().rancher.laserOn = false;
		}
	}
}
