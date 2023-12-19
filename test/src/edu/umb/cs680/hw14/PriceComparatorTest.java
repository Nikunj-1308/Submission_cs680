package edu.umb.cs680.hw14;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

public class PriceComparatorTest
{
    static ArrayList<Car> cars = new ArrayList<>();

    @BeforeAll
    public static void setUpListOfCarsBeforeTest() {

        cars.add(new Car("Toyota", "RAV4",  10, 2018, 10000.0f));			//Add cars to list of Cars
		cars.add(new Car("LandRover", "Discover", 17, 2015, 50001.0f));
        cars.add(new Car("RangeRover", "Autobiography", 15, 2025, 250000.0f));
		cars.add(new Car("Mercedes", "AMG", 12, 2020, 25000.0f));

		Collections.sort(cars, (Car car_1, Car car_2) -> (int) (car_2.getPrice() - car_1.getPrice()));	//Passing the LE to collection.sort()

    }
    @Test
    public void verifyPriceComparatorForUsedCarsAs250000Then50001Then25000Then10000()
    {
        Assertions.assertEquals(250000.0f,cars.get(0).getPrice());
        Assertions.assertEquals(50001.0f, cars.get(1).getPrice());
        Assertions.assertEquals(25000.0f, cars.get(2).getPrice());
        Assertions.assertEquals(10000.0f, cars.get(3).getPrice());
    }
}