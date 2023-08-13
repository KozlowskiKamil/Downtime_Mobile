package com.downtime.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.downtime.mobile.adapter.BreakdownAdapter;
import com.downtime.mobile.model.Breakedown;
import com.downtime.mobile.reotrfit.BreakdownApi;
import com.downtime.mobile.reotrfit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClickItem extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<Breakedown> breakedownArrayList = new ArrayList<>();
    String failureName;
    String computerName;
    String description;
    Long id;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_item);


        failureName = getIntent().getStringExtra("FailureName");
        computerName = getIntent().getStringExtra("ComputerName");
        description = getIntent().getStringExtra("Description");
        id = getIntent().getLongExtra("Id", getTaskId());
//        id = getIntent().getLongExtra("Id",  );
//        int image = getIntent().getIntExtra("IMAGE", 0);


        TextView failureNameView = findViewById(R.id.failureListItem_name_click);
        TextView computerNameView = findViewById(R.id.failureListItem_location_click);
        TextView descriptionView = findViewById(R.id.failureListItem_description_click);
        TextView idView = findViewById(R.id.failureListItem_id_click);

        failureNameView.setText(failureName);
        computerNameView.setText(computerName);
        descriptionView.setText(description);
        idView.setText(String.valueOf(id));

        recyclerView = findViewById(R.id.failureList_same);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton floatingActionButton = findViewById(R.id.failureList_fab);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, BreakdownForm.class);
            startActivity(intent);
        });
    }


    private void loadfailures(String computerNamee, String failureNamee) {
        RetrofitService retrofitService = new RetrofitService();
        BreakdownApi breakdownApi = retrofitService.getRetrofit().create(BreakdownApi.class);
        breakdownApi.findAllByComputerNameAndFailureName(computerNamee, failureNamee)
                .enqueue(new Callback<List<Breakedown>>() {
                    @Override
                    public void onResponse(Call<List<Breakedown>> call, Response<List<Breakedown>> response) {
                        populateListView(response.body());
                        breakedownArrayList.addAll(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<Breakedown>> call, Throwable t) {
                        Toast.makeText(ClickItem.this, "Nie mogę wgrać awarii", Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadfailures(computerName, failureName);
    }

    @Override
    public void onItemClick(int position) {

    }

    private void populateListView(List<Breakedown> breakedownList) {
        BreakdownAdapter breakdownAdapter = new BreakdownAdapter(breakedownList, this);
        recyclerView.setAdapter(breakdownAdapter);
    }
}