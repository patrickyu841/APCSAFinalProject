package graphics;

import cardgames.BlackJack;
import processing.core.PApplet;

/**
 * Represents the "table" for which the user can play on
 */
public interface PlayingBoard {
	
	/**
	 * draws the playing board
	 * @param marker - the PApplet on which the playing board is drawn
	 */
	public abstract void draw(PApplet marker);
	
	
}
