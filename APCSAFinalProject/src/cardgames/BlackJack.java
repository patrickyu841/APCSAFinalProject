package cardgames;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import cards.*;
import graphics.PlayingBoard;
import processing.core.PApplet;
import processing.core.PImage;


/**
 * Represents the rule set for the card game BlackJack
 * 
 */

public class BlackJack implements PlayingBoard {

	
	
//	private Player winner = null;
//	private int numRounds = 1;
//	private int numTurns = 1;
	private int numPlayers, random1, random2, random3, random4;
	private boolean clickExit, winner;
	private ArrayList<CardStack> playerStacks; 
	private ArrayList<Card> playerCards;
	private boolean hit;

	/**
	 * no args constructor for blackjack
	 */
	public BlackJack() {
		numPlayers = 0;
		random1 = (int) ((Math.random() * 7) + 14);
		random2 = (int) ((Math.random() * 7) + 14);
		random3 = (int) ((Math.random() * 7) + 14);
		random4 = (int) ((Math.random() * 7) + 14);
		
		hit = false;
		
		//generate random cards not working, draws an infinite stream of random cards
		playerStacks = new ArrayList<CardStack>(); 
		for (int i = 0; i < numPlayers; i++) {
			playerStacks.add(new CardStack());
		}
	
		//generates the first to cards for the player
		playerCards = new ArrayList<Card>();
		
		Random rand = new Random();
		int randomSuit = rand.nextInt(4);
		int randomVal = rand.nextInt(13);
		if (randomVal == 0) {
			randomVal = 1;
		}
		Card blind = new Card(randomSuit, randomVal);
		blind.setFace(false);
		
		int randomSuit2 = rand.nextInt(4);
		int randomVal2 = rand.nextInt(13);
		if (randomVal2 == 0) {
			randomVal2 = 1;
		}
		Card secondCard = new Card(randomSuit2, randomVal2);
		
		int randomSuit3 = rand.nextInt(4);
		int randomVal3 = rand.nextInt(13);
		if (randomVal3 == 0) {
			randomVal3 = 1;
		}
		Card blind2 = new Card(randomSuit3, randomVal3);
		blind2.setFace(false);
		
		int randomSuit4 = rand.nextInt(4);
		int randomVal4 = rand.nextInt(13);
		if (randomVal4 == 0) {
			randomVal4 = 1;
		}
		Card blind3 = new Card(randomSuit4, randomVal4);
		blind3.setFace(false);
		
		int randomSuit5 = rand.nextInt(4);
		int randomVal5 = rand.nextInt(13);
		if (randomVal5 == 0) {
			randomVal5 = 1;
		}
		Card blind4 = new Card(randomSuit5, randomVal5);
		blind4.setFace(false);
		
		playerCards.add(blind);
		playerCards.add(secondCard);
		playerCards.add(blind2);
		playerCards.add(blind3);
		playerCards.add(blind4);
	}
	
	/**
	 * basic getter for whether the player has hit
	 * @return the boolean for if the player has hit
	 */
	public boolean getHit() {
		return hit;
	}
	
	/**
	 * basic setter for the boolean that sees if the player has chosen to hit
	 */
	public void setHit (boolean test) {
		hit = test;
	}
	
	/**
	 * basic setter for the number of players
	 * @return the number of players
	 */
	public void setNumPlayers(int num) {
		numPlayers = num; 
	}
	
	/**
	 * basic getter for the number of players
	 * @return the number of players
	 */
	public int getNumPlayers() {
		return numPlayers; 
	}
	
	/**
	 * basic setter for the boolean that dictates whether the player exits
	 * @param test the boolean that indicates if the player has exited
	 */
	public void setClickExit(boolean test) {
		clickExit = test;
	}
	
	/**
	 * basic getter for the boolean that sees whether the player has exited
	 * @return whether the player has exited
	 */
	public boolean getClickExit() {
		return clickExit;
	}
	
	/**
	 * basic getter for the player's hand
	 * @return an arraylist of cards that the player has
	 */
	public ArrayList<Card> getPlayerHand() {
		return playerCards; 
	}
	
	/**
	 * generates a random card
	 * @return a random card 
	 */
	public Card generateRandom() {
		Random rand = new Random();
		int randomSuit = rand.nextInt(4);
		int randomVal = rand.nextInt(14);
		return new Card(randomSuit, randomVal);
	} 
	
	/**
	 * adds a new face up card to the player's hand
	 * @param marker the PApplet on which the message is drawn
	 */
	public void hit(PApplet marker) {
		for (int i = 2; i < playerCards.size(); i++) {
			if (playerCards.get(i).clickedCard(marker)) {
				playerCards.get(i).setFace(true);
			}
		}
	}

