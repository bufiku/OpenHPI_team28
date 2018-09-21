package test.janw.nl;

// import processing.core.PApplet; // Not necessary? 

public class Ball { 
	
	private float x_as ; 
	private float y_as ; 
	private float radius; 
	private PlayField playField;
	// private boolean goingUp = true;
	private double speed; 
	private int angle; 
	
	// constructor
	public Ball( PlayField playField, float start_x, float start_y, float radius, double speed, int angle ) {
		this.playField = playField; 
		this.x_as = start_x;
		this.y_as = start_y - radius/2;
		this.radius = radius;
		this.speed = speed;
		this.angle = angle;
	}
	
	public void move() {
		if ( y_as - speed <= (radius/2) ) { // Is it hitting the upper wall // For breakout check against the array of bricks
			y_as = radius;
			speed = speed * (-1);
		} else if  ( y_as - speed >= ( playField.getBat().getY_as() ) ) // Is it the same height as the bat?
				// && ( y_as <= playField.getPlayfieldLength() ) ) // Not yet on the lower side of the playfield
				{
			// Does it hit the bat? 
			if ( this.x_as >= ( playField.getBat().getX_as() ) // - playField.getBat().getBatlength()/2 ) 
					&& 
				 this.x_as <= ( playField.getBat().getX_as() + playField.getBat().getBatlength() )
				 ) {
				// Yes it hits the bat
				speed = speed * (-1);
			} else {
				//GAME OVER 
				// ToDo Implement nice ending of the game
				System.out.println("Game over: speed & y_as " + speed + " " + y_as ); 
				y_as -= speed;
			}
		} else {
			y_as -= speed; 
		}
		// for testing; let the ball go up again if it hits the lower edge.
		if ( y_as >= playField.getPlayfieldLength() - radius/2 ) {
			System.out.println("I want to check this speed & y_as " + speed + " " + y_as ); 
			speed = java.lang.Math.abs( speed ) ; // make speed positive again. 
		}
	}
	
	public void draw() {
		playField.fill(20,50,40);
    	playField.ellipse(x_as, y_as, radius, radius);
    	// x_as is the horizontal place, then  the vertical place , length & height of rectangle, rounded corners.
	}
}
