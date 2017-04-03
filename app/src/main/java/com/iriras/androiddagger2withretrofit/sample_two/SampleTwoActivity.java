package com.iriras.androiddagger2withretrofit.sample_two;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.iriras.androiddagger2withretrofit.R;

public class SampleTwoActivity extends AppCompatActivity {
    Vehicle mVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_two);

        VehicleComponent mVehicleComponent = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        mVehicle = mVehicleComponent.provideVehicle();
        Toast.makeText(getApplicationContext(), String.valueOf(mVehicle.getRpm()), Toast.LENGTH_SHORT).show();
    }
}
