package test_aliens_vs_humans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import aliens_vs_humans.MapObject;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestMapObject {
	
	private MapObject testObj;

	@BeforeAll
	void testMapObjectSetup() {
		testObj = new MapObject("test");
	}

	@Test
	void testMapObjectName() {
		// Tests getters and setters for MapObjects name.
		testObj.setEntityName("newName");
		assertEquals("newName", testObj.getEntityName());
	}
	
	@Test
	void testToString() {
		testObj.setMapID("TEST");
		assertEquals("ID:        TEST\nName:      test", testObj.toString());
	}
}
