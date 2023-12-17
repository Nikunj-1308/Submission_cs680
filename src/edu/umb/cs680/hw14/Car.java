package edu.umb.cs680.hw14;

import java.util.ArrayList;

public class Car
{
    private ArrayList<Car> cars;
    private String make,model;
    private int mileage,year;
    private float price;
    private int dominationCount;

    public Car(String make, String model, int mileage, int year, float price){
        super();
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

	//Getters
    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getMileage(){
        return mileage;
    }

    public int getYear(){
        return year;
    }

    public float getPrice(){
        return price;
    }

    public ArrayList<Car> getCarsList() {
        return cars;
    }

    public int getDominationCount() {
        return dominationCount;
    }

	//Setters
    public void setCars(ArrayList<Car> carsList) {
        this.cars = carsList;
    }

    public void setDominationCount(int dominationCount) {
        this.dominationCount = dominationCount;
    }

    public int calcDominationCount() {
        int domCount = 0;
        
        for (Car c : cars)
            if (this.price >= c.getPrice() && this.year >= c.getYear() && this.mileage >= c.getMileage())
            {
                domCount++;
            }
        
        setDominationCount(domCount);
        return domCount;
    }

    public static void main(String[] args){
        Car car = new Car("HondaCity", "VI",47, 2020,15000);

        System.out.println("Car make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Mileage: "  + car.getMileage());
        System.out.println("Year: " + car.getYear());
        System.out.println("Price: " + car.getPrice());
    }
}