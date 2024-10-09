package test_aliens_vs_humans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import aliens_vs_humans.Obstacle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestObstacle {
	
	private Obstacle testObst;
	private Obstacle testRandObst;
	
	@BeforeAll
	public void testObstacleSetup() {
		testObst = new Obstacle(Obstacle.type.HOLE);
		testRandObst = new Obstacle();
	}
	
	@Test
	void testObstacleType() {
		// Tests getters and setters for Obstacle type.
		assertEquals(Obstacle.type.HOLE, testObst.getObstacleType()); 
	}
	
	@Test
	void testObstacleMapID() {
		// Tests if the correct MapID is returned by the class.
		testObst.setObstacleType(Obstacle.type.ROCK);
		assertEquals(" @ ", testObst.getMapID());
		assertEquals("Rock", testObst.getEntityName());
		
		testObst.setObstacleType(Obstacle.type.TREE);
		assertEquals(" ♠ ", testObst.getMapID());
		assertEquals("Tree", testObst.getEntityName());
		
		testObst.setObstacleType(Obstacle.type.HOLE);
		assertEquals(" O ", testObst.getMapID());
		assertEquals("Hole", testObst.getEntityName());
	}
	
	@Test
	void testRandomisedType() {
		// Checks to ensure randomizer works, giving all three types of Obstacle available.
		boolean isRock = false;
		boolean isTree = false;
		boolean isHole = false;
		boolean allFound = false;
		
		while(allFound == false) {
			while(isRock == false || isTree == false || isHole == false) {
				testRandObst = new Obstacle();
				
				if (testRandObst.getObstacleType() == Obstacle.type.ROCK) {
					isRock = true;
				} else if (testRandObst.getObstacleType() == Obstacle.type.TREE) {
					isTree = true;
				} else if (testRandObst.getObstacleType() == Obstacle.type.HOLE) {
					isHole = true;
				}
			}
			
			allFound = true;
		}
		
		assertTrue(allFound);
	}
}
