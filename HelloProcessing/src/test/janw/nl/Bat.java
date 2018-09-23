package test.janw.nl;

/**
 * This class was written as a part of creating a squash program for the
 * Open.HPI.de course "Java Capstone series 1."
 *
 * This class is responsible for the bat; it has attributes for x- and
 * y-position and the speed It has a fixed length and height; it would be nice
 * to get those as parameters in the constructore in a next iteration. It also
 * remembers on which canvas (playing field) it is painted.
 *
 */
public class Bat {

	private float x_as;
	private float y_as;
	private float speed = 3;
	private float batLength = 70;
	private float batHeight = 14;
	private PlayField playField;

	/**
	 * Constructor The constructor takes the canvas as input, so it knows where it
	 * lives and can ask the size of its canvas (borders)
	 */
	public Bat(PlayField playField) {
		this.playField = playField; // tell the bat where he must draw himself
		this.y_as = this.playField.getPlayfieldLength() - 40; 	// leave some space under the bat; would be nice to make
																// this an attribute or parameter
		this.x_as = (this.playField.getPlayfieldLength() - this.batLength) / 2; // put the bat in the middle of the
																				// playfield
	}

	/**
	 * Move the bat to the left; taking into account the speed of the bat; ánd the
	 * wall
	 */

	public void moveLeft() {
		if (x_as - speed < 0) {
			x_as = 0;
		} else {
			x_as -= speed;
		}
	}

	/**
	 * Move the bat to the right; taking into account the speed of the bat; ánd the
	 * wall
	 */
	public void moveRight() {
		if (x_as + speed > (playField.getPlayfieldLength() - batLength)) {
			x_as = playField.getPlayfieldLength() - (batLength + 1);
		} else {
			x_as += speed;
		}
		;
	}

	/**
	 * Draw the bat as a rectangle on the canvas
	 */
	public void draw() {
		playField.fill(20, 50, 240); // give some color
		playField.rect(x_as, y_as, batLength, batHeight, 4);
		// x_as is the horizontal place, then the vertical place , length & height of
		// rectangle, rounded corners.
	}

	/**
	 * Generated Getters & setters for the attributes
	 */
	public float getX_as() {
		return x_as;
	}

	/**
	 * Generated Getters & setters for the attributes
	 */
	public void setX_as(float x_as) {
		this.x_as = x_as;
	}

	/**
	 * Generated Getters & setters for the attributes
	 */
	public float getY_as() {
		return y_as;
	}

	/**
	 * Generated Getters & setters for the attributes
	 */
	public float getBatLength() {
		return batLength;
	}

	/**
	 * Generated Getters & setters for the attributes
	 */
	public void setBatlength(float batLength) {
		this.batLength = batLength;
	}

	/**
	 * Generated Getters & setters for the attributes
	 */
	public float getBatHeight() {
		return batHeight;
	}

}
