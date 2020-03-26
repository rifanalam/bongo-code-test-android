package com.hr.bongocodetest.vehicle;

/**
 * Created By Rifan on 26/3/20.
 */
public class Plane implements Vehicle {

    private int numOfWheels;
    private int numOfPassengers;
    private boolean hasGas;

    public Plane(int numOfWheels, int numOfPassengers, boolean hasGas) {
        this.numOfWheels = numOfWheels;
        this.numOfPassengers = numOfPassengers;
        this.hasGas = hasGas;
    }

    @Override
    public int setNumOfWheels() {
        return numOfWheels;
    }

    @Override
    public int setNumOfPassengers() {
        return numOfPassengers;
    }

    @Override
    public boolean hasGas() {
        return hasGas;
    }
}
