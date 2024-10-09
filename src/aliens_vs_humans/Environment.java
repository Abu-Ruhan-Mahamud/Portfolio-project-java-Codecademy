package aliens_vs_humans;

import java.util.Random;

public class Environment {
	
	private MapObject[][] environment;
	
	public Environment() {
		this.environment = new MapObject[8][8];
	}
	
	public MapObject[][] getEnvironment() {
		return environment;
	}

	public void createBattlefield(int numberOfEntities, int numberOfObstacles) {
		setupEntities(numberOfEntities);
		setupObstacles(numberOfObstacles);
	}
	
	public void setupEntities(int numberOfEntities) {
		for (int a = 1; a <= numberOfEntities; a++) {
			Human human = new Human("Human " + a, "America", a);
			Alien alien = new Alien("Alien " + a, "Mars" , a);
			
			addMapObjectRandomly(human);
			addMapObjectRandomly(alien);
		}
	}
	
	public void setupObstacles(int numberOfObstacles) {
		for (int a = 0; a < numberOfObstacles; a++) {
			Obstacle obstacle = new Obstacle();
			
			addMapObjectRandomly(obstacle);
		}		
	}
	
	public void addMapObjectRandomly(MapObject currentObject) {
		Random rand = new Random();
		boolean objectPlaced = false;
		int xLimit = 0, yLimit = 0, offset = 0;
		
		if (currentObject instanceof Obstacle) {
			xLimit = 8;
			yLimit = 8;			
		} else if (currentObject instanceof Human) {
			xLimit = 4;
			yLimit = 8;
		} else if (currentObject instanceof Alien) {
			xLimit = 4;
			yLimit = 8;
			offset = 4;
		}
		
		while (objectPlaced == false) {
			int x = rand.nextInt(xLimit) + offset;
			int y = rand.nextInt(yLimit);
			
			if (environment[x][y] == null) {
				environment[x][y] = currentObject;
				objectPlaced = true;
			}
		}		
	}
	
	public static void main(String[] args) {
		Environment map = new Environment();
		map.createBattlefield(5, 15);
		
		for (int a = 0; a < map.environment.length; a++) {
			for (int b = 0; b < map.environment[1].length; b++) {
				System.out.print("|");
				
				if (map.environment[b][a] != null) {
					System.out.print(map.environment[b][a].getMapID());
				} else {
					System.out.print("   ");
				}
				
				
			}
			System.out.println("|");
		}
	}	
}