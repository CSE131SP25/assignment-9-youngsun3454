package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		x=(double) Math.random();
		y=(double) Math.random();
				
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.filledCircle(x, y, FOOD_SIZE/2);
		
	}
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	public double getFoodRadius() {
		return FOOD_SIZE/2;
	}
}
