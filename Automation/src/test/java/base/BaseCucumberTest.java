package base;
import static driver.DriverFactory.KillDriver;

import java.util.Random;

import cucumber.api.java.After;

public class BaseCucumberTest {
	
	public Random rnd;
	
	public BaseCucumberTest() {
		rnd = new Random();
	}

	@After
	public static void tearDown() {
		KillDriver();
    }
}
