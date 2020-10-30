package com.eandbsolutions.models;

import javax.inject.Inject;

public class Car {
    private Engine engine;
    private Make make;

    @Inject
    public Car(Engine engine, Make make) {
        this.engine = engine;
        this.make = make;
    }
}
