package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import entities.Player;

public class InputHandler extends KeyAdapter {
	Player player;

	public InputHandler(Player p) {
		player = p;
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
		if (e == KeyEvent.VK_DOWN) {
			Main.getInstance().state = Main.State.Rancher;
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
			Main.getInstance().rancher.aim.xvel = -7;
		}
		if (e == KeyEvent.VK_RIGHT) {
			Main.getInstance().rancher.aim.xvel = 7;
		}
		if (e == KeyEvent.VK_UP) {
			Main.getInstance().rancher.aim.yvel = -7;
		}
		if (e == KeyEvent.VK_DOWN) {
			Main.getInstance().rancher.aim.yvel = 7;
		}
		if (e == KeyEvent.VK_SPACE) {
			Main.getInstance().rancher.fire();
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
		}

	}

	public void keyReleased(KeyEvent e) {
		if (Main.getInstance().state == Main.State.City) {
			CityRelease(e.getKeyCode());
		} else if (Main.getInstance().state == Main.State.Rancher) {
			RancherRelease(e.getKeyCode());
		}
	}

}
