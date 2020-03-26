package com.hr.bongocodetest.vehicle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.hr.bongocodetest.R;
import com.hr.bongocodetest.databinding.ActivityVehicleBinding;

public class VehicleActivity extends AppCompatActivity {
    ActivityVehicleBinding binding;
    Car carInterface, carFactory;
    Plane planeInterface, planeFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_vehicle);

        carInterface = new Car(4, 5, true);
        planeInterface = new Plane(12, 120, true);

        carFactory = new VehicleFactory().buildACar(4, 5, true);
        planeFactory = new VehicleFactory().buildAPlane(12, 120, true);

        binding.buttonInterfaceCar.setOnClickListener(view -> {
            showInfo(carInterface.setNumOfWheels(), carInterface.setNumOfPassengers(), carInterface.hasGas());
        });

        binding.buttonInterfacePlane.setOnClickListener(view -> {
            showInfo(planeInterface.setNumOfWheels(), planeInterface.setNumOfPassengers(), planeInterface.hasGas());
        });

        binding.buttonFactoryCar.setOnClickListener(view -> {
            showInfo(carFactory.setNumOfWheels(), carFactory.setNumOfPassengers(), carFactory.hasGas());
        });

        binding.buttonFactoryPlane.setOnClickListener(view -> {
            showInfo(planeFactory.setNumOfWheels(), planeFactory.setNumOfPassengers(), planeFactory.hasGas());
        });
    }

    private void showInfo(int wheels, int passengers, boolean hasGas) {
        Toast.makeText(this, "Number of Wheels: " + wheels
                + "\nNumber of Passengers: " + passengers
                + "\nHas Gas?: " + (hasGas ? "Yes" : "No"), Toast.LENGTH_SHORT).show();
    }
}


