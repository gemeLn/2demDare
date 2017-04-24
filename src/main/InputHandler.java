package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import entities.Player;
import herder.IGPlayer;

public class InputHandler extends KeyAdapter {
	Player player;
	IGPlayer playerMini;

	public InputHandler(Player p) {
		player = p;
		playerMini = Main.getInstance().herder.player;
	}

	public void HerderPress(int e) {
		if (e == KeyEvent.VK_LEFT) {
			playerMini.xvel = -playerMini.moveSpeed;
			playerMini.sprite = playerMini.spriteSheet.getTexture(3, 0);
		}
		if (e == KeyEvent.VK_RIGHT) {
			playerMini.xvel = playerMini.moveSpeed;
			playerMini.sprite = playerMini.spriteSheet.getTexture(1, 0);
		}
		if (e == KeyEvent.VK_UP) {
			playerMini.yvel = -playerMini.moveSpeed;
			playerMini.sprite = playerMini.spriteSheet.getTexture(0, 0);
		}
		if (e == KeyEvent.VK_DOWN) {
			playerMini.yvel = playerMini.moveSpeed;
			playerMini.sprite = playerMini.spriteSheet.getTexture(2, 0);
		}
		if (e == KeyEvent.VK_Q) {
			Main.getInstance().herder.gameStart = true;
		}
	}

	public void HerderRelease(int e) {
		if (e == KeyEvent.VK_LEFT) {
			if (playerMini.xvel < 0)
				playerMini.xvel = 0;
		} else if (e == KeyEvent.VK_RIGHT) {
			if (playerMini.xvel > 0)
				playerMini.xvel = 0;
		} else if (e == KeyEvent.VK_UP) {
			if (playerMini.yvel < 0)
				playerMini.yvel = 0;
		} else if (e == KeyEvent.VK_DOWN) {
			if (playerMini.yvel > 0)
				playerMini.yvel = 0;
		}
	}

	public void CityPress(int e) {
		if (e == KeyEvent.VK_LEFT) {
			player.xvel = -player.moveSpeed;
			player.walk = true;
			player.dir = 1;
		}
		if (e == KeyEvent.VK_RIGHT) {
			player.xvel = player.moveSpeed;
			player.walk = true;
			player.dir = 0;
		}
		if (e == KeyEvent.VK_UP) {
			player.jump();
		}
		if (e == KeyEvent.VK_Q) {
			player.interact();
		}
	}

	public void CityRelease(int e) {
		if (e == KeyEvent.VK_LEFT) {
			player.walkReleased = true;
			if (player.xvel < 0)
				player.xvel = 0;
		} else if (e == KeyEvent.VK_RIGHT) {
			player.walkReleased = true;
			if (player.xvel > 0)
				player.xvel = 0;

		}
	}

	public void RancherPress(int e) {
		if (e == KeyEvent.VK_LEFT) {
			Main.getInstance().rancher.aim.move(3);
		}
		if (e == KeyEvent.VK_RIGHT) {
			Main.getInstance().rancher.aim.move(1);
		}
		if (e == KeyEvent.VK_UP) {
			Main.getInstance().rancher.aim.move(0);
		}
		if (e == KeyEvent.VK_DOWN) {
			Main.getInstance().rancher.aim.move(2);
		}
		if (e == KeyEvent.VK_SPACE) {
			Main.getInstance().rancher.fire();
		}
		if (e == KeyEvent.VK_Q) {
			Main.getInstance().rancher.gameStart = true;
		}

	}

	public void RancherRelease(int e) {
		if (e == KeyEvent.VK_LEFT) {
			if (Main.getInstance().rancher.aim.xvel < 0)
				Main.getInstance().rancher.aim.xvel = 0;
		} else if (e == KeyEvent.VK_RIGHT) {
			if (Main.getInstance().rancher.aim.xvel > 0)
				Main.getInstance().rancher.aim.xvel = 0;

		} else if (e == KeyEvent.VK_UP) {
			if (Main.getInstance().rancher.aim.yvel < 0)
				Main.getInstance().rancher.aim.yvel = 0;

		} else if (e == KeyEvent.VK_DOWN) {
			if (Main.getInstance().rancher.aim.yvel > 0)
				Main.getInstance().rancher.aim.yvel = 0;

		}
	}

	public void keyPressed(KeyEvent e) {
		if (Main.getInstance().state == Main.State.City) {
			CityPress(e.getKeyCode());
		} else if (Main.getInstance().state == Main.State.Rancher) {
			RancherPress(e.getKeyCode());
		} else if (Main.getInstance().state == Main.State.Herder) {
			HerderPress(e.getKeyCode());
		}

	}

	public void keyReleased(KeyEvent e) {
		if (Main.getInstance().state == Main.State.City) {
			CityRelease(e.getKeyCode());
		} else if (Main.getInstance().state == Main.State.Rancher) {
			RancherRelease(e.getKeyCode());
		} else if (Main.getInstance().state == Main.State.Herder) {
			HerderRelease(e.getKeyCode());
		}
	}

}
