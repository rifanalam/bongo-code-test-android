package com.hr.bongocodetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.hr.bongocodetest.anagram.AnagramActivity;
import com.hr.bongocodetest.databinding.ActivityMainBinding;
import com.hr.bongocodetest.player.PlayerActivity;
import com.hr.bongocodetest.vehicle.VehicleActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonAnagram.setOnClickListener(v -> {
            startActivity(new Intent(this, AnagramActivity.class));
        });

        binding.buttonVehicle.setOnClickListener(view -> {
            startActivity(new Intent(this, VehicleActivity.class));
        });

        binding.buttonPlayer.setOnClickListener(v -> {
            startActivity(new Intent(this, PlayerActivity.class));
        });
    }
}
