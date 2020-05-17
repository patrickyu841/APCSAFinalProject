package cardgames;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
	private int numPlayers;
	private boolean clickExit;
	private ArrayList<CardStack> playerStacks; 
//	private boolean hit;

	/**
	 * no args constructor for blackjack
	 */
	public BlackJack() {
		playerStacks = new ArrayList<CardStack>(); 
		numPlayers = playerStacks.size(); 
		
	}
	
	public void assignCards() {
//		int random = (int) ((Math.random() * 2) + 2); 
		for (int i = 0; i < numPlayers; i++) {
			playerStacks.add(new CardStack());
		}
		for (CardStack stack : playerStacks) {
			stack.getRandomHand(3);
		}
	}
	
	public void setNumPlayers(int num) {
		numPlayers = num; 
	}
	
	public int getNumPlayers() {
		return numPlayers; 
	}
	
	public void setClickExit(boolean test) {
		clickExit = test;
	}

	public boolean getClickExit() {
		return clickExit;
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

	public void declareWinner() {

	}

	public void endGame() {
		
	}
	
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
		marker.rect(370, 370, 32, 45);
		marker.rect(372, 370, 32, 45);
		marker.rect(374, 370, 32, 45);
		marker.rect(376, 370, 32, 45);
		
		//draws each card
		for (int i = 0; i < numPlayers; i++) {
			playerStacks.get(i).draw(marker, 0, 300);
		}
	}
	
}
