package edu.umb.cs680.hw04;

class HotState implements CoffeeMugState{
    @Override
    public String handleState(CoffeeMug coffeeMug){
        return "The coffee is hot.";
    }
}