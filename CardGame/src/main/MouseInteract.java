package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;


@SuppressWarnings("serial")
public class MouseInteract extends JComponent implements MouseListener{
	
	GameScreen gs;
	
	
	public MouseInteract(GameScreen gs) {
		this.gs = gs;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX() - 5;
		System.out.println("MouseX: " + mouseX);
		int mouseY = e.getY() - 30;
		System.out.println("MouseY: " + mouseY);
		
		if(gs.buttonsEnabled && (mouseX > gs.buttonM.hb.x && mouseX < (gs.buttonM.hb.x + gs.buttonM.hb.width)) // HIT BUTTON
				&& (mouseY > gs.buttonM.hb.y && mouseY < (gs.buttonM.hb.y + gs.buttonM.hb.height))) {
			gs.playerHit(gs.playerSlot);
			if(gs.cardM.getPlayerScore() > 21) {
				gs.checkWinner(gs.g2);
				gs.buttonsEnabled = false;
			}
			
		}else if (gs.buttonsEnabled && (mouseX > gs.buttonM.sb.x && mouseX < (gs.buttonM.sb.x + gs.buttonM.sb.width)) // STAND BUTTON
				&& (mouseY > gs.buttonM.sb.y && mouseY < (gs.buttonM.sb.y + gs.buttonM.sb.height))) {
			gs.playerStand();
			gs.checkWinner(gs.g2);
			gs.buttonsEnabled = false;
		}else if(!gs.buttonsEnabled && (mouseX > gs.buttonM.db.x && mouseX < (gs.buttonM.db.x + gs.buttonM.db.width)) // DEAL BUTTON
				&& (mouseY > gs.buttonM.db.y && mouseY < (gs.buttonM.db.y + gs.buttonM.db.height))) {
			if(!gs.nextHand) {
				gs.nextHand = true;
				gs.buttonsEnabled = true;
				gs.runHand();
			}else {
				gs.nextHand = false;
				gs.drawBlank();
			}
		}else if (!gs.buttonsEnabled && (mouseX > gs.buttonM.pm1.x && mouseX < (gs.buttonM.pm1.x + gs.buttonM.pm1.width)) 
				&& (mouseY > gs.buttonM.pm1.y && mouseY < (gs.buttonM.pm1.y + gs.buttonM.pm1.height))) {
			if((mouseX > gs.buttonM.pm1.x && mouseX < (gs.buttonM.pm1.x + 60)) 
				&& (mouseY > gs.buttonM.pm1.y && mouseY < (gs.buttonM.pm1.y + gs.buttonM.pm1.height))) {
				if(gs.cardM.player.bet > 0) {
					gs.cardM.player.bet -= 1;
					gs.repaint();
				}
			}else if ((mouseX > gs.buttonM.pm1.x + 120 && mouseX < (gs.buttonM.pm1.x + gs.buttonM.pm1.width)) 
				&& (mouseY > gs.buttonM.pm1.y && mouseY < (gs.buttonM.pm1.y + gs.buttonM.pm1.height))) {
				if(gs.cardM.player.bet < gs.cardM.player.money) {
					gs.cardM.player.bet += 1;
					gs.repaint();
				}
			}
		}else if (!gs.buttonsEnabled && (mouseX > gs.buttonM.pm2.x && mouseX < (gs.buttonM.pm2.x + gs.buttonM.pm1.width)) 
				&& (mouseY > gs.buttonM.pm2.y && mouseY < (gs.buttonM.pm2.y + gs.buttonM.pm2.height))) {
			if((mouseX > gs.buttonM.pm2.x && mouseX < (gs.buttonM.pm2.x + 60)) 
				&& (mouseY > gs.buttonM.pm2.y && mouseY < (gs.buttonM.pm2.y + gs.buttonM.pm2.height))) {
				if(gs.cardM.player.bet >= 5) {
					gs.cardM.player.bet -= 5;
					gs.repaint();
				}
			}else if ((mouseX > gs.buttonM.pm2.x + 120 && mouseX < (gs.buttonM.pm2.x + gs.buttonM.pm2.width)) 
				&& (mouseY > gs.buttonM.pm2.y && mouseY < (gs.buttonM.pm2.y + gs.buttonM.pm2.height))) {
				if(gs.cardM.player.bet <= gs.cardM.player.money - 5) {
					gs.cardM.player.bet += 5;
					gs.repaint();
				}
			}
		}else if (!gs.buttonsEnabled && (mouseX > gs.buttonM.pm3.x && mouseX < (gs.buttonM.pm3.x + gs.buttonM.pm1.width)) 
				&& (mouseY > gs.buttonM.pm3.y && mouseY < (gs.buttonM.pm3.y + gs.buttonM.pm3.height))) {
			if((mouseX > gs.buttonM.pm3.x && mouseX < (gs.buttonM.pm3.x + 60)) 
				&& (mouseY > gs.buttonM.pm3.y && mouseY < (gs.buttonM.pm3.y + gs.buttonM.pm3.height))) {
				if(gs.cardM.player.bet >= 10) {
					gs.cardM.player.bet -= 10;
					gs.repaint();
				}
			}else if ((mouseX > gs.buttonM.pm3.x + 120 && mouseX < (gs.buttonM.pm3.x + gs.buttonM.pm3.width)) 
				&& (mouseY > gs.buttonM.pm3.y && mouseY < (gs.buttonM.pm3.y + gs.buttonM.pm3.height))) {
				if(gs.cardM.player.bet <= gs.cardM.player.money - 10) {
					gs.cardM.player.bet += 10;
					gs.repaint();
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
