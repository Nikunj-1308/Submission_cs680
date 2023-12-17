package edu.umb.cs680.hw16;
import java.util.ArrayList;
import java.util.List;

public class KitchenControllerImpl extends Observable<TemperatureEvent> {
    private List<TemperatureEvent> devices = new ArrayList<>();
    
    void registerDevice(Observer<TemperatureEvent> observer) {
        addObserver(observer);
    }
    public void changeTemperature(int temperature) {
        notifyObservers(new TemperatureEvent(temperature));
    }
}