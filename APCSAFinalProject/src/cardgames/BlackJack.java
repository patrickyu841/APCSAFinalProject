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

	private int numPlayers, opp1Val, opp2Val, opp3Val, opp4Val;
	private boolean clickExit, winner;
	private ArrayList<Card> playerCards, opponent1, opponent2, opponent3, opponent4;
	private boolean hit;

	/**
	 * no args constructor for blackjack
	 */
	public BlackJack() {
		numPlayers = 0;

		hit = false;
		
		//generates opponent cards
		opponent1 = new ArrayList<Card>();
		int randomSize1 = (int) ((Math.random() * 4) + 2);
		for (int i = 0; i < randomSize1; i++) {
			Random rand = new Random();
			int randomSuit = rand.nextInt(4);
			int randomVal = rand.nextInt(13);
			if (randomVal == 0) {
				randomVal = 1;
			}
			opponent1.add(new Card(randomSuit, randomVal));
		}
		opponent1.get(0).setFace(false);
		for (int i = 0; i < opponent1.size(); i++) {
			opp1Val += opponent1.get(i).getNum();
			if (opponent1.get(i).getNum() == 11) {
				opp1Val -= 1;
			}
			if (opponent1.get(i).getNum() == 12) {
				opp1Val -= 2;
			} 
			if (opponent1.get(i).getNum() == 13) {
				opp1Val -= 3;
			}
		}
		
		opponent2 = new ArrayList<Card>();
		int randomSize2 = (int) ((Math.random() * 4) + 2);
		for (int i = 0; i < randomSize2; i++) {
			Random rand = new Random();
			int randomSuit = rand.nextInt(4);
			int randomVal = rand.nextInt(13);
			if (randomVal == 0) {
				randomVal = 1;
			}
			opponent2.add(new Card(randomSuit, randomVal));
		}
		opponent2.get(0).setFace(false);
		for (int i = 0; i < opponent2.size(); i++) {
			opp2Val += opponent2.get(i).getNum();
			if (opponent2.get(i).getNum() == 11) {
				opp2Val -= 1;
			}
			if (opponent2.get(i).getNum() == 12) {
				opp2Val -= 2;
			} 
			if (opponent2.get(i).getNum() == 13) {
				opp2Val -= 3;
			}
		}
		
		opponent3 = new ArrayList<Card>();
		int randomSize3 = (int) ((Math.random() * 4) + 2);
		for (int i = 0; i < randomSize3; i++) {
			Random rand = new Random();
			int randomSuit = rand.nextInt(4);
			int randomVal = rand.nextInt(13);
			if (randomVal == 0) {
				randomVal = 1;
			}
			opponent3.add(new Card(randomSuit, randomVal));
		}
		opponent3.get(0).setFace(false);
		for (int i = 0; i < opponent3.size(); i++) {
			opp3Val += opponent3.get(i).getNum();
			if (opponent3.get(i).getNum() == 11) {
				opp3Val -= 1;
			}
			if (opponent3.get(i).getNum() == 12) {
				opp3Val -= 2;
			} 
			if (opponent3.get(i).getNum() == 13) {
				opp3Val -= 3;
			}
		}
		
		opponent4 = new ArrayList<Card>();
		int randomSize4 = (int) ((Math.random() * 3) + 3);
		for (int i = 0; i < randomSize4; i++) {
			Random rand = new Random();
			int randomSuit = rand.nextInt(4);
			int randomVal = rand.nextInt(13);
			if (randomVal == 0) {
				randomVal = 1;
			}
			opponent4.add(new Card(randomSuit, randomVal));
		}
		opponent4.get(0).setFace(false);
		for (int i = 0; i < opponent4.size(); i++) {
			opp4Val += opponent4.get(i).getNum();
			if (opponent4.get(i).getNum() == 11) {
				opp4Val -= 1;
			}
			if (opponent4.get(i).getNum() == 12) {
				opp4Val -= 2;
			} 
			if (opponent4.get(i).getNum() == 13) {
				opp4Val -= 3;
			}
		}
		
	
		//generates the cards for the player
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
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		int playerValue = getSum();
		int difference = 21 - playerValue;	
		values.add(difference);
		
		values.add(21 - opp1Val);
		values.add(21 - opp2Val);
		if (numPlayers == 3) {
			values.add(21 - opp3Val);
		} else if (numPlayers == 4) {
			values.add(21 - opp3Val);
			values.add(21 - opp4Val);
		}
		
		if (difference < 0) {
			winner = false;
		} else if (difference == 0) {
			winner = true;
		} else {
			for (int i = 1; i < values.size(); i++) {
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
		//checks and declares winner
		if (winner) {
			marker.textSize(50);
			marker.fill(255, 0, 0);
			marker.text("YOU HAVE WON", 220, 100);
			
			//exit game
			marker.stroke(255);
			marker.square(10, 10, 20);
			marker.line(10, 10, 30, 30);
			marker.line(10, 30, 30, 10);
		} else {
			marker.textSize(50);
			marker.fill(255, 0, 0);
			marker.text("YOU HAVE LOST", 220, 100);
			
			//exit game
			marker.stroke(255);
			marker.square(10, 10, 20);
			marker.line(10, 10, 30, 30);
			marker.line(10, 30, 30, 10);
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
			if (numPlayers == 2) {
				marker.fill(255);
				marker.textSize(32);
				marker.text(opp1Val, 200, 300);
				marker.text(opp2Val, 600, 300);
				opponent1.get(0).setFace(true);
				opponent2.get(0).setFace(true);
				marker.text(getSum(), 400, 530);
			} else if (numPlayers == 3) { 
				marker.fill(255);
				marker.textSize(32);
				marker.text(opp1Val, 200, 300);
				marker.text(opp2Val, 400, 300);
				marker.text(opp3Val, 600, 300);
				opponent1.get(0).setFace(true);
				opponent2.get(0).setFace(true);
				opponent3.get(0).setFace(true);
				marker.text(getSum(), 400, 530);
			} else if (numPlayers == 4) { 
				marker.fill(255);
				marker.textSize(32);
				marker.text(opp1Val, 100, 300);
				marker.text(opp2Val, 300, 300);
				marker.text(opp3Val, 500, 300);
				marker.text(opp4Val, 700, 300);
				opponent1.get(0).setFace(true);
				opponent2.get(0).setFace(true);
				opponent3.get(0).setFace(true);
				opponent4.get(0).setFace(true);
				marker.text(getSum(), 400, 530);
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
				if (playerCards.get(i).getNum() == 11) {
					result -= 1;
				}
				if (playerCards.get(i).getNum() == 12) {
					result -= 3;
				} 
				if (playerCards.get(i).getNum() == 13) {
					result -= 3;
				}
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
		
		//draws player hand
		marker.textSize(32);
		marker.fill(255);
		marker.text("Your Hand: ", 10, 550);
		for (int i = 0; i < playerCards.size(); i++) {
			playerCards.get(i).draw(marker, (i * 40) + 300, 600);
		}
		
		//draws the opponent hand
		if (numPlayers == 2) {
			for (int i = 0; i < opponent1.size(); i++) {
				opponent1.get(i).draw(marker, 0 + 40 * i, 300);
			}
			for (int j = 0; j < opponent2.size(); j++) {
				opponent2.get(j).draw(marker, 400 + 40 * j, 300);
			}
		} else if (numPlayers == 3) {
			for (int i = 0; i < opponent1.size(); i++) {
				opponent1.get(i).draw(marker, 0 + 40 * i, 300);
			}
			for (int j = 0; j < opponent2.size(); j++) {
				opponent2.get(j).draw(marker, (800 / 3) + 40 * j, 300);
			}
			for (int k = 0; k < opponent3.size(); k++) {
				opponent3.get(k).draw(marker, (1600 / 3) + 40 * k, 300);
			}
		} else if (numPlayers == 4) {
			for (int i = 0; i < opponent1.size(); i++) {
				opponent1.get(i).draw(marker, 0 + 40 * i, 300);
			}
			for (int j = 0; j < opponent2.size(); j++) {
				opponent2.get(j).draw(marker, 200 + 40 * j, 300);
			}
			for (int k = 0; k < opponent3.size(); k++) {
				opponent3.get(k).draw(marker, 400 + 40 * k, 300);
			}
			for (int l = 0; l < opponent4.size(); l++) {
				opponent4.get(l).draw(marker, 600 + 40 * l, 300);
			}
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
