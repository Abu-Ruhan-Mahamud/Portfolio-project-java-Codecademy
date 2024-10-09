package test_aliens_vs_humans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import aliens_vs_humans.Human;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestHuman {
	
	private Human testHuman;
	
	@BeforeAll
	public void testHumanSetup() {
		testHuman = new Human("test", "testCountry", 1);
	}

	@Test
	public void testHomeCountry() {
		this.testHuman.setHomeCountry("testCountry2");
		assertEquals("testCountry2", this.testHuman.getHomeCountry());
	}
	
	@Test
	void testToString() {
		testHuman.setAccuracy(50);
		testHuman.setDodge(50);
		assertEquals("ID:        H-1\nName:      test\nHitpoints: 100\nAccuracy:  50\nDodge:     50" 
				+ "\nCountry:   testCountry", testHuman.toString());
	}
}
