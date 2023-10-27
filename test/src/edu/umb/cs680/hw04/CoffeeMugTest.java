package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class CoffeeMugTest {

	@Test
	public void initiallyCoffeMugInColdState() {
		CoffeeMug coffeeMug = new CoffeeMug();					//Initialize object

		String expected = "The coffee is cold.";				//Expected string
		String actual = coffeeMug.currentTemperature();			//Returns current state of coffee in coffeemug

		Assertions.assertEquals(expected, actual);				//Check if initially coffee is cold
	}

	@Test
	public void providingHeatToInitialStateCoffeMugResultsInWarmState() {
		String expected = "The coffee is warm.";				//Expected string
		CoffeeMug coffeeMug = new CoffeeMug();					//Initialize object

		coffeeMug.heatCoffee();									//Heat function activated in coffee mug
		String actual = coffeeMug.currentTemperature();			//Returns current state of coffee in coffeemug

		Assertions.assertEquals(expected, actual);				//Check if coffee is warm now: cold + heat -> warm
	}

	@Test
	public void providingHeatToInitialStateCoffeMugResultsInWarmStateAndFurtherHeatResultsInHotState() {
		String expected = "The coffee is hot.";					//Expected string
		CoffeeMug coffeeMug = new CoffeeMug();					//Initialize object

		coffeeMug.heatCoffee();									//Heat function activated in coffee mug
		String actual = coffeeMug.currentTemperature();			//Returns current state of coffee in coffeemug: warm state

		coffeeMug.heatCoffee();									//Heat function activated in coffee mug
		actual = coffeeMug.currentTemperature();				//Returns current state of coffee in coffeemug
		Assertions.assertEquals(expected, actual);				//Check if coffee is hot now: cold + heat -> warm + heat -> hot
	}

	@Test
	public void providingHeatToWarmStateCoffeMugResultsInHotState() {
		String expected = "The coffee is hot.";					//Expected string
		CoffeeMug coffeeMug = new CoffeeMug();					//Initialize object

		coffeeMug.heatCoffee();									//Heat function activated in coffee mug
		String actual = coffeeMug.currentTemperature();			//Returns current state of coffee in coffeemug
		Assertions.assertFalse(expected == actual);				//Expected is hot and current temperature is warm

		coffeeMug.heatCoffee();									//Heat function activated in coffee mug
		actual = coffeeMug.currentTemperature();				//Returns current state of coffee in coffeemug
		Assertions.assertEquals(expected, actual);				//Check if coffee is hot now: warm + heat -> hot
	}

	@Test
	public void providingHeatToHotStateCoffeMugResultsInNoChangedState() {
		String expected = "The coffee is hot.";					//Expected string
		CoffeeMug coffeeMug = new CoffeeMug();					//Initialize object

		coffeeMug.heatCoffee();									//Heat function activated in coffee mug
		String actual = coffeeMug.currentTemperature();			//Returns current state of coffee in coffeemug
		Assertions.assertFalse(expected == actual);				//Expected is hot and current temperature is warm

		coffeeMug.heatCoffee();									//Heat function activated in coffee mug
		actual = coffeeMug.currentTemperature();				//Returns current state of coffee in coffeemug
		Assertions.assertEquals(expected, actual);				//Check if coffee is hot now: warm + heat -> hot

		coffeeMug.heatCoffee();									//Heat function activated in coffee mug
		actual = coffeeMug.currentTemperature();				//Returns current state of coffee in coffeemug
		Assertions.assertEquals(expected, actual);				//Check if coffee is hot now: hot + heat -> hot
	}
}