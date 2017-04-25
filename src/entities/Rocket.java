package entities;

import graphics.Screen;
import main.Main;

public class Rocket extends Entity{

	public Rocket() {
		super("", 0, 0);
		// TODO Auto-generated constructor stub
		hitbox = new Hitbox(3, 0, 0, 150, 150, 100);
		x = 500;
		y = 350;
		hitbox.update(x, y);
	}
	
	public void interact(){
		if(Main.getInstance().level.core == 3)
			Main.getInstance().inGame = false;
		else
			Main.getInstance().level.dialouge("Me: I need the rest of the cores!");
	}
	
	public void render(Screen screen){
		screen.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0x000000);
	}

}
