package com.eandbsolutions;

import com.eandbsolutions.components.DaggerVehiclesComponent;
import com.eandbsolutions.components.VehiclesComponent;
import com.eandbsolutions.models.Car;

public class App {

    public static void main(String[] args) {
        System.out.println("Here");
        VehiclesComponent vehiclesComponent = DaggerVehiclesComponent.create();

        Car carOne = vehiclesComponent.buildCar();
        System.out.println(carOne.getEngine());
        System.out.println(carOne.getMake());
    }
}
