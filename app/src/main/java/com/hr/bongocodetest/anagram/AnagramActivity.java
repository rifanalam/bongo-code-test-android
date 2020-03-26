package com.hr.bongocodetest.anagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.hr.bongocodetest.R;
import com.hr.bongocodetest.databinding.ActivityAnagramBinding;

import java.util.Arrays;

public class AnagramActivity extends AppCompatActivity {
    ActivityAnagramBinding binding;
    int NO_OF_CHARS = 256;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_anagram);
        binding.buttonAnagram.setOnClickListener(v->{
            if (TextUtils.isEmpty(binding.editTextFirstInput.getText()) || TextUtils.isEmpty(binding.editTextSecondInput.getText())) {
                Toast.makeText(this, "Please input text in both fields", Toast.LENGTH_SHORT).show();
            } else {
                checkAnagram(binding.editTextFirstInput.getText().toString(), binding.editTextSecondInput.getText().toString());
            }
        });
    }

    private void checkAnagram(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            Toast.makeText(this, firstString + " & " + secondString + " should same length :(", Toast.LENGTH_SHORT).show();
        } else if (isAnagram(firstString.toCharArray(), secondString.toCharArray())) {
            Toast.makeText(this, firstString + " & " + secondString + " Are Anagram :)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, firstString + " & " + secondString + " Are Not Anagram :(", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAnagram(char[] first, char[] second) {
        int[] firstCount = new int[NO_OF_CHARS];
        Arrays.fill(firstCount, 0);
        int[] secondCount = new int[NO_OF_CHARS];
        Arrays.fill(secondCount, 0);
        for (int i = 0; i < first.length && i < second.length; i++) {
            firstCount[first[i]]++;
            secondCount[second[i]]++;
        }

        for (int i = 0; i < NO_OF_CHARS; i++)
            if (firstCount[i] != secondCount[i])
                return false;

        return true;
    }
}
