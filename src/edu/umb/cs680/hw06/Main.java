package edu.umb.cs680.hw06;

public class Main {
    public static void main(String[] args) {
        TrackerApp googleFit = new TrackerApp();        //Create an Observer
        TrackerApp appleWatch = new TrackerApp();       //Create another Observer
        
        // Create instances of observable classes
        StepCounter stepCounter = new StepCounter();    //Create an Observerable (a feature for a watch)
        LocationSensor locationSensor = new LocationSensor();   //Create another Observerable (another feature for a watch)

        stepCounter.addObserver(googleFit); // Register googleFit as an observer for both StepCounter
        locationSensor.addObserver(googleFit);  // Register googleFit as an observer for both  LocationSensor

        stepCounter.addObserver(appleWatch);    // Register appleWatch as an observer for both StepCounter
        locationSensor.addObserver(appleWatch); // Register appleWatch as an observer for both  LocationSensor

       
        stepCounter.updateStepCount(120);   //Update with an event
        locationSensor.updateLocation(10.10, 120.123); //Update with an event
    }
}