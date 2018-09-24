package test.janw.nl;

import processing.core.PApplet;
import processing.core.PFont; 

/**
 * This class was written as a part of creating a squash program for the
 * Open.HPI.de course "Java Capstone series 1."
 * 
 * This class is more or less the canvas where the ball and bat is painted on.
 * In here we define the size of the playing field When creating an object of
 * this class, both a bat and a ball is created and linked to this class as an
 * attribute The ball is created at the middle of the bat (or paddle) using the
 * bat-reference.
 * 
 * ToDo : What would be nice is to change the ball and bat into two classes that
 * inherit the same interface This interface would define a method move and draw
 * (or those combined in one) so that we can create an array of objects
 * belonging to this canvas, and just loop over this array. This would be a
 * nicer start if we were to create a space invaders or breakout-game
 */
public class PlayField extends PApplet {

	private int playfield_length = 500; // This determines the size of the total screen or playing field
	private Bat bat = new Bat(this); 	// Create a new Bat and enter the playing field as bat needs to know where he
										// will put himself
	private Ball ball = new Ball(this, 	// Create a new ball and give the playing field as the ball needs to know where
										// she will put herself
			(bat.getX_as() + (bat.getBatLength() / 2)), // start Ball at the middle position of the bat
			bat.getY_as(), 				// start at the height of the bat
			8, 							// radius of the ball
			6, 							// speed
			-45 );						// angle
	private PFont font;

	/**
	 * The starting point of the whole app. Tell the Processing framework where we
	 * start; eg, tell them we start from here.
	 */
	public static void main(String[] args) {
		PApplet.main("test.janw.nl.PlayField");
	}

	/**
	 * Sets the size of the playing field
	 */
	@Override
	public void settings() {
		size(playfield_length, playfield_length);
	}

	/**
	 * Gives the canvas a color, I like it a bit grey
	 */
	@Override
	public void setup() {
		background(222);
		font = createFont("Arial",16,true); // Set the font and size
	}

	/**
	 * In the draw method check if keys are pressed and react to some keys, Then we
	 * paint every object on the canvas. First the background (to prevent trailing
	 * pictures) After that we move the ball, and then paint the ball and bat. ToDo
	 * : What would be nice is to change the ball and bat into two classes that
	 * inherit the same interface This interface would define a method move and draw
	 * (or those combined in one) so that we can create an array of objects
	 * belonging to this canvas, and just loop over this array. This would be a
	 * nicer start if we were to create a space invaders or breakout-game
	 */
	@Override
	public void draw() {
		if (keyPressed) {
			// System.out.println("KeyCode = " + keyCode); // To find out which keys can be
			// pressed.
			// left-arrow = 37
			// up-arrow = 38
			// right-arrow = 39
			// down-arrow = 40
			// key "a" = 65
			// key "s" = 83
			if ((keyCode == 37) || (keyCode == 65)) {
				bat.moveLeft(); // If key is pressed, move the ball
			} else if ((keyCode == 39) || (keyCode == 83)) {
				bat.moveRight(); // If key is pressed, move the ball
			}
			;
		}
		;

		// Set the background again, so we have no trailing leftovers from the bat.
		background(222);
		// Move and draw the objects
		try {
			ball.move(); 	// Move the ball
		} catch (Exception e) {
			System.out.println("Game over");
			textFont(font,30);  // Set the size of the font
			fill(120); 			// Set the color of the letters
			text("You loose!", playfield_length/2 - 50, playfield_length/2); // display text
			noLoop(); 			// Stop processing
								// Thanks to documentation: https://www.processing.org/tutorials/text/
		}
		ball.draw(); 	// Draw the ball
		bat.draw(); 	// Draw the bat
		// System.out.println("Bat is Drawn");
	}

	/**
	 * getter for the length
	 */
	public int getPlayfieldLength() {
		return this.playfield_length;
	}

	/**
	 * getter for the bat (paddle)
	 */
	public Bat getBat() {
		return this.bat;
	}
}
