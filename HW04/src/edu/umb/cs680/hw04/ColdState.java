package edu.umb.cs680.hw04;

class ColdState implements CoffeeMugState{
    @Override
    public String returnCurrentState(CoffeeMug coffeeMug){
        return "The coffee is cold.";
    }

    @Override
    public void heat(CoffeeMug coffeeMug) {
        coffeeMug.setState(new WarmState());
        System.out.println("Heating the coffee. It's now warm.");
    }
}