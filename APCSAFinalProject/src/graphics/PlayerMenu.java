package graphics;
import cardgames.BlackJack;
import processing.core.PApplet;

/**
 * Represents the menu that appears once the user decides to play the game
 */
public class PlayerMenu {
	
	private BlackJack b; 
	private boolean clickJoin;
	
	/**
	 * no args constructor
	 */
	public PlayerMenu() {
		b = new BlackJack(); 
	}
	
	/**
	 * sets up PlayerMenu
	 */
	public void setup() {

	}
	
	/**
	 * draws text asking for the number of players
	 * @param marker - the PApplet on which the PlayerMenu is drawn
	 */
	public void draw(PApplet marker) {
		marker.background(255);	
		
		marker.textSize(32);
		marker.text("Choose # of players from 2 - 4", 160, 200); 
		
		marker.noFill();
		for (int i = 0; i < 3 * 120; i += 120) {
			marker.square(220 + i, 300, 120);
		}
		marker.text("2", 260, 360);
		marker.text("3", 380, 360);
		marker.text("4", 500, 360);
		
	}
	
	
	/**
	 * basic getter for the boolean that tests whether the join button has been clicked
	 * @return - whether the clickJoin is true or false
	 */
	public boolean getClickJoin() {
		return clickJoin; 
	}
	
	/**
	 * 
	 * @param marker - PApplet upon which this boolean sees if the mouse is clicked
	 * @param x - the x coordinate of the rectangle
	 * @param y - the y coordinate of the rectangle
	 * @param width - the horizontal width of the rectangle
	 * @param height - the vertical height of the rectangle
	 * @return - whether or not the mouse has clicked on the rectangle
	 */
	public boolean clickRect (PApplet marker, int x, int y, int width, int height) {	
		if (marker.mouseX >= x && marker.mouseX <= x+width && marker.mouseY >= y && marker.mouseY <= y+height) {
			return true;
		}
		else {
			
			return false;
		}
	}
}
