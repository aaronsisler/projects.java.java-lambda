package com.eandbsolutions.components;

import com.eandbsolutions.models.Car;
import com.eandbsolutions.modules.VehiclesModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = VehiclesModule.class)
public interface VehiclesComponent {
    Car buildCar();
}