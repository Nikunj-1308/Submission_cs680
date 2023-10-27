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
