package main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import entities.AlienCitizen;
import entities.Entity;
import entities.Player;
import graphics.Screen;

public class Level {
	public Font font = new Font("Sans-Serif", 1, 30);
	public boolean run = true;
	public static int GROUND = 500;
	Player player = new Player("/sprites/teemo.png", 100, 100);
	AlienCitizen alien1 = new AlienCitizen("/sprites/teemo.png", 100, 100);
	public List<Entity> entities = new ArrayList<Entity>();
	Entity dialougeBox = new Entity("/sprites/box.png", 960, 160);
	public int dialougeTotal = 0;
	public int dialougeCounter = 0;
	public String[] dialougeArray;

	public Level() {
		entities.add(player);
		entities.add(alien1);
	}

	public void freeze() {
		run = false;
	}

	public void run() {
		run = true;
	}

	public void update() {
		if (run) {
			for (int i = 0; i < entities.size(); i++)
				entities.get(i).update();
		} else {
		}
	}

	public void advance() {
		if (dialougeCounter == dialougeTotal) {
			run();
		}
		dialougeCounter++;
	}

	public void render(Screen screen) {
		if (!run) {
			dialougeBox.render(screen);
			screen.drawString(dialougeArray[dialougeCounter], 100, 100, font, Color.black);
		}
		for (Entity e : entities) {
			e.render(screen);
		}
	}

	public void dialouge(String... mes) {
		dialougeTotal = mes.length - 1;
		dialougeArray = mes;
		dialougeCounter = 0;
		freeze();
	}
}
