package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class StepCounterTest {

    @Test
    public void testUpdateStepCountAs1010() {
		int expectedStepCount = 1010;		//Expected

        StepCounter stepCounter = new StepCounter();			//Create Observable
        TrackerApp trackerApp = new TrackerApp();				//Create Observer

        stepCounter.addObserver(trackerApp);					//Add Observer

        stepCounter.updateStepCount(1010);						//Update method

        Assertions.assertEquals(expectedStepCount, trackerApp.getUpdatedStepCount().getCount());		//Verify StepCount
    }
}