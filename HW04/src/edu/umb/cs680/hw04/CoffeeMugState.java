package edu.umb.cs680.hw04;

interface CoffeeMugState{
    String returnCurrentState(CoffeeMug coffeeMug);

    void heat(CoffeeMug coffeeMug);
}