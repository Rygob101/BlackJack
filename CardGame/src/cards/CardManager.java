package cards;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.GameScreen;
import players.Dealer;
import players.Player;
import players.PlayersSuper;


public class CardManager {
	
	GameScreen gs;
	Graphics2D g2;
	public Player player = new Player();
	public Dealer dealer = new Dealer();
	public Card[] cards;
	public Deck deck;
	public Font customFont;
	public int playerOffset;
	public int dealerOffset;
	public int scale = 3;
	public int cardHeight = 52 * scale;
	public int cardWidth = 37 * scale;
	
	public CardManager(GameScreen gs){
		this.gs = gs;
		
		try {
			InputStream fontStream = CardManager.class.getResourceAsStream("/fonts/PressStart2P-vaV7.ttf");
		    customFont = Font.createFont(Font.PLAIN, fontStream);
		}catch(IOException | FontFormatException e) {
			e.printStackTrace();
		}
		customFont = customFont.deriveFont(Font.PLAIN, 35);
		
		cards = new Card[54];
		loadCards();
		
		setSlots(player, player.handX, player.handY);
		setSlots(dealer, dealer.handX, dealer.handY);
	}
	
	public void setSlots(PlayersSuper player, int handX, int handY) {
		player.slots[0] = new Slot();
		player.slots[0].y = handY;
		player.slots[0].x = handX;
		player.slots[1] = new Slot();
		player.slots[1].y = handY;
		player.slots[1].x = handX + 60;
		player.slots[2] = new Slot();
		player.slots[2].y = handY;
		player.slots[2].x = handX + 120;
		player.slots[3] = new Slot();
		player.slots[3].y = handY;
		player.slots[3].x = handX + 180;
		player.slots[4] = new Slot();
		player.slots[4].y = handY;
		player.slots[4].x = handX + 240;
	}
	
	public void setup(int index, String imagePath, int value) {
		
		
		try {
			cards[index] = new Card();
			cards[index].value = value;
			cards[index].image = ImageIO.read(getClass().getResourceAsStream("/cards/" + imagePath +".png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void loadCards() {
		setup(0, "Back_1", 0);
		setup(1, "Clubs_ACE", 11);
		setup(2, "Clubs_2", 2);
		setup(3, "Clubs_3", 3);
		setup(4, "Clubs_4", 4);
		setup(5, "Clubs_5", 5);
		setup(6, "Clubs_6", 6);
		setup(7, "Clubs_7", 7);
		setup(8, "Clubs_8", 8);
		setup(9, "Clubs_9", 9);
		setup(10, "Clubs_10", 10);
		setup(11, "Clubs_J", 10);
		setup(12, "Clubs_Q", 10);
		setup(13, "Clubs_K",10);
		setup(14, "Diamonds_ACE", 11);
		setup(15, "Diamonds_2", 2);
		setup(16, "Diamonds_3", 3);
		setup(17, "Diamonds_4", 4);
		setup(18, "Diamonds_5", 5);
		setup(19, "Diamonds_6", 6);
		setup(20, "Diamonds_7", 7);
		setup(21, "Diamonds_8", 8);
		setup(22, "Diamonds_9", 9);
		setup(23, "Diamonds_10", 10);
		setup(24, "Diamonds_J", 10);
		setup(25, "Diamonds_Q", 10);
		setup(26, "Diamonds_K", 10);
		setup(27, "Spades_ACE", 11);
		setup(28, "Spades_2", 2);
		setup(29, "Spades_3", 3);
		setup(30, "Spades_4", 4);
		setup(31, "Spades_5", 5);
		setup(32, "Spades_6", 6);
		setup(33, "Spades_7", 7);
		setup(34, "Spades_8", 8);
		setup(35, "Spades_9", 9);
		setup(36, "Spades_10", 10);
		setup(37, "Spades_J", 10);
		setup(38, "Spades_Q", 10);
		setup(39, "Spades_K", 10);
		setup(40, "Hearts_ACE", 11);
		setup(41, "Hearts_2", 2);
		setup(42, "Hearts_3", 3);
		setup(43, "Hearts_4", 4);
		setup(44, "Hearts_5", 5);
		setup(45, "Hearts_6", 6);
		setup(46, "Hearts_7", 7);
		setup(47, "Hearts_8", 8);
		setup(48, "Hearts_9", 9);
		setup(49, "Hearts_10", 10);
		setup(50, "Hearts_J", 10);
		setup(51, "Hearts_Q", 10);
		setup(52, "Hearts_K", 10);
		setup(53, "Empty_Card", 0);
	}
	
	public void drawSlots(Graphics2D g2) {
		for(int i = 0; i < player.slots.length; i++) {
			if(player.slots[i] != null && player.slots[i].cardNum != 53) {
				g2.drawImage(cards[player.slots[i].cardNum].image, player.slots[i].x, player.slots[i].y, cardWidth, cardHeight, null);
			}
		}
		for(int i = 0; i < dealer.slots.length; i++) {
			if(dealer.slots[i] != null && dealer.slots[i].cardNum != 53) {
				g2.drawImage(cards[dealer.slots[i].cardNum].image, dealer.slots[i].x, dealer.slots[i].y, cardWidth, cardHeight, null);
			}
		}
		
	}
	
	public int getScore(PlayersSuper player) {
		int score = 0;
		for(int i = 0; i < player.slots.length; i++) {
			if(player.slots[i].cardNum != 0 && player.slots[i].cardNum != 53) {
				score += cards[player.slots[i].cardNum].value;
				if(player.slots[i].cardNum == 1 || player.slots[i].cardNum == 14 
						|| player.slots[i].cardNum == 27 || player.slots[i].cardNum == 40) {
					if(score > 21) {
						score -= 10;
					}
				}
			}
		}
		return score;
	}
	
	public int getPlayerScore() {
		
		int score = getScore(player);
		return score;
	}
	
	public int getDealerScore() {
		
		int score = getScore(dealer);
		return score;
	}
	
	public void drawScores(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(customFont);
		g2.setColor(Color.white);
		int x;
		
		// Draw player score
		int pScore = getPlayerScore();
		x = getXforCenterText(Integer.toString(pScore)) - 15;
		g2.drawString(Integer.toString(pScore), x, 375);
		
		// Draw dealer score
		int dScore = getDealerScore();
		x = getXforCenterText(Integer.toString(dScore)) - 15;
		g2.drawString(Integer.toString(dScore), x, 260);
		
	}
	
	public int getXforCenterText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = 1000/2 - length/2;
		return x;
	}
	
	public void updateSlotPosition(PlayersSuper player, int offset) {
		player.slots[0].x -= offset;
		player.slots[1].x -= offset;
		player.slots[2].x -= offset;
		player.slots[3].x -= offset;
		player.slots[4].x -= offset;
	}
	
	public void resetSlotPositions(PlayersSuper player, int handX) {
		player.slots[0].x = handX;
		player.slots[1].x = handX + 60;
		player.slots[2].x = handX + 120;
		player.slots[3].x = handX + 180;
		player.slots[4].x = handX + 240;
	}
}
