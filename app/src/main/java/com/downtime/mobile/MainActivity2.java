package com.downtime.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mai2);


        String failureName = getIntent().getStringExtra("FailureName");
        String computerName = getIntent().getStringExtra("ComputerName");
        String description = getIntent().getStringExtra("Description");
//        int image = getIntent().getIntExtra("IMAGE", 0);


        TextView failureNameView = findViewById(R.id.failureListItem_name_click);
        TextView computerNameView = findViewById(R.id.failureListItem_location_click);
        TextView descriptionView = findViewById(R.id.failureListItem_description_click);

        failureNameView.setText(failureName);
        computerNameView.setText(computerName);
        descriptionView.setText(description);


    }
}