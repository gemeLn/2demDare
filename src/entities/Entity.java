package entities;

import java.util.ArrayList;

import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import main.Level;

public class Entity {
	public ArrayList<Hitbox> hurtArray = new ArrayList<>();
	public int x, y, xvel, yvel, width, height = 0, dir;
	public Texture sprite;
	public int GROUND = Level.GROUND;
	public boolean inAir = true;
	public int jumpHeight = 10;
	public int moveSpeed;
	public SpriteSheet spriteSheet;
	public boolean inHit;
	public Hitbox hitbox = new Hitbox(3, 0, 0, 0, 0, 100);

	public Entity(String link, int width, int height) {
		if(link.equals(""))
			return;
		sprite = new Texture(link, width, height);
		this.width = width;
		this.height = height;
	}

	public void setHitbox(Hitbox h) {
		hitbox = h;
	}

	public void update() {
		if (x + xvel < 0) {
			x = 0;
		} else if (x + width + xvel > 960) {
			x = 960 - width;
		} else {
			x += xvel;
		}

	}

	public void jump() {
		if (!inAir) {
			inAir = true;
			yvel = -jumpHeight;
		}
	}

	public void gravity() {
		if (y + yvel + height > GROUND) {
			//System.out.println(y + yvel + height);
			inAir = false;
			yvel = 0;
			y = GROUND - height;
		} else {
			if (inAir) {
				yvel++;
			}
		}
		y += yvel;
		hitbox.update(x, y);
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
		screen.drawRect(1, 1, 100, 100, 0xFFFFFFF);
		screen.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0x000000);
	}

	public void interact() {

	}
}
