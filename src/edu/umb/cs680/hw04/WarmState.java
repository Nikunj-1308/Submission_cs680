package edu.umb.cs680.hw04;

class WarmState implements CoffeeMugState{
    @Override
    public String returnCurrentState(CoffeeMug coffeeMug){
        return "The coffee is warm.";
    }

    @Override
    public void heat(CoffeeMug coffeeMug) {
        coffeeMug.setState(new HotState());
        System.out.println("Heating the coffee. It's now hot.");
    }
}