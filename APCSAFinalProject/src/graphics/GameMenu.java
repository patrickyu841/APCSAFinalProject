package graphics;
import cardgames.BlackJack;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents the main menu on program startup
 */
public class GameMenu {
  
	private boolean clickInstruction, clickHost; 
	PImage instructions; 
	
	/**
	 * Creates a GameMenu 
	 */
	public GameMenu() {		
		
		clickInstruction = false;
		clickHost = false;
	
	}
	
	/**
	 * Setup for GameMenu menu
	 */
	public void setup() {
		
	}
	
	/**
	 * Draws the main menu which includes a POKER and HOW TO PLAY button
	 * @param marker - PApplet for which the main menu is drawn with
	 */
	public void draw(PApplet marker) {
		//update(marker, marker.mouseX, marker.mouseY); //Was causing issues with clicking buttons, not using for now
		
		
		if (clickHost == false && clickInstruction == false) { 
			
			//Blackjack button
			marker.noFill(); 
			marker.rect(225, 150, 350, 80); 	
			marker.textSize(32);	
			if (marker.mouseX >= 225 && marker.mouseX <= 225 + 350 && marker.mouseY >= 150 && marker.mouseY <= 150 + 80) {
				marker.fill(0, 255, 0);
			} else {
				marker.fill(0);
			}		
			marker.text("BLACKJACK", 290, 200); //Top menu option
			
			//How to play button
			marker.noFill(); 
			marker.rect(225, 250, 350, 80); 	
			marker.textSize(32);
			if (marker.mouseX >= 225 && marker.mouseX <= 225 + 350 && marker.mouseY >= 250 && marker.mouseY <= 250 + 80) {
				marker.fill(0, 255, 0);
			} else {
				marker.fill(0);
			}
			marker.text("HOW TO PLAY", 290, 300); //Bottom menu option
		}
		
		if (clickHost == true) { //Should draw host's menu, may need to make new class HostMenu instead of using PlayerMenu

		}
			
	}
	
	/**
	 * constructs an image denoting the values of each card in BlackJack
	 * brief overview of the rules of the game
	 * @param marker - the PApplet on which the instructions are drawn
	 */
	public void drawInstructions(PApplet marker) {		
		instructions = marker.loadImage("data\\Blackjack-values.png");
		marker.image(instructions, 0, 0, 400, 200);
		
		marker.textSize(10);
		marker.fill(0); 
		marker.text("Each player gets two cards to start with. "
			+ "\n One card is face up, the other is face down "
			+ "\n They can choose to either pick up another card or remain. "
			+ "\n Once all players are happy with their hand, everyone flips up their blind card "
			+ "\n The player with the score closest to 21 without going over wins.", 410, 0);
	}	
	
	/**
	 * Constantly updates the program to see if the user has clicked a button
	 * @param marker - PApplet that draws the rectangular button that can be clicked
	 * @param x - Represents the x coordinate of the user's mouse
	 * @param y - Represents the y coordinate of the user's mouse
	 */
	public void update(PApplet marker, int x, int y) { //Bug: For some reason only 2nd line (in this case poker) is checked
		
		if (clickRect(marker, 225, 150, 350, 80)) {  //Host button
			clickHost = true;
			clickInstruction = false;
		}
		
		if (clickRect(marker, 225, 350, 350, 80)) {  //Instructions button
			clickInstruction = true;
			clickHost = false;
		}
		
		if (clickRect(marker, 225, 250, 350, 80)) { //Join button
			clickHost = false;
			clickInstruction = false;
		}
		
		else {
			clickInstruction = false;
			clickHost = false;
		}
		
	}
	
	/**
	 * sets the clickInstruction boolean to true or false
	 * @param test - the boolean which we want to set clickInstruction to
	 */
	public void setClickInstruction(boolean test) {
		if (test) {
			clickInstruction = true;
		} else {
			clickInstruction = false; 
		}
	}
	
	/**
	 * basic getter for the boolean that tests whether the instructions button has been clicked
	 * @return - whether the clickInstruction is true or false
	 */
	public boolean getClickInstructions() {
		return clickInstruction; 
	}
	
	public boolean getClickHost() {
		return clickHost; 
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
