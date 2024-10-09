package aliens_vs_humans;

import java.util.Random;

public class Obstacle extends MapObject {
	
	// The types of obstacles allowed to be created.
	public enum type {
		  ROCK, 
		  TREE, 
		  HOLE
	}

	// Instance variables.
	private type obstacleType;
	
	/* This constructor initially set the Obstacles name to null,
	 * and then randomizes what the obstacle will be.*/
	public Obstacle() {
		super(null);
		randomiseObstacleType();
	}
	
	/* This constructor also sets the Obstacles name to null, 
	 * and then allows the obstacles type to be chosen by the program. */
	public Obstacle(type type) {
		super(null);
		setObstacleType(type);
	}

	public type getObstacleType() {
		return obstacleType;
	}
	
	/* This method completely randomises what type this obstacle will
	 * be initiated with. It is called from the empty argument-less
	 * constructor.  */
	private void randomiseObstacleType() {
		Random rand = new Random();
		
		int randType = rand.nextInt(3);
		
		switch(randType) {
		case 0:
			setObstacleType(type.ROCK);
			break;
		case 1:
			setObstacleType(type.TREE);
			break;
		case 2:
			setObstacleType(type.HOLE);
			break;
		}
	}
	
	/* This method sets the obstacles type, mapID and name all in one
	 * go depending on which Obstacle type is passed to it.*/
	public void setObstacleType(type obstacleType) {
		this.obstacleType = obstacleType;
		
		switch(obstacleType) {
		case ROCK:
			this.setMapID(" @ ");
			setEntityName("Rock");
			break;
		case TREE:
			this.setMapID(" ♠ ");
			setEntityName("Tree");
			break;
		case HOLE:
			this.setMapID(" O ");
			setEntityName("Hole");
			break;
		}
	}
}
