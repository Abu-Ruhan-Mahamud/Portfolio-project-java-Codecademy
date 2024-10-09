package aliens_vs_humans;

import java.util.Random;

public class Entity extends MapObject{
	
	private int hitpoints;
	private int accuracy;
	private int dodge;
	private boolean isAlive;
	
	public Entity(String newName) {
		super(newName);
		hitpoints = 100;
		accuracy = initialStatSetup(30, 100);
		dodge = initialStatSetup(0, 70);
		isAlive = true;
	}	
	
	public int getHitPoints() {
		return hitpoints;
	}
		
	public void setHitpoints(int newHitpoints) {
		hitpoints = newHitpoints;
	}
	
	/* This method removes a certain amount of hitpoints from the entity's
	 * current hitpoints. If the hitpoints reach 0 or below, the hitpoints
	 * are set to 0 and the entity dies. */
	public boolean removeHitpoints(int removedHitpoints) {
		int newHitpoints = getHitPoints() - removedHitpoints;
		
		if (newHitpoints <= 0) {
			setHitpoints(0);
			setEntityAlive(false);
			return false;
		} else {
			setHitpoints(newHitpoints);
			return true;
		}
	}

	public int getAccuracy() {
		return accuracy;
	}
	
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	public int getDodge() {
		return dodge;
	}
	
	public void setDodge(int dodge) {
		this.dodge = dodge;
	}
	
	/* This method sets the statistic of this entity to a random number between
	 * floor and roof, but ensures it never drops below 0 or above 100. */
	public int initialStatSetup(int floor, int roof) {
		Random rand = new Random();
		
		int currentNumber = rand.nextInt(roof - floor) + floor;
		
		if (currentNumber < 0) {
			currentNumber = 0;
		} else if (currentNumber > 100) {
			currentNumber = 100;
		}
		
		return currentNumber;
	}
	
	public boolean isEntityAlive() {
		return isAlive;
	}
	
	public void setEntityAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nHitpoints: " + getHitPoints() + "\nAccuracy:  "
				+ getAccuracy() + "\nDodge:     " + getDodge();
	}
	
	/* public static void main(String[] args) {
		Entity test = new Entity("testName");
		test.setMapID("Entity");
		
		System.out.println(test.toString());
	} */
}
