package com.eandbsolutions.models;

import javax.inject.Inject;

public class Car {
    private final Engine engine;
    private final Make make;

    @Inject
    public Car(Engine engine, Make make) {
        this.engine = engine == null ? new Engine() : engine;
        this.make = make == null ? new Make() : make;
    }

    public Engine getEngine() {
        return engine;
    }

    public Make getMake() {
        return make;
    }
}
