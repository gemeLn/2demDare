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

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.xvel = -player.moveSpeed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.xvel = player.moveSpeed;

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.yvel = -player.jumpHeight;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (player.xvel < 0)
				player.xvel = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (player.xvel > 0)
				player.xvel = 0;
		}

	}

}
