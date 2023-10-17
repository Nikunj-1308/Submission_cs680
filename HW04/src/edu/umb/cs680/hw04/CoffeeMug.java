package edu.umb.cs680.hw04;

class CoffeeMug {
    private CoffeeMugState currentState;

    public CoffeeMug() {
        currentState = new ColdState();
    }

    public void setState(CoffeeMugState state) {
        this.currentState = state;
    }

    public String handleTemperature() {
        return currentState.handleState(this);
    }
}