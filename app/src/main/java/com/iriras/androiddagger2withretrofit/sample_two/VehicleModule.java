package com.iriras.androiddagger2withretrofit.sample_two;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by irfan on 03/04/17.
 */

@Module
public class VehicleModule {

    @Provides
    @Singleton
    Motor provideMotor() {
        return new Motor();
    }

    @Provides
    @Singleton
    Vehicle provideVehicle() {
        return new Vehicle(new Motor());
    }
}
