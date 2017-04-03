package com.iriras.androiddagger2withretrofit.sample_two;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by irfan on 03/04/17.
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
    Vehicle provideVehicle();
}
