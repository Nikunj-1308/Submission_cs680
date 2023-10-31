package edu.umb.cs680.hw05;

public class SmartOven implements Observer<TemperatureEvent> {
    private int lastTemperature;

    public int getOvenLastTemperature() {
        return lastTemperature;
    }

    public void update(Observable<TemperatureEvent> sender, TemperatureEvent event) {
        if (event.getTemperature() < 180) {
            System.out.println("Smart Oven: It's too cold in the kitchen. Preheating...");
        }
        lastTemperature = event.getTemperature();
    }
}
