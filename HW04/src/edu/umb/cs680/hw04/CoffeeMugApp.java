package edu.umb.cs680.hw04;

public class CoffeeMugApp {
    public static void main(String[] args) {
        CoffeeMug coffeeMug = new CoffeeMug();

        System.out.println(coffeeMug.handleTemperature());
        coffeeMug.setState(new WarmState());

        System.out.println(coffeeMug.handleTemperature());
        coffeeMug.setState(new HotState());

        System.out.println(coffeeMug.handleTemperature());
    }
}