package com.downtime.mobile;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.downtime.mobile.model.Breakedown;
import com.downtime.mobile.reotrfit.BreakdownApi;
import com.downtime.mobile.reotrfit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreakdownClose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown_close);

        initializeComponents();
    }

    private void initializeComponents() {
        TextInputEditText inputEditTextNumberBt = findViewById(R.id.form_text_failureName);
        TextInputEditText inputEditDescription = findViewById(R.id.form_textField_description);
        TextInputEditText inputEditwaitingTime = findViewById(R.id.form_textField_waitingTime);

        MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

        RetrofitService retrofitService = new RetrofitService();
        BreakdownApi breakdownApi = retrofitService.getRetrofit().create(BreakdownApi.class);

        buttonSave.setOnClickListener(view -> {
            String numberBt = String.valueOf(inputEditTextNumberBt.getText());
            String description = String.valueOf(inputEditDescription.getText());
            Long waitingTimeForm = Long.valueOf(String.valueOf(inputEditwaitingTime.getText()));
            Long waitingTime = waitingTimeForm * 60; // minute to second

            Breakedown breakedown = new Breakedown();
            breakedown.setId(ClickItem.id);
            // WARNING: I'm using the failure name here to send a number BT, I know it's bad practice. It's just easier- Kamil ;)
            breakedown.setFailureName(numberBt);
            breakedown.setDescription(description);
            breakedown.setWaitingTime(waitingTime);


            breakdownApi.close(breakedown).enqueue(new Callback<Breakedown>() {
                @Override
                public void onResponse(Call<Breakedown> call, Response<Breakedown> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(BreakdownClose.this, "Zapisano awarię!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(BreakdownClose.this, "Zły numer BT", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<Breakedown> call, Throwable t) {
                    Toast.makeText(BreakdownClose.this, "Nie zapisano awarii!", Toast.LENGTH_LONG).show();
                    Logger.getLogger(BreakdownForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
                }
            });
        });
    }
}