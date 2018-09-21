package test.janw.nl;

import processing.core.PApplet;

public class PlayField extends PApplet {

	private int playfield_length = 450;  			// This determines the size of the total screen or playing field
	private Bat bat = new Bat( this ) ;  			// Create a new Bat and enter the playing field as bat needs to know where he will put himself
	private Ball ball = new Ball( this, 			// Create a new ball
								  ( bat.getX_as()+( bat.getBatLength()/2 ) ) , // start Ball at the middle position of the bat
								  bat.getY_as() , 	// start at the bat
								  8, 				// radius of the ball
								  3, 				// speed
								  -45				// angle
								);
	
	
	public static void main(String[] args) {
		
		PApplet.main("test.janw.nl.PlayField");

	}
	
	@Override
    public void settings(){
    	size(playfield_length,playfield_length);  // Set the size of the playing field
    }
	
	@Override
    public void setup(){
    	fill(20,50,240);  // add some blue color to the bat
    	background(222);
    }

	@Override
	public void draw(){
    	 
    	if ( keyPressed ) { 
    		// System.out.println("KeyCode = " + keyCode); // To find out which keys can be pressed. 
//    		left-arrow  = 37   
//    		up-arrow    = 38
//    		right-arrow = 39
//    		down-arrow  = 40
//    		key "a"     = 65
//    		key "s"     = 83
    		if ( ( keyCode == 37 ) || ( keyCode == 65 ) ){
    			bat.moveLeft();
    		} else if ( ( keyCode == 39 ) || ( keyCode == 83 ) ) { 
    			bat.moveRight();
    		};
    	};
    	
// Set the background again, so we have no trailing leftovers from the bat. 
    	background(222); 
    	ball.move();
    	ball.draw();
    	bat.draw(); // Draw the bat
    	// System.out.println("Bat is Drawn"); 
    }

	
	public int getPlayfieldLength() {
		return this.playfield_length;
	}
	
	public Bat getBat() {
		return this.bat;
	}
}
