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
		
		if((mouseX > gs.buttonM.hb.x && mouseX < (gs.buttonM.hb.x + gs.buttonM.hb.width)) 
				&& (mouseY > gs.buttonM.hb.y && mouseY < (gs.buttonM.hb.y + gs.buttonM.hb.height))) {
			gs.playerHit(gs.playerSlot);
			
		}else if ((mouseX > gs.buttonM.sb.x && mouseX < (gs.buttonM.sb.x + gs.buttonM.sb.width)) 
				&& (mouseY > gs.buttonM.sb.y && mouseY < (gs.buttonM.sb.y + gs.buttonM.sb.height))) {
			gs.playerStand();
		}
		System.out.println("Mouse Clicked!");
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
