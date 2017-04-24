package main;

import graphics.Screen;
import graphics.Window;
import herder.Herder;
import rancher.Rancher;

public class Main {
	public enum State {
		City, Rancher, Herder, Intro, Outro;
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
		window.show();
	}

	public void startRancher() {
		state = State.Rancher;
		rancher = new Rancher();
	}

	public void introloop() {
		while (true) {
			if ((double) (System.currentTimeMillis() - timeLR) > fps) {

				timeLR = System.currentTimeMillis();
			}
		}
	}

	private void gameloop() {

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
		main.gameloop();

	}
}