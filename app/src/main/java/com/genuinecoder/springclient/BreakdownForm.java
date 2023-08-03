package com.genuinecoder.springclient;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.genuinecoder.springclient.model.Breakedown;
import com.genuinecoder.springclient.reotrfit.BreakdownApi;
import com.genuinecoder.springclient.reotrfit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreakdownForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents() {
        TextInputEditText inputEditTextName = findViewById(R.id.form_textFieldName);
        TextInputEditText inputEditBranch = findViewById(R.id.form_textFieldBranch);
        TextInputEditText inputEditLocation = findViewById(R.id.form_textFieldLocation);
        MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

        RetrofitService retrofitService = new RetrofitService();
        BreakdownApi breakdownApi = retrofitService.getRetrofit().create(BreakdownApi.class);

        buttonSave.setOnClickListener(view -> {
            String name = String.valueOf(inputEditTextName.getText());
            String branch = String.valueOf(inputEditBranch.getText());
            String location = String.valueOf(inputEditLocation.getText());

            Breakedown breakedown = new Breakedown();
            breakedown.setFailureName(name);
            breakedown.setDescription(branch);
            breakedown.setComputerName(location);

            breakdownApi.save(breakedown)
                    .enqueue(new Callback<Breakedown>() {
                        @Override
                        public void onResponse(Call<Breakedown> call, Response<Breakedown> response) {
                            Toast.makeText(BreakdownForm.this, "Zapisano awarię!", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Breakedown> call, Throwable t) {
                            Toast.makeText(BreakdownForm.this, "Nie zapisano awarii!", Toast.LENGTH_LONG).show();
                            Logger.getLogger(BreakdownForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });
        });
    }
}