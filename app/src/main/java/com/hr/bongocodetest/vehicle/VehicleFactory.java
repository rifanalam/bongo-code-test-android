package com.hr.bongocodetest.vehicle;

/**
 * Created By Rifan on 26/3/20.
 */
public class VehicleFactory {

    Car buildACar(int numberOfWheels, int numberOfPassengers, boolean hasGas) {
        return new Car(numberOfWheels, numberOfPassengers, hasGas);
    }

    Plane buildAPlane(int numberOfWheels, int numberOfPassengers, boolean hasGas) {
        return new Plane(numberOfWheels, numberOfPassengers, hasGas);
    }
}
