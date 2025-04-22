package assignment9;

import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = 0.015;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		this.segments = new LinkedList<>();
		deltaX = 0;
		deltaY = 0;
		BodySegment seg = new BodySegment(0.5,0.5,SEGMENT_SIZE); //start in middle
		segments.add(seg);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		 if (segments.isEmpty()) return;

		    for (int i = segments.size() - 1; i > 0; i--) {
		        BodySegment prev = segments.get(i - 1);
		        segments.get(i).setX(prev.getX());
		        segments.get(i).setY(prev.getY());
		    }

		    BodySegment head = segments.get(0);
		    head.setX(head.getX() + deltaX);
		    head.setY(head.getY() + deltaY);
		
		
		
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for(BodySegment segment : segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		double distance = Math.sqrt(Math.pow(segments.getFirst().getX()-f.getX(),2)+Math.pow(segments.getFirst().getY()-f.getY(),2));
		if(distance<= segments.getFirst().getRadius()+f.getFoodRadius()) {
			addSegment();
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		if(segments.getFirst().getX()<0 || segments.getFirst().getX()>1 || segments.getFirst().getY()>1 || segments.getFirst().getY()<0 ) {
		
			return false;
		}
		return true;
	}
	
	
	public void addSegment() {
	    
	    BodySegment tail = segments.getLast();
	    
	    BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE);
	    
	    segments.add(newSegment);
	}
}
