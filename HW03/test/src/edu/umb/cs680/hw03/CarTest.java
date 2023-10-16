package edu.umb.cs680.hw03;

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
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Toyota", "RAV4", "2018"};
		
		Car car_1 = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);

		String[] actual = carToStringArray(car_1);

		Assertions.assertArrayEquals(expected, actual);		//Check the equality with arrar-to-array comparision
	}

	@Test
	public void verifyCarInequalityWithMakeModelYear() {
		String[] expected_false = {"Toyota", "RAV4", "2018"};

		Car car_2 = new Car("Mercedes", "AMG",  15, 2023, 15000.0f);

		String[] actual = carToStringArray(car_2);

		Assertions.assertFalse(Arrays.equals(expected_false, actual));	//Check the inequality with arrar-to-array comparision
	}
}