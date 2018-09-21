package test.janw.nl;

// import processing.core.PApplet; // Not necessary? 

public class Ball { 
	
	private float x_as ; 
	private float y_as ; 
	private float radius; 
	private PlayField playField;
	// private boolean goingUp = true;
	private double speed; 
	private double x_speed;
	private double y_speed; 
	private int angle; 
	
	// constructor
	public Ball( PlayField playField, float start_x, float start_y, float radius, double speed, int angle ) {
		this.playField = playField; 
		this.x_as = start_x ;
		this.y_as = start_y ;
		this.radius = radius;
		this.angle = angle;
		setSpeeds( speed );  // Adust all speeds, total velocity, and x-axis speed, and y-axis speed
	
	}
	
	public void move() {
		
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
				//GAME OVER 
				// ToDo Implement nice ending of the game
				System.out.println("Game over: speed & y_as " + speed + " " + y_as ); 
				//For now, bounce at the bottom
				if ( y_as >= playField.getPlayfieldLength() ) {
					bounceHorizontal( );
				}
			}
		} 
		
		y_as += y_speed; 
		x_as += x_speed;
		
	}
	
	public void draw() {
		playField.fill(200,0,0); // Color! 
    	playField.ellipse(x_as, y_as, radius, radius);
    	// x_as is the horizontal place, then  the vertical place , length & height of rectangle, rounded corners.
	}
	
	private void bounceHorizontal() {
		//System.out.println("bounceHorizontal");
		this.y_speed = this.y_speed * (-1);
	}
	
	private void bounceVertical() {
		//System.out.println("bounceVrtical");
		this.x_speed = this.x_speed * (-1);
	}
	
	private void setSpeeds(double newSpeed ) {
		this.speed = newSpeed;
		this.x_speed = java.lang.Math.sin(java.lang.Math.toRadians(angle)) * speed;
		this.y_speed = java.lang.Math.cos(java.lang.Math.toRadians(angle)) * speed;
	}
}
