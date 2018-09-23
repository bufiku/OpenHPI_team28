package test.janw.nl;

// import processing.core.PApplet; // Not necessary? 

public class Ball { 

	// This class was written as a part of creating a squash program for the Open.HPI.de course "Java Capstone series 1."
	// This class is responsible for the ball; it has attributes for x- & y-position, the speed and for convenience its speeds 
	// along the x-axis and y-axis (using sin/cos of the angle and the speed)
	// This class has methods for creating, moving and drawing of the ball
	// It has private methods for setting the speed, and bouncing against the walls, ceiling or the bat. 
	
	// What I have doubts about, is the fact that the ball is aware of the canvas (subclass of PApplet of the processing framework). 
	// I would like it if the ball was loosely coupled, without a hard reference. 
	
	// ToDo: For now, if you miss the ball there will only be a System.out.println()-message. That should be made nicer. 
	// My current idea is to raise either an exception; or to raise an event, so I will learn something about catching events. 
	// Furthermore, I think it would be nice to refactor the whole solution to a model-view-controller. 
	// However, as the deadline of the course approaches, and the rest of the team does not seem to be very active, 
	// this will most likely be the solution to be submitted.
	
	private float x_as ; 
	private float y_as ; 
	private float radius; 
	private PlayField playField;
	private double speed; 
	private double x_speed;
	private double y_speed; 
	private int angle; 
	

	public Ball( PlayField playField, float start_x, float start_y, float radius, double speed, int angle ) {
		// constructor
		// The constructor takes the canvas as input, so it knows where it lives (and can ask the size of its canvas (eg. ceiling and borders)
		// Furthermore it gets its starting position (start_x, start_y) and its starting speed and starting angle). 
		// Finally it is being told its size in radius.
		this.playField = playField; 
		this.x_as = start_x ;
		this.y_as = start_y ;
		this.radius = radius;
		this.angle = angle;
		setSpeeds( speed );  // Adjust all speeds, total velocity, and x-axis speed, and y-axis speed
	
	}
	
	public void move() {
		// Method move: This method moves the ball. Furthermore, it checks if the ball hits the ceiling, one of the walls, or the bat/paddle. 
		// If it is at the same height as the bat/paddle, but doesn't hit it for now it generates a message that you lose, currently as a System.out.println()-message.
		// Furthermore, as a temporarily solution, the ground reacts as a boundary as well, so the ball will never leave the canvas. 

		// System.out.println("speed " + speed + " x_as " + x_as + " x_speed " + x_speed  + " y_as " + y_as + " y_speed " + y_speed + " batyaxis " + playField.getBat().getY_as()  ); 
		
		// Check if it hits the right wall
		if ( x_as >= playField.getPlayfieldLength() - radius/2 ) {
			x_as = playField.getPlayfieldLength() - radius/2;
			bounceVertical( ); 
		}
		
		// Check if it hits the left wall
		if ( x_as  <= 0 ) {
			// x_as = radius/2 ;
			bounceVertical( ); 
		}
		
		// Check if it hits the ceiling
		if ( y_as  <= (radius/2) ) { // Is it hitting the upper ceiling // For breakout check against the array of bricks
			bounceHorizontal( );
		} 
		
		// Check if it hits the bat (or misses it)
		if  ( y_as  >= ( playField.getBat().getY_as() ) ) // Is it the same height as the bat?
			{
			// Does it hit the bat? 
			if ( this.x_as > ( playField.getBat().getX_as() ) // left side of the bat 
					&& 
				 this.x_as <= ( playField.getBat().getX_as() + playField.getBat().getBatLength() ) // untill the right side of the bat
				 ) {
				// Yes it hits the bat
				bounceHorizontal( );
			} else {
				// It misses the bat: GAME OVER 
				// ToDo Implement nice ending of the game
				System.out.println("Game over: speed & y_as " + speed + " " + y_as ); 
				// For now, bounce at the bottom
				if ( y_as >= playField.getPlayfieldLength() ) {
					bounceHorizontal( );
				}
			}
		} 
		
		// Adjust the position of the ball.
		y_as += y_speed; 
		x_as += x_speed;
		
	}
	

	public void draw() {
		// Paint the ball on the canvas.
		playField.fill(200,0,0); // Color! 
    	playField.ellipse(x_as, y_as, radius, radius);
    	// x_as is the horizontal place, then  the vertical place , length & height of rectangle, rounded corners.
	}
	

	private void bounceHorizontal() {
		// Bounce on a horizontal boundary (eg. ceiling or bat/paddle)
		// System.out.println("bounceHorizontal");
		this.y_speed = this.y_speed * (-1);
	}
	
	private void bounceVertical() {
		// Bounce on a vertical boundary (eg. one of the walls)
		//System.out.println("bounceVrtical");
		this.x_speed = this.x_speed * (-1);
	}
	
	private void setSpeeds(double newSpeed ) {
		// Set the speed; total speed and the relative speed on the axis of the canvas; using the sin and cos of the angle.
		this.speed = newSpeed;
		this.x_speed = java.lang.Math.sin(java.lang.Math.toRadians(angle)) * speed;
		this.y_speed = java.lang.Math.cos(java.lang.Math.toRadians(angle)) * speed;
	}
}
