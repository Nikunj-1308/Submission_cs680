package edu.umb.cs680.hw05;

public class SmartFridge implements Observer<TemperatureEvent> {

    private int lastTemperature;

    public void update(Observable<TemperatureEvent> sender, TemperatureEvent event) {
        if (event.getTemperature() > 5) {
            System.out.println("Smart Fridge: It's too hot in the kitchen. Cooling down...");
        }
        lastTemperature = event.getTemperature();
    }

    public int getFridgeLastTemperature() {
        return lastTemperature;
    }
}