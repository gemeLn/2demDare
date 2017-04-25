package main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import entities.AlienCitizen;
import entities.Entity;
import entities.HerderAlien;
import entities.Player;
import entities.Rocket;
import entities.Scene;
import entities.SpiderAlien;
import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;

public class Level {

	public Font font = new Font("Sans-Serif", 1, 30);
	public boolean run = true;
	public static int GROUND = 500;
	Player player = new Player("/sprites/PlayerSpriteSheet.png", 100, 100);
	Scene city = new Scene("/sprites/city.png");
	Scene farm = new Scene("/sprites/farm.png");
	Scene crash = new Scene("/sprites/crashsite.png");
	Scene alley = new Scene("/sprites/alley.png");
	Texture BG = crash.getTexture();
	public List<Entity> entities = new ArrayList<Entity>();
	Entity dialougeBox = new Entity("/sprites/box.png", 960, 160);
	public int dialougeTotal = 0;
	public int dialougeCounter = 0;
	public int core = 1;
	SpriteSheet cores;
	String[] dialougeArray;
	int currentScene = 0;
	Scene[] scenes = { crash, farm ,city, alley };
	StringTokenizer stringTokenizer;
	int totalScenes = scenes.length - 1;
	public boolean dialongOver;
	
	public Level() {
		entities.add(player);
		city.addEntity(new AlienCitizen("/sprites/AlienSheet.png", 96, 96, 600, 0, 2, 60, "Yellow"));
		city.addEntity(new SpiderAlien("/sprites/Alien2Sheet.png", 96, 96, 300, 0, 1, 90));
		city.addEntity(new AlienCitizen("/sprites/Alien3Sheet.png", 96, 96, 400, 0, 3, 110, "Pink"));
		farm.addEntity(new HerderAlien("/sprites/AlienSheet.png", 96, 96, 600, 0, 2, 60));
		alley.addEntity(new AlienCitizen("/sprites/Alien3Sheet.png", 96, 96, 400, 0, 3, 110, "Pink"));
		crash.addEntity(new Rocket());
		entities.addAll(crash.getList());
		
		cores = new SpriteSheet(new Texture("/sprites/coresheet.png", 200, 50), 50, 50);
		//SoundPlayer back = new SoundPlayer("/sounds/SoundTrack1.mp3");
	//	back.setVolume(0.25);
		//back.loop();

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
			dialongOver = true;
		}
		dialougeCounter++;
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, BG);
		if (!run) {
			dialougeBox.render(screen);
			screen.drawString(dialougeArray[dialougeCounter], 100, 90, font, Color.black);
			stringTokenizer = new StringTokenizer(dialougeArray[dialougeCounter]);
			icon(stringTokenizer.nextToken().toLowerCase(), screen);
		}
		for (int i = 1; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		entities.get(0).render(screen);
		screen.drawTexture(0, 490, cores.getTexture(core, 0));
	}
	
	public void icon(String iconName, Screen screen){
		switch (iconName){
		case "pink":
			screen.drawTexture(800, 0, new Texture("/sprites/alien1profile.png", 150, 150));
			break;
		case "blue":
			screen.drawTexture(800, 0, new Texture("/sprites/alien2profile.png", 150, 150));
			break;
		case "yellow":
			screen.drawTexture(800, 0, new Texture("/sprites/alien3profile.png", 150, 150));
			break;
		case "me:":
			screen.drawTexture(800, 0, new Texture("/sprites/astroprofile.png", 150, 150));
			break;
		}
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
		dialongOver = true;
		freeze();
	}
}
