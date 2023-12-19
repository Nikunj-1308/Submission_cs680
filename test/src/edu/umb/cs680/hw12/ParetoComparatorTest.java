package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Collections;

public class ParetoComparatorTest {

    static ArrayList<Car> cars = new ArrayList<>();

    @BeforeAll
    public static void setUpListOfCarsBeforeTest() {
        cars.add(new Car("Toyota", "RAV4",  10, 2018, 10000.0f));			//Add cars to list of Cars
		cars.add(new Car("LandRover", "Discover", 17, 2015, 50001.0f));
        cars.add(new Car("RangeRover", "Autobiography", 15, 2025, 250000.0f));
		cars.add(new Car("Mercedes", "AMG", 12, 2020, 25000.0f));
    }

    @Test
    public void verifyParetoSort() {
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();
        
        expected.add(3);                //Append Domination Score to expected
        expected.add(2);
        expected.add(1);
        expected.add(1);

        for (int i = 0; i < 4; i++) {
            cars.get(i).setCars(cars);      //Set car
        }
		
        Collections.sort(cars, new ParetoComparator());     //Sort using ParetoComparator

        for (int i = 0; i < 4; i++)
        {
            actual.add(cars.get(i).calcDominationCount());
        }
        Assertions.assertEquals(expected, actual);      //Compare expected vs actual
    }

}