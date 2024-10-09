package test_aliens_vs_humans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import aliens_vs_humans.Environment;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestEnvironment {
	
	private Environment testEnv;

	@BeforeAll
	public void testEnvironmentSetup() {
		testEnv = new Environment();
	}
	
	
	@Test
	/* I'm not too sure entirely how to test the complexity of what's going on in this 
	 * entire class. There's a lot of randomness which can't be tested with assert arguments. 
	 * So in the end, i just ensured that the battlefield itself was initiated. */
	void testCreateBattlefield() {
		testEnv.createBattlefield(5, 15);
		assertNotNull(testEnv.getEnvironment());
	}

}
