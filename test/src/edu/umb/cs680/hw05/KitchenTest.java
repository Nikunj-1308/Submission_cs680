package edu.umb.cs680.hw05;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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
	public void testUpdateMethodForSmartFridge() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		SmartFridge fridge = new SmartFridge();
		controller.registerDevice(fridge);

		Assertions.assertTrue(fridge instanceof Observer);

		TemperatureEvent event = new TemperatureEvent(30);
		controller.notifyObservers(event);
	}

	@Test
	public void testUpdateMethodForSmartOven() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		SmartOven oven = new SmartOven();
		controller.registerDevice(oven);

		Assertions.assertTrue(oven instanceof Observer);

		TemperatureEvent event = new TemperatureEvent(160);
		controller.notifyObservers(event);
	}

	@Test
	public void testRegisterDeviceInKitchenController() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		int expected = 1;
		SmartFridge fridge = new SmartFridge();
		controller.registerDevice(fridge);
		int actual = controller.countObservers();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testNumberOfRegisterDeviceInKitchenController() {
		KitchenControllerImpl controller = new KitchenControllerImpl();

		int expected = 1;

		SmartFridge fridge = new SmartFridge();
		controller.registerDevice(fridge);
		int actual = controller.countObservers();

		Assertions.assertEquals(expected, actual);

		SmartOven oven = new SmartOven();
		controller.registerDevice(oven);
		actual = controller.countObservers();

		expected++;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testFridgeOvenFridgeRegisterDeviceInKitchenController() {
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartFridge fridge_1 = new SmartFridge();
		controller.registerDevice(fridge_1);

		SmartOven oven = new SmartOven();
		controller.registerDevice(oven);

		SmartFridge fridge_2 = new SmartFridge();
		controller.registerDevice(fridge_2);

		List<Observer<TemperatureEvent>> expected = new ArrayList<>();
		expected.add(fridge_1);
		expected.add(oven);
		expected.add(fridge_2);

		List<Observer<TemperatureEvent>> actual = controller.getObservers();

		Assertions.assertIterableEquals(expected, actual);
	}

	@Test
	public void testTemperatureChange30EventForFridge() {
		int expected = 30;
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartFridge fridge = new SmartFridge();

		controller.registerDevice(fridge);
		controller.changeTemperature(30);

		Assertions.assertEquals(expected, fridge.getFridgeLastTemperature());
	}

	@Test
	public void testTemperatureChange30EventForOven() {
		int expected = 30;
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartOven oven = new SmartOven();

		controller.registerDevice(oven);
		controller.changeTemperature(30);

		Assertions.assertEquals(expected, oven.getOvenLastTemperature());
	}

	@Test
	public void testTemperatureChange30EventForFridgeAndOven() {
		int expected = 30;
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartFridge fridge = new SmartFridge();
		SmartOven oven = new SmartOven();

		controller.registerDevice(fridge);
		controller.registerDevice(oven);
		controller.changeTemperature(30);

		Assertions.assertEquals(expected, fridge.getFridgeLastTemperature());
		Assertions.assertEquals(expected, oven.getOvenLastTemperature());

		controller.changeTemperature(80);
		expected = 80;
		Assertions.assertEquals(expected, fridge.getFridgeLastTemperature());
		Assertions.assertEquals(expected, oven.getOvenLastTemperature());
	}

}
