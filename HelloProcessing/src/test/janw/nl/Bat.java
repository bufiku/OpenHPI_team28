package test.janw.nl;

public class Bat { 
	
	private float x_as; 
	private float y_as;  
	private float batLength = 70;
	private float batHeight = 14; 
	private PlayField playField;
	
	// constructor
	public Bat( PlayField playField ) {
		this.playField = playField; // tell the bat where he must draw himself
		this.y_as = this.playField.getPlayfieldLength() - 40; // leave some space under the bat.
		this.x_as = ( this.playField.getPlayfieldLength() - this.batLength ) /2; // put the bat in the middle of the playfield
	}
	
	public void moveLeft() {
		if ( x_as - 3 < 0 ) {
			x_as = 0; 
		} else {
			x_as -= 3; 
		}
	}
	
	public void moveRight() {
		if ( x_as + 3 >  ( playField.getPlayfieldLength() - batLength) ) {
			x_as = playField.getPlayfieldLength() - ( batLength + 1 ) ; 
		} else {
			x_as += 3; 
		};
	}
	
	
	public void draw() {
		playField.fill(20,50,240); // give some color
    	playField.rect(x_as, y_as , batLength, batHeight, 4);
    	// x_as is the horizontal place, then  the vertical place , length & height of rectangle, rounded corners.
	}
	
	// Getters & setters	
	public float getX_as() {
		return x_as;
	}
	public void setX_as(float x_as) {
		this.x_as = x_as;
	}
	public float getY_as() {
		return y_as;
	}
	public float getBatLength() {
		return batLength;
	}
	public void setBatlength(float batLength) {
		this.batLength = batLength;
	}
	public float getBatHeight() {
		return batHeight;
	}

	
}
