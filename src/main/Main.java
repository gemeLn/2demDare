package main;

import graphics.Screen;
import graphics.Window;
import herder.Herder;
import inout.Intro;
import inout.Outro;
import rancher.Rancher;

public class Main {
	public enum State {
		City, Rancher, Herder, Intro, Outro;
	}

	public State state = State.City;
	public boolean inGame, inIntro, inOutro = false;

	public Main() {
		instance = this;
	}

	Window window = new Window("Game", 960, 540);
	long timeLR = System.currentTimeMillis();
	double fps = 1000 / 60;
	public Level level;
	public Rancher rancher;
	public Herder herder;
	public Intro intro;
	public Outro outro;
	static Main instance;
	Screen screen;

	public static Main getInstance() {
		return instance;
	}

	private void init() {
		rancher = new Rancher(1);
		level = new Level();
		herder = new Herder();
		intro = new Intro();
		outro = new Outro();
		window.addKeyListener(new InputHandler(level.player));
		window.show();
		screen = window.getScreen();
		introloop();
	}

	public void startRancher() {
		state = State.Rancher;
		rancher = new Rancher(1);
	}
	
	public void startRancher(int rounds) {
		state = State.Rancher;
		rancher = new Rancher(rounds);
	}

	public void introloop() {
		inIntro = true;
		state = State.Intro;
		while (inIntro) {
			if ((double) (System.currentTimeMillis() - timeLR) > fps) {
				intro.render(screen);
				window.update();
				screen.clear(0xffffff);
				timeLR = System.currentTimeMillis();
			}
		}
		gameloop();
	}

	private void outroloop() {
		state = State.Outro;
		inOutro = true;
		while (inOutro) {
			if ((double) (System.currentTimeMillis() - timeLR) > fps) {
				outro.render(screen);
				window.update();
				screen.clear(0xffffff);
				timeLR = System.currentTimeMillis();
			}
		}

	}

	private void gameloop() {
		state = State.City;
		inGame = true;
		window.update();

		while (inGame) {
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
		outroloop();
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.init();

	}
}