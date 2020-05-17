package graphics;
import java.util.ArrayList;
import java.util.Random;

import cardgames.BlackJack;
import cards.Card;
import cards.CardStack;
import processing.core.PApplet;

/**
 * Represents the window for which the game and player menues are drawn in
 */

public class DrawingSurface extends PApplet {
	
	private GameMenu gm = new GameMenu();
	private PlayerMenu pm = new PlayerMenu();
	private boolean instructions, hostGame, hitSecondCard, hitThirdCard, hitFourthCard, reveal;
	private int countInstructions, countPlayGame; 
	private BlackJack b;
	private int players;
//	private Card card; 
	
	/**
	 * Creates a DrawingSurface
	 */
	public DrawingSurface() {
		instructions = gm.getClickInstructions();
		countInstructions = 0;
		hostGame = gm.getClickHost();	
		countPlayGame = 0;
		
		b = new BlackJack();
		players = 0; 
		
//		card = new Card(1, 4);
	}
		
	/**
	 * Sets up DrawingSurface
	 */
	public void setup() {
		
	}
	
	/**
	 * Draws the Gamemenu and lets the player navigate from there
	 */
	public void draw() {
		background(255); 
		
		
		//draws the first game menu
		gm.draw(this);
		
		//if the player clicks any of these buttons twice, the pop ups disappear
		if (hostGame && countPlayGame % 2 == 1) {
			pm.draw(this); 
			instructions = false; 
		} else if (hostGame && countPlayGame % 2 == 0) {
			gm.draw(this);
		}
		
		if (instructions && countInstructions % 2 == 1) {
			gm.drawInstructions(this);
			
		} 
		if (instructions && countInstructions % 2 == 0) {
			gm.draw(this);
		}
		
		//draws the playing board based on the number of players
		switch (players) {
		case 2: 
			b.setNumPlayers(2);
			
			b.draw(this);
			b.reveal(this, reveal);
			if (reveal) {
				b.checkWinner(this);
				b.declareWinner(this);
			}
			break; 
		case 3: 
			b.setNumPlayers(3);		
			b.draw(this);
			b.reveal(this, reveal);
			if (reveal) {
				b.checkWinner(this);
				b.declareWinner(this);
			}
			break; 
		case 4: 
			b.setNumPlayers(4);			
			b.draw(this);
			b.reveal(this, reveal);
			if (reveal) {
				b.checkWinner(this);
				b.declareWinner(this);
			}
			break; 
		}
		
		//player exits the game
		if (b.getClickExit()) {
			background(255); 
			fill(0); 
			text("You have left the game", 200, 400); 
		}
		
		//hits 
		if (hitSecondCard) {
			b.getPlayerHand().get(2).setFace(true);
			b.getPlayerHand().get(2).draw(this, 380, 600);
		}
		if (hitThirdCard) {
			b.getPlayerHand().get(3).setFace(true);
			b.getPlayerHand().get(3).draw(this, 420, 600);
		}
		if (hitFourthCard) {
			b.getPlayerHand().get(4).setFace(true);
			b.getPlayerHand().get(4).draw(this, 460, 600);
		}
	}
	
	/**
	 * Detects whether or not the mouse is clicked on a button or not
	 */
	public void mouseClicked() {
		//sees if the player has clicked the instructions
		if (gm.clickRect(this, 225, 250, 350, 80)) {
			instructions = true;
			countInstructions++; 
		} 
		
		//sees if the player has clicked the exit button on the playingboard
		if (b.clickRect(this, 10, 10, 20, 20)) {
			b.setClickExit(true);
		}
		
		//sees if the player clicks blackjack
		if (gm.clickRect(this, 225, 150, 350, 80)) {
			hostGame = true;
			countPlayGame++; 
		}
		
		//sets the number of players using player input
		if (gm.clickRect(this, 220, 300, 120, 120)) {
			players = 2; 
		} else if (gm.clickRect(this, 340, 300, 120, 120)) {
			players = 3; 
		} else if (gm.clickRect(this, 460, 300, 120, 120)) {
			players = 4; 
		} 
		
		//sees if the player has chosen to hit
		if(b.clickRect(this, 380, 600, 32, 45)) {
			hitSecondCard = true;
		}
		if(b.clickRect(this, 420, 600, 32, 45)) {
			hitThirdCard = true;
		}
		if(b.clickRect(this, 460, 600, 32, 45)) {
			hitFourthCard = true;
		}
		//sees if the player has chosen to reveal his cards
		if (b.clickRect(this, 620, 650, 150, 30)) {
			reveal = true;
		}
	}

}