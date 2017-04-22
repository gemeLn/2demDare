package main;

import main.InputHandler;
import graphics.Screen;
import graphics.Window;

public class Main {

	Window window = new Window("Game", 960, 540);

	
	Level level;

	private void init() {
		level = new Level();
	}

	private void loop() {
		
		Window window = new Window("Game", 960, 540);
		window.show();
		window.update();
		window.addKeyListener(new InputHandler());
		Screen screen = window.getScreen();
		
		while (true) {
			level.update();
			level.render(screen);
			window.update();
			screen.clear(0xffffff);
			InputHandler.clear();
		}
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.init();
		main.loop();

	}
}