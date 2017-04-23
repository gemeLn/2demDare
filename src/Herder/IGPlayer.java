package Herder;

import entities.Entity;
import graphics.SpriteSheet;

public class IGPlayer extends Entity{
	
	public SpriteSheet spriteSheet;
	public IGPlayer(){
		super("/sprites/PlayerGame.png", 320, 80);
		spriteSheet = new SpriteSheet(sprite, 80, 80);
		sprite = spriteSheet.getTexture(0, 0);
		x = 50;
		y = 50;
		moveSpeed = 4;
	}
	
	public void update(){
		x += xvel;
		y += yvel;
	}
}
