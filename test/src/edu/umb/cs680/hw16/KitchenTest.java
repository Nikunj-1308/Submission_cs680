package edu.umb.cs680.hw16;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class KitchenTest {

    @Test
    public void testTemperatureEventConstructorAndGetterForTemp25() {
        TemperatureEvent event = new TemperatureEvent(25);
        int expected = 25;
        int actual = event.getTemperature();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testKitchenControllerIsObservable() {
        KitchenControllerImpl controller = new KitchenControllerImpl();
        Assertions.assertTrue(controller instanceof Observable);
    }

    @Test
    public void testKitchenControllerIsNotObserver() {
        KitchenControllerImpl controller = new KitchenControllerImpl();
        Assertions.assertFalse(controller instanceof Observer);
    }

    @Test
    public void testFridgeIsObserver() {
        KitchenControllerImpl controller = new KitchenControllerImpl();
        Observer<TemperatureEvent> fridgeObserver = (sender, event) -> {
            if (event.getTemperature() > 5) {
                System.out.println("Smart Fridge: It's too hot in the kitchen. Cooling down...");
            }
        };
        Assertions.assertTrue(fridgeObserver instanceof Observer);
    }

    @Test
    public void testOvenIsObserver() {
        KitchenControllerImpl controller = new KitchenControllerImpl();
        Observer<TemperatureEvent> ovenObserver = (sender, event) -> {
            if (event.getTemperature() < 180) {
                System.out.println("Smart Oven: It's too cold in the kitchen. Preheating...");
            }
        };
        Assertions.assertTrue(ovenObserver instanceof Observer);
    }

    @Test
    public void testTemperatureChangeFrom25To30WithChangeTemperatureForFridge() {
        KitchenControllerImpl controller = new KitchenControllerImpl();
        SmartFridge fridge = new SmartFridge();
        
        Observer<TemperatureEvent> fridgeObserver = (Observable<TemperatureEvent> sender, TemperatureEvent event) -> {
            fridge.update(sender, event);
        };

        controller.registerDevice(fridgeObserver);
        
        int expected = 30;

        controller.changeTemperature(25);
        controller.changeTemperature(30);

    
        int actual = fridge.getFridgeLastTemperature();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTemperatureChangeFrom25To30WithChangeTemperatureForOven() {
        KitchenControllerImpl controller = new KitchenControllerImpl();
        SmartOven oven = new SmartOven();

        Observer<TemperatureEvent> ovenObserver = (Observable<TemperatureEvent> sender, TemperatureEvent event) -> {
            oven.update(sender, event);
        };

        controller.registerDevice(ovenObserver);
        int expected = 30;

        controller.changeTemperature(25);
        controller.changeTemperature(30);

        int actual = oven.getOvenLastTemperature();
        Assertions.assertEquals(expected, actual);
    }
}