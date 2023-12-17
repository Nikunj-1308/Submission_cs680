package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import  org.junit.jupiter.api.Assertions;

public class YearComparatorTest
{
    static ArrayList<Car> cars = new ArrayList<>();

    @BeforeAll
    public static void setUpListOfCarsBeforeTest() {

        cars.add(new Car("Toyota", "RAV4",  10, 2018, 10000.0f));			//Add cars to list of Cars
		cars.add(new Car("LandRover", "Discover", 17, 2015, 50001.0f));
        cars.add(new Car("RangeRover", "Autobiography", 15, 2025, 250000.0f));
		cars.add(new Car("Mercedes", "AMG", 12, 2020, 25000.0f));
        // Applying Year Comparator Logic
        Collections.sort(cars, new YearComparator());
    }

    @Test
    public void yearSort() {
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        expected.add(2025); //Expected array in decreasing order of year
        expected.add(2020);
        expected.add(2018);
        expected.add(2015);

        for (Car c : cars)
            actual.add(c.getYear());

        Assertions.assertEquals(actual, expected); 
    }

}