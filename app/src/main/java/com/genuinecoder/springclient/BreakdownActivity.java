package com.genuinecoder.springclient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.genuinecoder.springclient.adapter.BreakdownAdapter;
import com.genuinecoder.springclient.model.Breakedown;
import com.genuinecoder.springclient.reotrfit.BreakdownApi;
import com.genuinecoder.springclient.reotrfit.RetrofitService;
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
    setContentView(R.layout.activity_employee_list);

    recyclerView = findViewById(R.id.employeeList_recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    FloatingActionButton floatingActionButton = findViewById(R.id.employeeList_fab);
    floatingActionButton.setOnClickListener(view -> {
      Intent intent = new Intent(this, BreakdownForm.class);
      startActivity(intent);
    });
  }

  private void loadEmployees() {
    RetrofitService retrofitService = new RetrofitService();
    BreakdownApi breakdownApi = retrofitService.getRetrofit().create(BreakdownApi.class);
    breakdownApi.getAllEmployees()
        .enqueue(new Callback<List<Breakedown>>() {
          @Override
          public void onResponse(Call<List<Breakedown>> call, Response<List<Breakedown>> response) {
            populateListView(response.body());
          }

          @Override
          public void onFailure(Call<List<Breakedown>> call, Throwable t) {
            Toast.makeText(BreakdownActivity.this, "Failed to load employees", Toast.LENGTH_SHORT).show();
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
    loadEmployees();
  }
}