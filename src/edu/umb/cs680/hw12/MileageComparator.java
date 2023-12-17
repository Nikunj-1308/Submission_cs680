package edu.umb.cs680.hw12;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{
    public int compare(Car car_1, Car car_2){    //Adding function body for compare
        return car_2.getMileage() - car_1.getMileage();
    }
}