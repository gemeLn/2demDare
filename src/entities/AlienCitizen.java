package entities;

import main.Main;

public class AlienCitizen extends Entity{
	private int GROUND = 300;
	
	public AlienCitizen(String link) {
		super(link);
		x = 600;
	}
	
	public void update(){
		x += xvel;
		if (y + yvel > GROUND) {
			yvel = 0;
		} else {
			yvel++;
		}
		y += yvel;
		if (hitbox.intersects(Main.getInstance().level.entities.get(0).hitbox)){
			System.out.println("hi");
		}
		
		hitbox.update(x, y);
	}
}
