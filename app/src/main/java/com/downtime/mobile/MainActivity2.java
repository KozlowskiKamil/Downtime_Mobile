package com.downtime.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mai2);


        String name = getIntent().getStringExtra("NAME");
        String abberBig = getIntent().getStringExtra("ABBER_BIG");
        String abberSmall = getIntent().getStringExtra("SMALL");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView newTextView = findViewById(R.id.title);
    }
}