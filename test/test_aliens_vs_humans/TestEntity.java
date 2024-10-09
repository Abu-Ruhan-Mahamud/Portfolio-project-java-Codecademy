package test_aliens_vs_humans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import aliens_vs_humans.Entity;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestEntity {
	
	private Entity testEntity;
	
	@BeforeAll
	public void testEntitySetup() {
		// Creates a generic test entity before each test.
		this.testEntity = new Entity("test");
	}

	@Test
	public void testEntityName() {
		// Tests getters and setters for entities name.
		this.testEntity.setEntityName("newName");
		assertEquals("newName", this.testEntity.getEntityName());
	}

	@Test
	public void testHitpoints() {
		// Checks to ensure that hitpoints get set to 50.
		this.testEntity.setHitpoints(50);
		assertEquals(50 , this.testEntity.getHitPoints());
		
		// Checks to ensure hitpoints are successfully removed.
		this.testEntity.removeHitpoints(40);
		assertEquals(10 , this.testEntity.getHitPoints());
		
		// Checks to see that hit points never go below 0.
		this.testEntity.removeHitpoints(100);
		assertEquals(0 , this.testEntity.getHitPoints());
	}
	
	@Test
	public void testAccuracy() {
		int currentAcc = 0;
		
		// Checks to ensure accuracy falls between 30 and 100 as intended
		for (int a = 0; a < 500; a++) {
			this.testEntity.setAccuracy(this.testEntity.initialStatSetup(30, 100));
			currentAcc = this.testEntity.getAccuracy();
			
			assertTrue((currentAcc >= 30) && (currentAcc <= 100));
		}		
	}
	
	@Test
	public void testDodge() {
		int currentDodge = 0;
		
		// Checks to ensure dodge falls between 0 and 69 as intended
		for (int a = 0; a < 500; a++) {
			this.testEntity.setDodge(this.testEntity.initialStatSetup(0, 70));
			currentDodge = this.testEntity.getDodge();
			
			assertTrue((currentDodge >= 0) && (currentDodge <= 70));
		}		
	}
	
	@Test
	public void testInitialStatSetup() {
		int currentStat = 0;
		
		for (int a = 0; a < 500; a++) {
			currentStat = this.testEntity.initialStatSetup(-100, 200);
			
			assertTrue((currentStat >= 0) && (currentStat <= 100));
		}
	}
	
	@Test
	public void testIsAlive() {
		// Checks to ensure entity dies if it loses all hitpoints.
		this.testEntity.removeHitpoints(200);
		assertEquals(false, this.testEntity.isEntityAlive());
		
		// Tests getters and setters for entities living status.
		this.testEntity.setEntityAlive(true);
		assertEquals(true, this.testEntity.isEntityAlive());
	}
	
	@Test
	void testToString() {
		testEntity.setMapID("TEST");
		testEntity.setHitpoints(100);
		testEntity.setAccuracy(50);
		testEntity.setDodge(50);
		assertEquals("ID:        TEST\nName:      test\nHitpoints: 100\nAccuracy:  50\nDodge:     50"
				, testEntity.toString());
	}
}
