package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;

public class MileageComparatorTest
{
    static ArrayList<Car> cars = new ArrayList<>();

    @BeforeAll
    public static void setUpListOfCarsBeforeTest() {

        cars.add(new Car("Toyota", "RAV4",  10, 2018, 10000.0f));			//Add cars to list of Cars
		cars.add(new Car("LandRover", "Discover", 17, 2015, 50001.0f));
        cars.add(new Car("RangeRover", "Autobiography", 15, 2025, 250000.0f));
		cars.add(new Car("Mercedes", "AMG", 12, 2020, 25000.0f));

        Collections.sort(cars, new MileageComparator());					//Sorting List with mileage comparator
    }

    @Test
    public void verifySortWithMileageComparator() {
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        expected.add(17);	//Decreasing order of mileage
        expected.add(15);
        expected.add(12);
        expected.add(10);

        for (Car c : cars)
            actual.add(c.getMileage());		//Append mileage for actual

		Assertions.assertEquals(expected, actual);
    }
}