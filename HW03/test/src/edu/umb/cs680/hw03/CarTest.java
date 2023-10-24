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
	public void verifySetCarMakeMercedes() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		car.setMake("Mercedes");											//use setMake to alter value

		Assertions.assertEquals(car.getMake(), "Mercedes");					//Check if setMake has updated value
	}

	@Test
	public void verifySetCarModleAMG() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		car.setModel("AMG");												//use setModel to alter value

		Assertions.assertEquals(car.getModel(), "AMG");						//Check if setModel has updated value
	}

	@Test
	public void verifySetCarMileage20() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		car.setMileage(20);													//use setMileage to alter value

		Assertions.assertEquals(car.getMileage(), 20);						//Check if setMileage has updated value
	}

	@Test
	public void verifySetCarYear2020() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		car.setYear(2020);													//use setYear to alter value

		Assertions.assertEquals(car.getYear(), 2020);						//Check if setYear has updated value
	}

	@Test
	public void verifySetCarPrice10000Float() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		car.setPrice(15000.0f);												//use setPrice to alter value

		Assertions.assertEquals(car.getPrice(), 15000.0f);					//Check if setPrice has updated value
	}

	@Test
	public void verifyCarMakeToyota() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object

		Assertions.assertEquals(car.getMake(), "Toyota");					//Check if getMake has returned correct value
	}

	@Test
	public void verifyCarModleRAV4() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object

		Assertions.assertEquals(car.getModel(), "RAV4");					//Check if getModel has returned correct value
	}

	@Test
	public void verifyCarMileage10() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object

		Assertions.assertEquals(car.getMileage(), 10);						//Check if getMileage has returned correct value
	}

	@Test
	public void verifyCarYear2018() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object

		Assertions.assertEquals(car.getYear(), 2018);						//Check if getYear has returned correct value
	}

	@Test
	public void verifyCarPrice10000Float() {
		Car car = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object

		Assertions.assertEquals(car.getPrice(), 10000.0f);					//Check if getPrice has returned correct value
	}

	@Test
	public void verifyCarEqualityOfConstructorInitializationMakeToyotaModelRAV4Year2018WithConstructorInitializationMakeToyotaModelRAV4Year2018() {
		Car car_1 = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		Car car_2 = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize another car object

		String[] actual_1 = carToStringArray(car_1);						//Object to string
		String[] actual_2 = carToStringArray(car_2);						//Object to string

		Assertions.assertArrayEquals(actual_2, actual_1);						//Check the equality with arrar-to-array comparision
	}
	@Test
	public void verifyCarEqualityOfMakeToyotaModelRAV4Year2018WithConstructorInitialization() {
		String[] expected = {"Toyota", "RAV4", "2018"};						//String array
		
		Car car_1 = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object

		String[] actual = carToStringArray(car_1);

		Assertions.assertArrayEquals(expected, actual);						//Check the equality with arrar-to-array comparision
	}

	@Test
	public void verifyCarInequalityOfMakeMercedesModelRAV4Year2018StringArrayWithConstructorMakeToyotaModelRAV4Year2018() {
		String[] expected = {"Mercedes", "RAV4", "2018"};						//String array

		Car car_1 = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object

		String[] actual = carToStringArray(car_1);

		Assertions.assertFalse(Arrays.equals(expected, actual));						//Check the equality with arrar-to-array comparision
	}
	@Test
	public void verifyCarInequalityWithMakeToyotaModelRAV4Year2018AndMakeMercedesModelRAV4Year2018() {
		Car car_1 = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		Car car_2 = new Car("Mercedes", "RAV4",  10, 2018, 10000.0f);		//Initialize another car object

		String[] actual_1 = carToStringArray(car_1);
		String[] actual_2 = carToStringArray(car_2);

		Assertions.assertFalse(Arrays.equals(actual_1, actual_2));			//Check the inequality with arrar-to-array comparision
	}

	@Test
	public void verifyCarInequalityWithMakeToyotaModelRAV4Year2018AndMakeToyotaModelAMGYear2018() {
		Car car_1 = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		Car car_2 = new Car("Toyota", "AMG",  10, 2018, 10000.0f);		//Initialize another car object

		String[] actual_1 = carToStringArray(car_1);
		String[] actual_2 = carToStringArray(car_2);

		Assertions.assertFalse(Arrays.equals(actual_1, actual_2));			//Check the inequality with arrar-to-array comparision
	}

	@Test
	public void verifyCarInequalityWithMakeToyotaModelRAV4Year2018AndMakeToyotaModelRAV4Year2019() {
		Car car_1 = new Car("Toyota", "RAV4",  10, 2018, 10000.0f);			//Initialize car object
		Car car_2 = new Car("Toyota", "RAV4",  10, 2019, 10000.0f);		//Initialize another car object

		String[] actual_1 = carToStringArray(car_1);
		String[] actual_2 = carToStringArray(car_2);

		Assertions.assertFalse(Arrays.equals(actual_1, actual_2));			//Check the inequality with arrar-to-array comparision
	}
}