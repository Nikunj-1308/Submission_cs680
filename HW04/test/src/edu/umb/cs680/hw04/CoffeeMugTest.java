package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class CoffeeMugTest {

	@Test
	public void testInitialColdState() {
		CoffeeMug coffeeMug = new CoffeeMug();
		Assertions.assertEquals("The coffee is cold.", coffeeMug.handleTemperature());
	}

	@Test
	public void testWarmState() {
		CoffeeMug coffeeMug = new CoffeeMug();
		coffeeMug.setState(new WarmState());
		Assertions.assertEquals("The coffee is warm.", coffeeMug.handleTemperature());
	}

	@Test
	public void testHotState() {
		CoffeeMug coffeeMug = new CoffeeMug();
		coffeeMug.setState(new HotState());
		Assertions.assertEquals("The coffee is hot.", coffeeMug.handleTemperature());
	}

	@Test
	public void testTransitionBackToCold() {
		CoffeeMug coffeeMug = new CoffeeMug();
		coffeeMug.setState(new WarmState());
		coffeeMug.handleTemperature(); // The coffee is warm.
		coffeeMug.setState(new ColdState());
		Assertions.assertEquals("The coffee is cold.", coffeeMug.handleTemperature());
	}
}