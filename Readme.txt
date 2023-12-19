HW04:
This is a Temperature Control Coffee Mug application using the State design pattern.
The application involves modeling the different states of the coffee mug and transitioning between them.

3 Coffee Mug states:
-> Cold state (Initial State)
-> Warm state
-> Hot state

Transitions:
Cold + heat -> Warm
Warm + heat -> Hot
Hot + heat -> Hot

We have CoffeeMugState, an interface with which we can override handleState and heat methods.
Each state class implments the handlestate and heat method in it's own way as per transitions shown above.

The above behaviour benefit from State Design Pattern.


HW05:
This is a Smart Kitchen Application usingthe Observer Design Pattern.
The application involves registering smart devices like Fridge, Oven, Microwave. And we can send an event to change the temperature of these devices.

KitchenControllerImpl implements the Observable class, so that it can use the methods defined in Observable.

Cases like:
SmartFridge: Implements Observer and reacts to temperature change in kitchen as per condition.
SmartOven: Implements Observer and reacts to temperature change in kitchen as per condition.

SmartKitchen App demonstrates how whole application runs.

TemperatureEvent: A class representing a temperature change event. It has a data member temperature, a constructor and a method.

The above behaviour benefit from Observer Design Pattern.

HW16:
This is a Smart Kitchen Application using the Observer Design Pattern.
The application involves registering smart devices like Fridge, Oven, Microwave. And we can send an event to change the temperature of these devices.

KitchenControllerImpl implements the Observable class, so that it can use the methods defined in Observable.

Cases like previously:
SmartFridge: Implements Observer and reacts to temperature change in kitchen as per condition.
SmartOven: Implements Observer and reacts to temperature change in kitchen as per condition.

Now: It is being done with Lambda Expression which replaces the Observer Classes.e

SmartKitchen App demonstrates how whole application runs.

TemperatureEvent: A class representing a temperature change event. It has a data member temperature, a constructor and a method.

The above behaviour benefit from Observer Design Pattern.


