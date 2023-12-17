package edu.umb.cs680.hw06;

import java.util.*;

public class StepCounter {
    private List<StepCountObserver> observers = new ArrayList<>();

    private int stepCount;

    public List<StepCountObserver> getObservers() { 
        return observers;   //Returns list of observers
    }

    public void addObserver(StepCountObserver observer) {
        observers.add(observer);    //Adds a observer to the List
    }

    public void removeObserver(StepCountObserver observer) {
        observers.remove(observer); //Removes a observer from the List
    }

    public void updateStepCount(int count) {
        this.stepCount = count; //Update data member stepCount
        notifyStepCountObservers(new StepCount(stepCount)); //Notify Observers with new instance
    }

    private void notifyStepCountObservers(StepCount stepCount) {
        for (StepCountObserver observer : observers) {
            observer.updateStepCount(stepCount);     //Calls member function for each observer in List
        }
    }
}