	/**
	 * 
	 * @param marker - PApplet upon which this boolean sees if the mouse is clicked
	 * @param x      - the x coordinate of the rectangle
	 * @param y      - the y coordinate of the rectangle
	 * @param width  - the horizontal width of the rectangle
	 * @param height - the vertical height of the rectangle
	 * @return - whether or not the mouse has clicked on the rectangle
	 */
	public boolean clickRect(PApplet marker, int x, int y, int width, int height) {
		if (marker.mouseX >= x && marker.mouseX <= x + width && marker.mouseY >= y && marker.mouseY <= y + height) {
			return true;
		} else {

			return false;
		}
	}
	
	/**
	 * checks the winner based on the value of the player's hand. If the value is over 21, there is no way for the player to win
	 * if the player either has 21 or has the closest value to 21, then he or she wins
	 * @param marker the PApplet on which the message is drawn
	 */
	public void checkWinner(PApplet marker) {
		int playerValue = getSum();
		int difference = 21 - playerValue;
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(difference);
		values.add(21 - random1);
		values.add(21 - random2);
		if (numPlayers == 3) {
			values.add(21 - random3);
		} else if (numPlayers == 4) {
			values.add(21 - random3);
			values.add(21 - random4);
		}
		
		if (difference < 0) {
			winner = false;
		} else if (difference == 0) {
			winner = true;
		} else {
			for (int i = 0; i < values.size(); i++) {
				if (values.get(i) < difference && values.get(i) >= 0) {
					winner = false;
				} else {
					winner = true;
				}
			}
		}
	}
	
	/**
	 * Draws a message either congrulating the victor or informing the player of his or her loss
	 * @param marker the PApplet on which the message is drawn
	 */
	public void declareWinner(PApplet marker) {
		if (winner) {
			marker.text("You won", 400, 400);
		} else {
			marker.text("You lost", 400, 400);
		}
	}
	
	/**
	 * Reveals the player's blind card and reveals the scores of the other opponents
	 * @param marker the PApplet on which the message is drawn
	 * @param test boolean to see if it is time to reveal
	 */
	public void reveal(PApplet marker, boolean test) {
		if (test) {
			playerCards.get(0).setFace(true);
			//generates random values
			if(numPlayers == 2) {
				marker.fill(255);
				marker.textSize(32);
				marker.text(random1, 200, 300);
				marker.text(random2, 600, 300);
			} else if (numPlayers == 3) {
				marker.fill(255);
				marker.textSize(32);
				marker.text(random1, 800 / 3, 300);
				marker.text(random2, 400, 300);
				marker.text(random3, 1600 / 3, 300);
			} else if (numPlayers == 4) {
				marker.fill(255);
				marker.textSize(32);
				marker.text(random1, 100, 300);
				marker.text(random2, 300, 300);
				marker.text(random3, 500, 300);
				marker.text(random4, 700, 300);
			}
		}
	}
	
	/**
	 * sums up the player's total score by recognising the value of each of his or her cards
	 * @return the value of his hand
	 */
	public int getSum() {
		int result = 0;
		for (int i = 0; i < playerCards.size(); i++) {
			if (playerCards.get(i).getFace()) {
				result += playerCards.get(i).getNum();
			}
		}
		return result; 
	}
	
	/**
	 * draws the playing board, the players hand, and all necessary buttons
	 */
	public void draw(PApplet marker) {
		// basic background
		marker.background(53, 101, 77);
		marker.fill(53, 101, 77);
		marker.line(0, 500, 800, 500);
		for (int i = 0; i < 800; i += 800 / numPlayers) {
			marker.line(i, 0, i, 500);
		}
//		marker.circle(400, 400, 100);
//		for (int i = 0; i < numPlayers; i++) {
//			marker.stroke(218, 213, 82);
//			marker.line((float) 400 + (float) (50 * Math.cos(i * 2 * Math.PI / numPlayers)),
//					(float) 400 + (float) (50 * Math.sin(i * 2 * Math.PI / numPlayers)),
//					(float) 400 + (float) (1000 * Math.cos(i * 2 * Math.PI / numPlayers)),
//					(float) 400 + (float) (1000 * Math.sin(i * 2 * Math.PI / numPlayers)));
//		}

		// exit button
		marker.stroke(255);
		marker.square(10, 10, 20);
		marker.line(10, 10, 30, 30);
		marker.line(10, 30, 30, 10);

		// hit button
		marker.stroke(0);
		marker.fill(255);
		marker.rect(700, 550, 32, 45);
		marker.rect(702, 550, 32, 45);
		marker.rect(704, 550, 32, 45);
		marker.rect(706, 550, 32, 45);
		
		//draws opponents' hand
		
		
		//draws player hand
		marker.textSize(32);
		marker.fill(255);
		marker.text("Your Hand: ", 10, 550);
		for (int i = 0; i < playerCards.size(); i++) {
			playerCards.get(i).draw(marker, (i * 40) + 300, 600);
		}
		
		//draws the reveal hand button
		marker.stroke(255, 255, 255);
		marker.noFill();
		marker.rect(620, 650, 150, 30);
		marker.fill(255);
		marker.textSize(22);
		marker.text("Reveal Hand", 630, 670);
		
	}
	
}
