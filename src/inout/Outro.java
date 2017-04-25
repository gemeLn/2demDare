package inout;

import java.awt.Color;
import java.awt.Font;

import com.sun.glass.events.KeyEvent;

import graphics.Screen;
import graphics.Texture;

public class Outro {
	public Font font = new Font("Sans-Serif", 1, 30);
	boolean pressed = false;
	int counter = 0;
	Texture[] strips = new Texture[3];
	String[] text = new String[2];
	Texture box = new Texture("/sprites/box.png", 960, 140);
	Texture next;

	public Outro() {
		strips[0] = new Texture("/inout/out1.png", 960, 540);
		strips[1] = strips[0];
		strips[2] = new Texture("/sprites/credits.png", 960, 540);
		text[0] = "With his core fixed,";
		text[1] = "\"Cya!\", Andy said";
		next = new Texture("/sprites/next.png", 96, 54);
	}

	public void handlePress(int e) {
		if (e == KeyEvent.VK_RIGHT && !pressed) {
			if (counter != strips.length - 1) {
				pressed = true;
				counter++;
			}

		}
	}

	public void handleRelease(int e) {
		pressed = false;
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, strips[counter]);
		if (counter < 2) {
			screen.drawTexture(0, 400, box);
			screen.drawString(text[counter], 100, 490, font, Color.black);
			screen.drawTexture(800, 450, next);
		}
	}
}
