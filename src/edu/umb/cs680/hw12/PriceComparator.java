package edu.umb.cs680.hw12;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car>{
    public int compare(Car car_1, Car car_2){    //Adding function body for compare
        return (int) (car_2.getPrice() - car_1.getPrice());
    }
}