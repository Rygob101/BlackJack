package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import buttons.ButtonManager;
import cards.CardManager;

@SuppressWarnings("serial")
public class GameScreen extends JPanel{
	
	// SCREEN SETTINGS
	public final int screenWidth = 1000;
	public final int screenHeight = 600;
	public int cardsDrawn;
	public int buttonSelected;
	public int playerSlot = 2;
	
	CardManager cardM = new CardManager(this);
	ButtonManager buttonM = new ButtonManager(this);
	
	
	
	public GameScreen() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.green);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		
		cardM.player.slots[0].cardNum = cardM.deck.drawCard();
		cardM.player.slots[1].cardNum = cardM.deck.drawCard();

		
		cardM.dealer.slots[0].cardNum = cardM.deck.drawCard();
		cardM.dealer.slots[1].cardNum = 0;
		
		System.out.println("test");
		
		repaint();
		
//		while(true) {
//			if(buttonSelected != 0) {
//				switch (buttonSelected) {
//				case 1:
//					playerHit(playerSlot);
//					playerSlot++;
//				}
//			}
//		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		BufferedImage bgImage = null;
		try {
			bgImage = ImageIO.read(getClass().getResourceAsStream("/background/CardGameBackground.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		g2.drawImage(bgImage, 0, 0, null);
		
		cardM.drawScores(g2);
		cardM.drawSlots(g2);
		
		buttonM.drawAllButtons(g2);
		
	}
	public void playerHit(int slot){
		cardM.player.slots[slot].cardNum = cardM.deck.drawCard();
		repaint();
		playerSlot++;
	}
	public void playerStand() {
		int slot = 1;
		while(cardM.getDealerScore() < 17) {
			cardM.dealer.slots[slot].cardNum = cardM.deck.drawCard();
			slot++;
			repaint();
		}
	}
}
