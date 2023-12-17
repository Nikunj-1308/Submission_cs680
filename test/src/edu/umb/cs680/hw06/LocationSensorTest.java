package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



class LocationSensorTest {

    @Test
    public void verifyUpdateLocationAs10Point10And123Point321() {
		double expectedLatitude = 10.10;		//Expected
		double expectedLongitude = 123.321;	//Expected

        LocationSensor locationSensor = new LocationSensor();		//Create Observable
        TrackerApp trackerApp = new TrackerApp();					//Create Observer

        locationSensor.addObserver(trackerApp);						//Add Observer
        locationSensor.updateLocation(10.10, 123.321);				//Update method

        Assertions.assertEquals(expectedLatitude, trackerApp.getUpdatedLocation().getLatitude());		//Verify Latitude
        Assertions.assertEquals(expectedLongitude, trackerApp.getUpdatedLocation().getLongitude());		//Verify Latitude
    }
}
