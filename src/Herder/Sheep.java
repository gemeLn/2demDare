package Herder;

import entities.Entity;

public class Sheep extends Entity{
	public Sheep(){
		super("/sprites/spider.png", 200, 100);
		x = 50;
		y = 50;
	}
	
	public void update(){
		x += xvel;
		y += yvel;
	}
	
	public void move(){
		
	}
}
