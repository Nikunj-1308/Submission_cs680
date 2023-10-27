package edu.umb.cs680.hw03;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
    public void setMake(String make) {
        if (make != null) {
            this.make = make;
        } else {
            throw new RuntimeException("Wrong input values: make=" + make);
        }
    }

    public void setModel(String model) {
        if (model != null) {
            this.model = model;
        } else {
            throw new RuntimeException("Wrong input values: model=" + model);
        }
    }

    public void setMileage(int mileage) {
        if (mileage != 0) {
            this.mileage = mileage;
        } else {
            throw new RuntimeException("Wrong input values: mileage=" + mileage);
        }
    }

    public void setYear(int year) {
        if (year != 0) {
            this.year = year;
        } else {
            throw new RuntimeException("Wrong input values: year=" + year);
        }
    }

    public void setPrice(float price) {
        if (price != 0.0f) {
            this.price = price;
        } else {
            throw new RuntimeException("Wrong input values: price=" + price);
        }
    }

    public Car(String make, String model, int mileage, int year, float price) {
        setMake(make);
        setModel(model);
        setYear(year);
        setMileage(mileage);
        setPrice(price);
    }
    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }
    public static void main(String[] args) {
        Car car = new Car("Mercedes", "AMG", 10, 2023, 100000.0f);

        System.out.println("Car details:\n" +
                            "Make: " + car.getMake() +
                            "\nModel: " + car.getModel() +
                            "\nMileage: " + car.getMileage() +
                            "\nYear: " + car.getYear() +
                            "\nPrice: $" + car.getPrice());
    }
}