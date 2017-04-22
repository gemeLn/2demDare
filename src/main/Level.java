package main;

import java.util.ArrayList;
import java.util.List;
import entities.Entity;
import entities.Player;


public class Level {
	List<Entity> entities = new ArrayList<Entity>();
	public void update(){
		entities.add(new Player());
		for(int i = 0; i < entities.size(); i++)
	    	entities.get(i).update();
	}
	
	public void render(){
		
	}
}
