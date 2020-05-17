package cards;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

/**
 * Represents a deck of cards
 * 
 */
public class CardStack { // Tested; methods all work! (05/10/2020)

	private boolean hasJokers;
	private ArrayList<Card> cards;
	private int playerOwner = 0;

	/**
	 * No args constructor, automatically sets a CardStack to have no owner(s) and no jokers
	 */
	public CardStack() {
		playerOwner = 0;
		hasJokers = false;
		cards = new ArrayList<Card>();
	}
	
//	/**
//	 * fills the entire cardstack with every single card
//	 */
//	public ArrayList<Card> fullDeck() {
//		ArrayList<Card> full = new ArrayList<Card>();
//		for (int i = 1; i < 16; i++) {
//			for (int j = 0; i < 4; j++) {
//				full.add(new Card(i, j));
//			}
//		}
//		return full; 
//	}

	/**
	 * Constructor for a CardStack if jokers are included, automatically sets a CardStack to have no owner(s)
	 * @param jokers Checks to see if joker(s) are included in a CardStack
	 */
	public CardStack(boolean jokers) {
		playerOwner = 0;
		hasJokers = jokers;
		cards = new ArrayList<Card>();
	}
	
	public int totalVal() {
		int result = 0; 
		for (Card a : cards) {
			result += a.getNum(); 
		}
		return result;
	}
	
	/**
	 * Method that deals a random card to players
	 * @return Returns a random card
	 */
	public Card dealRandom() {
		Random rand = new Random();
		int index = rand.nextInt(cards.size());
		
		return cards.get(index);
	}
	
	/**
	 * Method to get all cards in a CardStack
	 * @return Returns all cards in a CardStack
	 */
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	/**
	 * Method to set the cards in a cardstack
	 */
	public void setCards(ArrayList<Card> input) {
		cards = input;
	}
	/**
	 * Method to find the owner of a CardStack
	 * @return Returns which player owns a CardStack
	 */
	public int getPlayerOwner() {
		return this.playerOwner;
	}
	
	/**
	 * Method to find whether a CardStack has jokers 
	 * @return Returns true if CardStack has jokers, false if CardStack doesn't
	 */
	public boolean getHasJokers() {
		return this.hasJokers;
	}
	
	/**
	 * Method to fill a CardStack with a standard amount of cards
	 */
	public void fillStandard() {
		ArrayList<Card> finalDeck = new ArrayList<Card>();

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				Card tempCard = new Card(i, j);
				finalDeck.add(tempCard);
			}
		}

		if (hasJokers) {
			finalDeck.add(new Card(4, 14)); // little joker
			finalDeck.add(new Card(4, 15)); // big joker
		}

		cards = finalDeck;

	}
	
	/**
	 * Method that fills a special deck of cards
	 * @param a ArrayList of cards with which the special deck of cards is filled with
	 */
	public void fillSpecial(ArrayList<Card> a) {
		cards = a;
	}

	/**
	 * Method that shuffles all cards in a CardStack
	 */
	public void scramble() {
		// Use of a Fisher-Yates shuffle
		for (int i = cards.size() - 1; i > 0; i--) {
			Random rand = new Random();
			int index = rand.nextInt(i + 1);

			Card a = cards.get(index);
			cards.set(index, cards.get(i));
			cards.set(i, a);

		}

	}
	
	public Card generateRandom() {
		Random rand = new Random();
		int randomSuit = rand.nextInt(4);
		int randomVal = rand.nextInt(14);
		return new Card(randomSuit, randomVal);
	}
	
	/**
	 * Method that adds a card to a CardStack
	 * @param a Card that is added to a CardStack
	 */
	public void addCard(Card a) {
		cards.add(a);
	}
	
	/**
	 * Method that removes a card to a CardStack
	 * @param a Card that is in the CardStack
	 */
	public void removeCard(Card a) {
		cards.remove(a);
	}

	/**
	 * Method that assigns an owner to a CardStack
	 * @param a The player number that a CardStack is assigned to
	 */
	public void setPlayerOwner(int a) {
		this.playerOwner = a;
	}
	
	/**
	 * Method that determines if a CardStack has jokers
	 * @param a True if a CardStack should have jokers, false if a CardStack should not
	 */
	public void setHasJokers(boolean a) {
		this.hasJokers = a;
	}
	
	/**
	 * Method that reports the owner of a CardStack, if the CardStack has joker(s) in it, and how big the player's CardStack is
	 */
	public String toString() {
		return playerOwner + " " + hasJokers + " " + cards.size();
	}
	
	/**
	 * Draws the CardStack using a PApplet
	 * 
	 * @param marker PApplet
	 * @param x x - position
	 * @param y y - position
	 */
	public void draw(PApplet marker, float x, float y) {
		for (int i = 0; i < cards.size(); i += 35) {
			cards.get(i).draw(marker, (int) x + i, (int) y); 
		}
	}
	
}