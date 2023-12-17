package edu.umb.cs680.hw16;

public class SmartKitchenApp {
    public static void main(String[] args) {
        KitchenControllerImpl controller = new KitchenControllerImpl();

        // Lambda expression for SmartFridge behavior
        Observer<TemperatureEvent> fridgeObserver = (sender, event) -> {
            if (event.getTemperature() > 5) {
                System.out.println("Smart Fridge: It's too hot in the kitchen. Cooling down...");
            }
        };

        // Lambda expression for SmartOven behavior
        Observer<TemperatureEvent> ovenObserver = (sender, event) -> {
            if (event.getTemperature() < 180) {
                System.out.println("Smart Oven: It's too cold in the kitchen. Preheating...");
            }
        };

        controller.registerDevice(fridgeObserver);
        controller.registerDevice(ovenObserver);

        controller.changeTemperature(25);
        controller.changeTemperature(150);
    }
}
