package main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import entities.AlienCitizen;
import entities.Entity;
import entities.Player;
import entities.Scene;
import graphics.Screen;
import graphics.Texture;

public class Level {

	public Font font = new Font("Sans-Serif", 1, 30);
	public boolean run = true;
	public static int GROUND = 500;
	Player player = new Player("/sprites/PlayerSpriteSheet.png", 100, 100);
	Scene city = new Scene("/sprites/city.png");
	Scene farm = new Scene("/sprites/farm.png");
	Texture BG = city.getTexture();
	public List<Entity> entities = new ArrayList<Entity>();
	Entity dialougeBox = new Entity("/sprites/box.png", 960, 160);
	int dialougeTotal = 0;
	int dialougeCounter = 0;
	String[] dialougeArray;
	int currentScene = 0;
	Scene[] scenes = { city, farm };
	int totalScenes = scenes.length - 1;

	public Level() {
		entities.add(player);
		city.addEntity(new AlienCitizen("/sprites/AlienSheet.png", 96, 96, 600, 0, 2, 60));
		city.addEntity(new AlienCitizen("/sprites/Alien2Sheet.png", 96, 96, 300, 0, 1, 90));
		city.addEntity(new AlienCitizen("/sprites/Alien3Sheet.png", 96, 96, 400, 0, 3, 110));
		entities.addAll(city.getList());
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
		screen.drawTexture(0, 0, BG);
		if (!run) {
			dialougeBox.render(screen);
			screen.drawString(dialougeArray[dialougeCounter], 100, 100, font, Color.black);
		}
		for (int i = 1; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		entities.get(0).render(screen);
	}

	public void nextScene() {
		entities.removeAll(scenes[currentScene].getList());
		currentScene++;
		if (currentScene > totalScenes) {
			currentScene = 0;
		}
		BG = scenes[currentScene].getTexture();
		entities.addAll(scenes[currentScene].getList());

	}

	public void prevScene() {
		entities.removeAll(scenes[currentScene].getList());
		currentScene--;
		if (currentScene < 0) {
			currentScene = totalScenes;
		}
		BG = scenes[currentScene].getTexture();
		entities.addAll(scenes[currentScene].getList());
	}

	public void dialouge(String... mes) {
		dialougeTotal = mes.length - 1;
		dialougeArray = mes;
		dialougeCounter = 0;
		freeze();
	}
}
