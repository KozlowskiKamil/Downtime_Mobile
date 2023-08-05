package com.downtime.mobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.downtime.mobile.databinding.ActivityMain2Binding;

public class NavbarActivity extends AppCompatActivity {

    public ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replacefragment(new FailureFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.failure:
                    replacefragment(new FailureFragment());
                    break;
                case R.id.done:
                    replacefragment(new DoneFragment());

                    break;
                case R.id.close:
                    replacefragment(new CloseFragment());

                    break;
                case R.id.etToken:
                    replacefragment(new TokenFragment());

                    break;
            }


            return true;
        });

    }

    private void replacefragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}