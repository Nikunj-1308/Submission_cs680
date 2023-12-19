package edu.umb.cs680.hw11;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CarAsListTest {

    private Car generateRandomCar() {       // Generate a random car with random values using rand.nextInt
        Random rand = new Random();
        String make = "Brand" + rand.nextInt(1500);
        String model = "Model" + rand.nextInt(1500);
        int mileage = rand.nextInt(150000);
        int year = rand.nextInt(30) + 1990;
        float price = rand.nextFloat() * 200000;
        return new Car(make, model, mileage, year, price);
    }

    private List<Car> generateRandomCarList(int numCars) {  //Generate Random Cars
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numCars; i++) {
            cars.add(generateRandomCar());
        }
        return cars;
    }

    @Test
    public void verifyDistanceMatrixWithLargeDataSet() {
        int numOfCars = 998;
        List<Car> cars = generateRandomCarList(numOfCars);
        cars.add(new Car("Mercedes", "AMG", 10, 2010, 12000));
        cars.add(new Car("Honda", "CRV", 15, 2011, 15000));

        List<List<Double>> normalizedPointsList = new ArrayList<>();    //Convert each car's Mileage, Year, and Price to [0,1] using min-max normalization
        for (Car car : cars) {
            double normMileage = (car.getMileage() - 0.0) / (50000.0 - 0.0);
            double normYear = (car.getYear() - 1990.0) / (2023.0 - 1990.0);
            double normPrice = (car.getPrice() - 0.0) / (200000.0 - 0.0);

            List<Double> normPoint = List.of(normMileage, normYear, normPrice);
            normalizedPointsList.add(normPoint);
        }

        List<List<Double>> euclideanDistanceMatrix = Distance.matrix(normalizedPointsList, new Euclidean());

        List<List<Double>> manhattanDistanceMatrix = Distance.matrix(normalizedPointsList, new Manhattan());

        List<List<Double>> cosineDistanceMatrix = Distance.matrix(normalizedPointsList, new Cosine());

        Assertions.assertTrue(euclideanDistanceMatrix.size() == numOfCars + 2); //+2 for the additional 2 data inserted
        Assertions.assertTrue(manhattanDistanceMatrix.size() == numOfCars + 2);
        Assertions.assertTrue(cosineDistanceMatrix.size() == numOfCars + 2);
    }
}