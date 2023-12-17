package edu.umb.cs680.hw06;

import java.util.*;

public class LocationSensor {
    private List<LocationObserver> observers = new ArrayList<>();
    
    private double latitude;
    private double longitude;

    public List<LocationObserver> getObservers() {
        return observers;   //Returns list of observers
    }

    public void addObserver(LocationObserver observer) {
        observers.add(observer);    //Adds a observer to the List
    }

    public void removeObserver(LocationObserver observer) {
        observers.remove(observer); //Removes a observer from the List
    }

    public void updateLocation(double latitude, double longitude) {
        this.latitude = latitude;       //Update data member latitude
        this.longitude = longitude;     //Update data member longitude
        notifyLocationObservers(new Location(latitude, longitude));     //Notify Observers with new instance
    }

    private void notifyLocationObservers(Location location) {
        for (LocationObserver observer : observers) {
            observer.updateLocation(location);      //Calls member function for each observer in List
        }
    }
}
