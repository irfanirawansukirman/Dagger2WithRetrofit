package com.iriras.androiddagger2withretrofit.sample_two;

/**
 * Created by irfan on 03/04/17.
 */

public class Motor {
    private int rpm;

    public Motor() {
        this.rpm = 0;
    }

    public int getRpm() {
        return rpm;
    }

    public void accelerate(int value) {
        rpm = rpm + value;
    }

    public void brake() {
        rpm = 0;
    }
}
