package com.downtime.mobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.downtime.mobile.databinding.ActivityMain2Binding;
import com.downtime.mobile.fragment.FailureFragment;

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
                    Intent intent = new Intent(NavbarActivity.this, OngoingActivity.class);
                    startActivity(intent);
                    break;
                case R.id.done:
                    Intent intent2 = new Intent(NavbarActivity.this, BreakdownActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.close:
                    replacefragment(new FailureFragment());
                    break;
                case R.id.token:
                    Intent intent4 = new Intent(NavbarActivity.this, Notyfication.class);
                    startActivity(intent4);
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