package edu.umb.cs680.hw06;

public class TrackerApp implements StepCountObserver, LocationObserver {

    private Location updatedLocation;
    private StepCount updatedStepCount;

    @Override
    public void updateStepCount (StepCount stepCount){      //providing body to function of interface
        this.updatedStepCount = stepCount;
        System.out.println("Step count updated: " + stepCount.getCount());
    }

    @Override
    public void updateLocation (Location location){         //providing body to function of interface
        this.updatedLocation = location;
        System.out.println("Location updated - Latitude: " + location.getLatitude() + ", Longitude: " + location.getLongitude());
    }

    public Location getUpdatedLocation() {          //Getter for Location
        return updatedLocation;
    }

    public StepCount getUpdatedStepCount() {        //Getter for StepCount
        return updatedStepCount;
    }
}