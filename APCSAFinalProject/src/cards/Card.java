package cards;
import processing.core.PApplet;

/**
 * Represents a single card
 * 
 */

public class Card { // Tested; methods all work! (05/10/2020)

	private int suit; // clubs - 0, diamonds - 1, hearts - 2, spades - 3
	private int number;
	private float x;
	private float y;
	private boolean faceUp; 
	
	/**
	 * 
	 * No args constructor, automatically sets the card to the Ace of Spades
	 */
	public Card() {
		this.suit = 3;
		this.number = 1;
		faceUp = true;
	}

	/**
	 * @pre suit number is expressed as clubs - 0, diamonds - 1, hearts - 2, spades
	 *      - 3, none - 4
	 * @pre card number must be between 1 inclusive and 15 inclusive, 1 being ace,
	 *      13 being king, 14 and 15 being small and big joker
	 * @param suit   - the suit of the card (spade, club, hearts, diamonds)
	 * @param number - the value of the card (ace, 2 through 10, jack, queen, king)
	 */
	public Card(int suit, int number) {
		this.suit = suit;
		this.number = number;
		faceUp = true; 
	}
	
	/**
	 * basic getter for whether the face is up or down
	 * @return the face of the card
	 */
	public boolean getFace() {
		return faceUp;
	}
	
	/**
	 * basic getter for the card value
	 * @return the value of the card
	 */
	public int getNum() {
		return number;
	}
	
	/**
	 * basic getter for the suit of the card
	 * @return the suit of the card
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * basic getter for the x position of the card
	 * @return the x position of the card
	 */
	public float getX() {
		return x;
	}

	/**
	 * basic getter for the y position of the card
	 * @return - the y position of the card
	 */
	public float getY() {
		return y;
	}

	/**
	 * basic setter for the x position
	 * @pre must be within the PApplet's bounds
	 * @param num - the x value you want to set it to 
	 */
	public void setX(float num) {
		x = num;
	}

	/**
	 * basic setter for the y position
	 * @pre must be within the PApplet's bounds
	 * @param num - the y value you want to set it to 
	 */
	public void setY(float num) {
		y = num;
	}
	
	/**
	 * setter for the suit of the card
	 * @pre x must be from 0 to 3 inclusive, or else an argument exception will be thrown
	 * @param x - the suit, represented by an int, that you want to set a card to
	 */
	public void setSuit(int x) {
		this.suit = x;
	}

	/**
	 * setter for the value of the card
	 * @pre x must be from 1 to 13 inclusive, or else an argument exception will be thrown
	 * @param x - the suit, represented by an int, that you want to set a card to
	 */
	public void setNumber(int x) {
		this.number = x;
	}
	
	public void setFace(boolean test) {
		faceUp = test; 
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
	public boolean clickedCard(PApplet marker) {
		if (marker.mouseX >= x && marker.mouseX <= x + 32 && marker.mouseY >= y && marker.mouseY <= y + 45) {
			return true;
		} else {

			return false;
		}
	}

	/**
	 * draws the card based on its suit and number
	 * @param marker - the PApplet on which the card is drawn
	 */
	public void draw(PApplet marker, int x, int y) {
		marker.stroke(0);
		marker.fill(255);
		marker.rect(x, y, 32, 45); // constructs the rectangular card shape, with the dimensions of a standard
									// playing card
		if (faceUp) {	
			if (suit == 0) {//clubs
				marker.fill(0); //clubs and spades are black
				marker.textSize(9);
				marker.text("Clubs", x, y + 43);
			} else if (suit == 1) {//diamonds
				marker.fill(255, 0, 0); //hearts and diamonds are red
				marker.textSize(7);
				marker.text("Diamond", x, y + 43);
			} else if (suit == 2) {//hearts
				marker.fill(255, 0, 0); //hearts and diamonds are red
				marker.textSize(9);
				marker.text("Hearts", x, y + 43);
			} else if (suit == 3) {//spades
				marker.fill(0); //clubs and spades are black
				marker.textSize(9);
				marker.text("Spades", x, y + 43);
			}
	
			if (number == 1) {
				// draw an ace
				marker.textSize(20);
				marker.text("A", x + 18, y + 16);
			} else if (number == 2) {
				marker.textSize(20);
				marker.text("2", x + 18, y + 16);
			} else if (number == 3) {
				marker.textSize(20);
				marker.text("3", x + 18, y + 16);
			} else if (number == 4) {
				marker.textSize(20);
				marker.text("4", x + 18, y + 16);
			} else if (number == 5) {
				marker.textSize(20);
				marker.text("5", x + 18, y + 16);
			} else if (number == 6) {
				marker.textSize(20);
				marker.text("6", x + 18, y + 16);
			} else if (number == 7) {
				marker.textSize(20);
				marker.text("7", x + 18, y + 16);
			} else if (number == 8) {
				marker.textSize(20);
				marker.text("8", x + 18, y + 16);
			} else if (number == 9) {
				marker.textSize(20);
				marker.text("9", x + 18, y + 16);
			} else if (number == 10) {
				marker.textSize(20);
				marker.text("10", x + 7, y + 16);
			} else if (number == 11) {
				marker.textSize(20);
				marker.text("J", x + 18, y + 16);
			} else if (number == 12) {
				marker.textSize(20);
				marker.text("Q", x + 18, y + 16);
			} else if (number == 13) {
				marker.textSize(20);
				marker.text("K", x + 18, y + 16);
			}
		} 
	}
	
	/**
	 * returns the string version of the card
	 */
	public String toString() {
		return this.suit + " " + this.number;
	}
	
}
