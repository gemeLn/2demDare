package entities;

public class Player extends Entity {
	public Player(String link) {
		super(link);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		hitbox.update(x, y);
	}
}
