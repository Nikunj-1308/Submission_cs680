package edu.umb.cs680.hw04;

class WarmState implements CoffeeMugState{
    @Override
    public String handleState(CoffeeMug coffeeMug){
        return "The coffee is warm.";
    }
}