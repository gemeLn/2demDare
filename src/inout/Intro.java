package inout;

import java.awt.Color;
import java.awt.Font;

import com.sun.glass.events.KeyEvent;

import graphics.Screen;
import graphics.Texture;
import main.Main;

public class Intro {
	public Font font = new Font("Sans-Serif", 1, 30);
	boolean pressed = false;
	int counter = 0;
	Texture[] strips = new Texture[6];
	String[] text = new String[5];
	Texture box = new Texture("/sprites/box.png", 960, 140);
	Texture next;

	public Intro() {
		for (int i = 1; i < 6; i++) {
			strips[i - 1] = new Texture("/inout/in" + i + ".png", 960, 540);
		}
		strips[5] = new Texture("/sprites/instructions.city.png", 960, 540);
		text[0] = "Andy the astronaut was travelling in his ship";
		text[1] = "But he was having some issues";
		text[2] = "His core that powered the ship...";
		text[3] = "...broke!";
		text[4] = "He crashed and now has to get his core back";
		next = new Texture("/sprites/next.png", 96, 54);

	}

	public void handlePress(int e) {
		if (e == KeyEvent.VK_RIGHT && !pressed) {
			if (counter == strips.length - 1) {
				Main.getInstance().inIntro = false;
			}
			pressed = true;
			counter++;
		}
	}

	public void handleRelease(int e) {
		pressed = false;
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, strips[counter]);
		if (counter < 5) {
			screen.drawTexture(0, 400, box);
			screen.drawString(text[counter], 100, 490, font, Color.black);
		}
		screen.drawTexture(800, 450, next);
	}

}
