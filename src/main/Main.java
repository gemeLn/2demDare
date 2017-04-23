package main;

import AlienRanch.Rancher;
import Herder.Herder;
import graphics.Screen;
import graphics.Window;

public class Main {
	public enum State {
		City, Rancher, Herder;
	}

	public State state = State.City;

	public Main() {
		instance = this;
	}

	Window window = new Window("Game", 960, 540);
	long timeLR = System.currentTimeMillis();
	double fps = 1000 / 60;
	public Level level;
	public Rancher rancher;
	public Herder herder;
	static Main instance;

	public static Main getInstance() {
		return instance;
	}

	private void init() {
		rancher = new Rancher();
		level = new Level();
		herder = new Herder();
	}

	public void startRancher() {
		state = State.Rancher;
		rancher = new Rancher();
	}

	private void loop() {

		Window window = new Window("Game", 960, 540);
		window.show();
		window.update();
		window.addKeyListener(new InputHandler(level.player));
		Screen screen = window.getScreen();
		while (true) {
			if ((double) (System.currentTimeMillis() - timeLR) > fps) {
				if (state == State.City) {
					level.update();
					level.render(screen);
					window.update();
					screen.clear(0xffffff);
				} else if (state == State.Rancher) {
					rancher.update();
					rancher.render(screen);
					window.update();
					screen.clear(0xffffff);
				} else if (state == State.Herder) {
					herder.update();
					herder.render(screen);
					window.update();
					screen.clear(0xffffff);
				}
				timeLR = System.currentTimeMillis();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.init();
		main.loop();

	}
}