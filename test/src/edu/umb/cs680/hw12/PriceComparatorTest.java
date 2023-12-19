package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.Collections;


public class PriceComparatorTest
{

    static ArrayList<Car> cars = new ArrayList<>();

    @BeforeAll
    public static void setUpListOfCarsBeforeTest() {

        cars.add(new Car("Toyota", "RAV4",  10, 2018, 10000.0f));			//Add cars to list of Cars
		cars.add(new Car("LandRover", "Discover", 17, 2015, 50001.0f));
        cars.add(new Car("RangeRover", "Autobiography", 15, 2025, 250000.0f));
		cars.add(new Car("Mercedes", "AMG", 12, 2020, 25000.0f));
        // Applying Price Comparator
        Collections.sort(cars, new PriceComparator());
    }

    @Test
    public void verifyPriceSort() {
        ArrayList<Float> actual = new ArrayList<>();
        ArrayList<Float> expected = new ArrayList<>();

        expected.add(250000.0f);    //Expected order in decreasing order of price
        expected.add(50001.0f);
        expected.add(25000.0f);
        expected.add(10000.0f);

        for (Car c : cars)
            actual.add(c.getPrice());

        Assertions.assertEquals(expected, actual);
    }
}