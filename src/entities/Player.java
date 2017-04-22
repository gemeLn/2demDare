package entities;

public class Player extends Entity {
	public int moveSpeed = 5;

	public boolean inAir = true;

	public Player(String link, int width, int height) {
		super(link, width, height);
		// TODO Auto-generated constructor stub
		jumpHeight = 15;
	}

	public void update() {
		gravity();

	}

}
