package com.iriras.androiddagger2withretrofit.sample_two;

import javax.inject.Inject;

/**
 * Created by irfan on 03/04/17.
 */

public class Vehicle {
    private Motor mMotor;

    @Inject
    public Vehicle(Motor mMotor) {
        this.mMotor = mMotor;
    }

    public void increaseSpeed(int value) {
        mMotor.accelerate(value);
    }

    public void stop() {
        mMotor.brake();
    }

    public int getRpm() {
        return mMotor.getRpm();
    }
}
