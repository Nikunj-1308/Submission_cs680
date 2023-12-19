package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class CarTest {
	private String[] carToStringArray(Car car) {
		String [] carInfoString = {
				car.getMake(),
				car.getModel(),
				Integer.toString(car.getYear())};
		return carInfoString;
	}

	@Test
    void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"Toyota","RAV4","2018"};	//Expected list of String 
        Car actual = new Car("Toyota","RAV4",23,2018,30000);	//Actual car instance
        Assertions.assertArrayEquals(expected,carToStringArray(actual));	//Compare String arrays with the help of carToStringArray
    }
    
    @Test
    void verifyCar() {
        Car expected = new Car("Toyota","RAV4",23,2018,30000);
        Car actual = new Car("Toyota","RAV4",23,2018,30000);
        Assertions.assertArrayEquals(carToStringArray(expected),carToStringArray(actual));	//Compare String arrays with the help of carToStringArray
    }
}