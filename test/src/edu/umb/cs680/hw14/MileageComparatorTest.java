package edu.umb.cs680.hw14;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

public class MileageComparatorTest {

    static ArrayList<Car> cars = new ArrayList<>();

    @BeforeAll
    public static void setUpListOfCarsBeforeTest() {

        cars.add(new Car("Toyota", "RAV4",  10, 2018, 10000.0f));			//Add cars to list of Cars
		cars.add(new Car("LandRover", "Discover", 17, 2015, 50001.0f));
        cars.add(new Car("RangeRover", "Autobiography", 15, 2025, 250000.0f));
		cars.add(new Car("Mercedes", "AMG", 12, 2020, 25000.0f));

		Collections.sort(cars,(Car car_1, Car car_2) -> car_2.getMileage()-car_1.getMileage());	//Passing the LE to collection.sort()

    }
    @Test
    public void verify_MileageComparatorForUsedCarsAs17151210()
    {
        Assertions.assertEquals(17, cars.get(0).getMileage());
        Assertions.assertEquals(15, cars.get(1).getMileage());
        Assertions.assertEquals(12, cars.get(2).getMileage());
        Assertions.assertEquals(10, cars.get(3).getMileage());
    }

}