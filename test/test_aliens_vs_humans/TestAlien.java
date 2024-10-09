package test_aliens_vs_humans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import aliens_vs_humans.Alien;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestAlien {
	
	private Alien testAlien;
	
	@BeforeAll
	public void testAlienSetup() {
		this.testAlien = new Alien("test", "testPlanet", 1);
	}

	@Test
	public void testHomePlanet() {
		this.testAlien.setHomePlanet("testPlanet2");
		assertEquals("testPlanet2", this.testAlien.getHomePlanet());
	}
	
	@Test
	void testToString() {
		testAlien.setAccuracy(50);
		testAlien.setDodge(50);
		assertEquals("ID:        A-1\nName:      test\nHitpoints: 100\nAccuracy:  50\nDodge:     50" 
				+ "\nPlanet:    testPlanet", testAlien.toString());
	}
}
