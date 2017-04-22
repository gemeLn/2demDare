package entities;

import java.awt.event.KeyEvent;

import main.InputHandler;

public class Player extends Entity {
	public Player(String link) {
		super(link);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		hitbox.update(x, y);
		inputHandler();
	}
	
	public void inputHandler(){
		if(InputHandler.isKeyTyped(KeyEvent.VK_W)){
			x += 10;
			System.out.println("yes");
		}
		
	}
}
