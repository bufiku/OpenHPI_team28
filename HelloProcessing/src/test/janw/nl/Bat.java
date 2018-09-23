package test.janw.nl;

public class Bat { 
	// This class was written as a part of creating a squash program for the Open.HPI.de course "Java Capstone series 1."
	
	// This class is responsible for the bat; it has attributes for x- & y-position and the speed 
	// It has a fixed length and height; it would be nice to get those as parameters in the constructore in a next iteration.
	// It also remembers on which canvas (playing field) it is painted.
	private float x_as; 
	private float y_as;  
	private float speed = 3; 
	private float batLength = 70;
	private float batHeight = 14; 
	private PlayField playField;
	
	
	public Bat( PlayField playField ) {
		// Constructor
		// The constructor takes the canvas as input, so it knows where it lives 
		// and can ask the size of its canvas (borders)
		this.playField = playField; // tell the bat where he must draw himself
		this.y_as = this.playField.getPlayfieldLength() - 40; // leave some space under the bat; would be nice to make this an attribute or parameter
		this.x_as = ( this.playField.getPlayfieldLength() - this.batLength ) /2; // put the bat in the middle of the playfield
	}
	
	public void moveLeft() {
		// Move the bat to the left; taking into account the speed of the bat; ánd the wall
		if ( x_as - speed < 0 ) {
			x_as = 0; 
		} else {
			x_as -= speed; 
		}
	}
	
	public void moveRight() {
		// Move the bat to the right; taking into account the speed of the bat; ánd the wall
		if ( x_as + speed >  ( playField.getPlayfieldLength() - batLength) ) {
			x_as = playField.getPlayfieldLength() - ( batLength + 1 ) ; 
		} else {
			x_as += speed; 
		};
	}
	
	
	public void draw() {
		// Draw the bat as a rectangle on the canvas
		playField.fill(20,50,240); // give some color
    	playField.rect(x_as, y_as , batLength, batHeight, 4);
    	// x_as is the horizontal place, then  the vertical place , length & height of rectangle, rounded corners.
	}
	

	
	
	public float getX_as() {
		// Generated Getters & setters for the attributes
		return x_as;
	}
	public void setX_as(float x_as) {
		// Generated Getters & setters for the attributes
		this.x_as = x_as;
	}
	public float getY_as() {
		// Generated Getters & setters for the attributes
		return y_as;
	}
	public float getBatLength() {
		// Generated Getters & setters for the attributes
		return batLength;
	}
	public void setBatlength(float batLength) {
		// Generated Getters & setters for the attributes
		this.batLength = batLength;
	}
	public float getBatHeight() {
		// Generated Getters & setters for the attributes
		return batHeight;
	}

	
}
