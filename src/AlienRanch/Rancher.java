package AlienRanch;

import graphics.Screen;
import graphics.Texture;

public class Rancher {
	Texture bg;

	public Rancher() {
		bg = new Texture("/sprites/ranch.png", 960, 540);
		
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, bg);
	}

	public void update() {

	}

}
