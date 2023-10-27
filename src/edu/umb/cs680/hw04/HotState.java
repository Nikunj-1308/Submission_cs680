package edu.umb.cs680.hw04;

class HotState implements CoffeeMugState{
    @Override
    public String returnCurrentState(CoffeeMug coffeeMug){
        return "The coffee is hot.";
    }

    @Override
    public void heat(CoffeeMug coffeeMug) {
        System.out.println("The coffee is already hot. No need to heat it further.");
    }
}