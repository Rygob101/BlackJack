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
import cards.Deck;

@SuppressWarnings("serial")
public class GameScreen extends JPanel{
	
	// SCREEN SETTINGS
	public final int screenWidth = 1000;
	public final int screenHeight = 600;
	public int cardsDrawn;
	public int buttonSelected;
	public int playerSlot = 2;
	public boolean blackjack = false;
	public boolean playerWins = false;
	public boolean dealerWins = false;
	public boolean pushWins = false;
	public boolean nextHand = false;
	public boolean buttonsEnabled = false;
	
	Graphics2D g2;
	CardManager cardM = new CardManager(this);
	ButtonManager buttonM = new ButtonManager(this);
	Thread thread;
	
	
	
	public GameScreen() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.green);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		
		drawBlank();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g2 = (Graphics2D)g;
		
		BufferedImage bgImage = null;
		try {
			bgImage = ImageIO.read(getClass().getResourceAsStream("/background/CardGameBackground.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		g2.drawImage(bgImage, 0, 0, null);
		
		
		
		cardM.drawSlots(g2);
		cardM.drawMoney(g2);
		
		if(nextHand) {
			cardM.drawScores(g2);
		}
		if(blackjack || dealerWins || pushWins || playerWins) {
			if(blackjack) {
				drawGameEndText(g2, "Blackjack!");
			}else if(dealerWins) {
				drawGameEndText(g2, "Dealer Wins!");
			}else if(pushWins) {
				drawGameEndText(g2, "Push!");
			}else if(playerWins) {
				drawGameEndText(g2, "Player Wins!");
			}
		}
		
		buttonM.drawAllButtons(g2);
		cardM.drawBet(g2);
		
		
	}
	public void playerHit(int slot){
		cardM.player.slots[slot].cardNum = cardM.deck.drawCard();
		cardM.playerOffset += 20;
		cardM.updateSlotPosition(cardM.player, 25);
		repaint();
		playerSlot++;
		

	}
	public void playerStand() {
		int slot = 1;
		while(cardM.getDealerScore() < 17) {
			cardM.dealer.slots[slot].cardNum = cardM.deck.drawCard();
			cardM.dealerOffset += 20;
			if(slot > 1) {
				cardM.updateSlotPosition(cardM.dealer, 25);
			}
			slot++;
			repaint();
		}
	}
	public void drawBlank() {
		
		if(cardM.player.bet > cardM.player.money) {
			cardM.player.bet = cardM.player.money;
		}
		dealerWins = false;
		playerWins = false;
		blackjack = false;
		pushWins = false;
		cardM.resetSlotPositions(cardM.player, cardM.player.handX);
		cardM.resetSlotPositions(cardM.dealer, cardM.dealer.handX);
		
		cardM.player.slots[0].cardNum = 0;
		cardM.player.slots[1].cardNum = 0;
		cardM.player.slots[2].cardNum = 53;
		cardM.player.slots[3].cardNum = 53;
		cardM.player.slots[4].cardNum = 53;
		cardM.player.slots[5].cardNum = 53;
		cardM.player.slots[6].cardNum = 53;

		cardM.dealer.slots[0].cardNum = 0;
		cardM.dealer.slots[1].cardNum = 0;
		cardM.dealer.slots[2].cardNum = 53;
		cardM.dealer.slots[3].cardNum = 53;
		cardM.dealer.slots[4].cardNum = 53;
		cardM.dealer.slots[5].cardNum = 53;
		cardM.dealer.slots[6].cardNum = 53;
	}
	public void runHand() {
		
		cardM.deck = new Deck();
		dealerWins = false;
		playerWins = false;
		blackjack = false;
		pushWins = false;
		playerSlot = 2;
		cardM.playerOffset = 0;
		cardM.dealerOffset = 0;
		cardM.resetSlotPositions(cardM.player, cardM.player.handX);
		cardM.resetSlotPositions(cardM.dealer, cardM.dealer.handX);
		
		cardM.player.slots[0].cardNum = cardM.deck.drawCard();
		cardM.player.slots[1].cardNum = cardM.deck.drawCard();
		if(cardM.getPlayerScore() == 21) {
			blackjack = true;
			checkWinner(g2);
			buttonsEnabled = false;
		}
		cardM.player.slots[2].cardNum = 53;
		cardM.player.slots[3].cardNum = 53;
		cardM.player.slots[4].cardNum = 53;
		cardM.player.slots[5].cardNum = 53;
		cardM.player.slots[6].cardNum = 53;

		cardM.dealer.slots[0].cardNum = cardM.deck.drawCard();
		cardM.dealer.slots[1].cardNum = 0;
		cardM.dealer.slots[2].cardNum = 53;
		cardM.dealer.slots[3].cardNum = 53;
		cardM.dealer.slots[4].cardNum = 53;
		cardM.dealer.slots[5].cardNum = 53;
		cardM.dealer.slots[6].cardNum = 53;
		
		repaint();
		
	}
	public void checkWinner(Graphics2D g2) {
		int playerScore = cardM.getPlayerScore();
		int dealerScore = cardM.getDealerScore();
		
		if(playerScore > 21 || (dealerScore > playerScore && dealerScore <= 21)) {
			dealerWins = true;
			cardM.player.money -= cardM.player.bet;
		}else if(!blackjack && (dealerScore > 21 || (dealerScore < playerScore && dealerScore <= 21))) {
			playerWins = true;
			cardM.player.money += cardM.player.bet;
		}else if(dealerScore == playerScore) {
			pushWins = true;
		}else if(blackjack) {
			System.out.println("Blackjack won!");
			cardM.player.money += (int)(1.5 * cardM.player.bet);
		}
		repaint();
	}
	
	public void drawGameEndText(Graphics2D g2, String text) {
		g2.setFont(cardM.customFont);
		g2.setColor(Color.yellow);
		int x;
		// Draw player score
		x = cardM.getXforCenterText(text);
		g2.drawString(text, x, 320);
		repaint();
	}
	

}
