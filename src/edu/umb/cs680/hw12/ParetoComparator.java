package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {
    public int compare(Car car_1, Car car_2){   //Adding function body for compare
        return car_2.calcDominationCount() - car_1.calcDominationCount();
    }
}