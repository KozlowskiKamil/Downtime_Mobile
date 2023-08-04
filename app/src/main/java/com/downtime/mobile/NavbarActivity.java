package com.downtime.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.downtime.mobile.databinding.ActivityMain2Binding;

public class NavbarActivity extends AppCompatActivity {

    public ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.failure:
                    break;
                case R.id.done:
                    break;
                case R.id.close:
                    break;
                case R.id.etToken:
                    break;
            }



            return true;
        });



    }
}