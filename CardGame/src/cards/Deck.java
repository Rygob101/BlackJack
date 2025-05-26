package cards;

import java.util.Random;
import java.util.Stack;

public class Deck {
	public int[] cardDeck = new int[52];
	public Stack<Integer> shuffleStack = new Stack<Integer>();
	
	public Deck() {
		
		for(int i = 0; i < 52; i++) {
			cardDeck[i] = i+1;
		}
		shuffle();
	}
	
	public void shuffle() {
		
		Random random = new Random();
		for(int i = 0; i < 52; i++) {
			int index = random.nextInt(0,52);
			int temp = cardDeck[i];
			cardDeck[i] = cardDeck[index];
			cardDeck[index] = temp;
		}
		for(int i = 0; i < 52; i++) {
			shuffleStack.add(cardDeck[i]);
		}
	}
	
	public int drawCard() {
		
		return shuffleStack.pop();
	}
}
