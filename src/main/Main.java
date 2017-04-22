package main;

import graphics.Screen;
import graphics.Window;

public class Main {

	Window window = new Window("Game", 960, 540);

	Screen screen = window.getScreen();
	Level level;

	private void init() {
		level = new Level();
		Window window = new Window("Game", 960, 540);
		window.show();
		window.update();
	}

	private void loop() {
		while (true) {
			level.update();
			level.render(screen);
			window.update();
			screen.clear(0xffffff);
		}
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.init();
		main.loop();

	}
}