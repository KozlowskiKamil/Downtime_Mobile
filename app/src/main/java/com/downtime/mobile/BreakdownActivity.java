package com.downtime.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.downtime.mobile.adapter.BreakdownAdapter;
import com.downtime.mobile.model.Breakedown;
import com.downtime.mobile.reotrfit.BreakdownApi;
import com.downtime.mobile.reotrfit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreakdownActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure_list);

        recyclerView = findViewById(R.id.failureList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.failureList_fab);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, BreakdownForm.class);
            startActivity(intent);
        });
    }

    private void loadfailures() {
        RetrofitService retrofitService = new RetrofitService();
        BreakdownApi breakdownApi = retrofitService.getRetrofit().create(BreakdownApi.class);
        breakdownApi.getAllfailures()
                .enqueue(new Callback<List<Breakedown>>() {
                    @Override
                    public void onResponse(Call<List<Breakedown>> call, Response<List<Breakedown>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Breakedown>> call, Throwable t) {
                        Toast.makeText(BreakdownActivity.this, "Nie mogę wgrać awarii", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void populateListView(List<Breakedown> breakedownList) {
        BreakdownAdapter breakdownAdapter = new BreakdownAdapter(breakedownList);
        recyclerView.setAdapter(breakdownAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadfailures();
    }
}