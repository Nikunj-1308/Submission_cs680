package edu.umb.cs680.hw05;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class KitchenTest {
	@Test
	public void testTemperatureEventConstructorAndGetterForTemp25() {
		TemperatureEvent event = new TemperatureEvent(25); // Event Created
		int expected = 25; // Expected Temperature
		int actual = event.getTemperature(); // Initialize actual temperature with getTemperature method
		Assertions.assertEquals(expected, actual); // Check if Constructor initializes correctly and same value is
													// returned by getter method
	}

	@Test
	public void testKitchenControllerIsObservable() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		Assertions.assertTrue(controller instanceof Observable); // Test if KitchenControllerImpl instance is of type
																	// observable
	}

	@Test
	public void testKitchenControllerIsNotObserver() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		Assertions.assertFalse(controller instanceof Observer); // Test if KitchenControllerImpl instance is not of type
																// observer
	}

	@Test
	public void testFridgeIsObserver() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		SmartFridge fridge = new SmartFridge(); // Device created

		Assertions.assertTrue(fridge instanceof Observer); // Test if device created is of type observer
	}

	@Test
	public void testOvenIsObserver() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		SmartOven oven = new SmartOven(); // Device created

		Assertions.assertTrue(oven instanceof Observer); // Test if device created is of type observer
	}

	@Test
	public void testTemperatureChangeFrom25To30WithChangeTemperatureForFridge() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		SmartFridge fridge = new SmartFridge(); // Device created
		controller.registerDevice(fridge); // Device registered

		Assertions.assertTrue(fridge instanceof Observer); // Test if device created is of type observer
		int expected = 30; // Expected Temperature

		controller.changeTemperature(25);
		controller.changeTemperature(30); // Change Temperature to 30

		int actual = fridge.getFridgeLastTemperature(); // Retrieve Fridge Temp
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testTemperatureChangeFrom25To30WithChangeTemperatureForOven() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		SmartOven oven = new SmartOven(); // Device created
		controller.registerDevice(oven); // Device registered

		Assertions.assertTrue(oven instanceof Observer); // Test if device created is of type observer
		int expected = 30; // Expected Temperature

		controller.changeTemperature(25); // Initial Temp
		controller.changeTemperature(30); // Changed Temperature

		int actual = oven.getOvenLastTemperature(); // Retrieve Oven Temp
		Assertions.assertEquals(expected, actual); // Verify
	}

	@Test
	public void testRegisterDeviceFridgeInKitchenController() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		int expected = 1;
		SmartFridge fridge = new SmartFridge(); // Create one device
		controller.registerDevice(fridge); // Register the device
		int actual = controller.countObservers(); // Count number of devices
		Assertions.assertEquals(expected, actual); // Verify
	}

	@Test
	public void testRegisterDeviceOvenInKitchenController() {
		KitchenControllerImpl controller = new KitchenControllerImpl();
		int expected = 1;
		SmartOven oven = new SmartOven(); // Create one device
		controller.registerDevice(oven); // Register the device
		int actual = controller.countObservers(); // Count number of devices
		Assertions.assertEquals(expected, actual); // Verify
	}

	@Test
	public void testNumberOfRegisterDeviceInKitchenControllerFridgeAndOven() {
		KitchenControllerImpl controller = new KitchenControllerImpl();

		int expected = 1;

		SmartFridge fridge = new SmartFridge(); // Create one device
		controller.registerDevice(fridge); // Register the device
		int actual = controller.countObservers();

		Assertions.assertEquals(expected, actual);

		SmartOven oven = new SmartOven(); // Create another device
		controller.registerDevice(oven); // Register the device
		actual = controller.countObservers();

		expected++;
		Assertions.assertEquals(expected, actual); // Verify device count
	}

	@Test
	public void testFridgeOvenFridgeRegisterDeviceInKitchenController() {
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartFridge fridge_1 = new SmartFridge(); // Create one device
		controller.registerDevice(fridge_1); // Register the device

		SmartOven oven = new SmartOven(); // Create another device
		controller.registerDevice(oven); // Register the device

		SmartFridge fridge_2 = new SmartFridge(); // Create another device
		controller.registerDevice(fridge_2); // Register the device

		List<Observer<TemperatureEvent>> expected = new ArrayList<>();
		expected.add(fridge_1);
		expected.add(oven);
		expected.add(fridge_2); // List of devices prepared

		List<Observer<TemperatureEvent>> actual = controller.getObservers(); // Get the list of devices

		Assertions.assertIterableEquals(expected, actual); // Verify list of devices registered
	}

	@Test
	public void testTemperatureChange30ForFridge() {
		int expected = 30;
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartFridge fridge = new SmartFridge(); // Create one device

		controller.registerDevice(fridge); // Register the device
		controller.changeTemperature(30); // Change Temperature

		Assertions.assertEquals(expected, fridge.getFridgeLastTemperature()); // Verify temperature change using
																				// getFridgeLastTemperature
	}

	@Test
	public void testTemperatureChange30EventForOven() {
		int expected = 30;
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartOven oven = new SmartOven(); // Create one device

		controller.registerDevice(oven); // Register the device
		controller.changeTemperature(30); // Change Temperature

		Assertions.assertEquals(expected, oven.getOvenLastTemperature()); // Verify temperature change using
																			// getOvenLastTemperature
	}

	@Test
	public void testTemperatureChange30AfterFridgeRegisterEventForOven() {
		int expected = 30;
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartOven oven = new SmartOven(); // Create one device

		controller.registerDevice(oven); // Register the device
		SmartFridge fridge = new SmartFridge(); // Create one device
		controller.registerDevice(fridge); // Register the device
		controller.changeTemperature(30); // Change Temperature

		Assertions.assertEquals(expected, oven.getOvenLastTemperature()); // Verify temperature change using
																			// getOvenLastTemperature
	}

	@Test
	public void testTemperatureChange30EventForFridgeAndOven() {
		int expected = 30;
		KitchenControllerImpl controller = new KitchenControllerImpl();

		SmartFridge fridge = new SmartFridge(); // Create one device
		SmartOven oven = new SmartOven(); // Create one device

		controller.registerDevice(fridge); // Register the device
		controller.registerDevice(oven); // Register the device
		controller.changeTemperature(30); // Change Temperature

		Assertions.assertEquals(expected, fridge.getFridgeLastTemperature()); // Verify temperature change using
																				// getFridgeLastTemperature
		Assertions.assertEquals(expected, oven.getOvenLastTemperature()); // Verify temperature change using
																			// getOvenLastTemperature

		controller.changeTemperature(80); // Change Temperature
		expected = 80;
		Assertions.assertEquals(expected, fridge.getFridgeLastTemperature()); // Verify temperature change using
																				// getFridgeLastTemperature
		Assertions.assertEquals(expected, oven.getOvenLastTemperature()); // Verify temperature change using
																			// getOvenLastTemperature
	}
}
