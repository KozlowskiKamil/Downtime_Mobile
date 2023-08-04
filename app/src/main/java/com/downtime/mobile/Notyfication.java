package com.downtime.mobile;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class Notyfication extends AppCompatActivity {

    EditText etToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notyfication);

        etToken = findViewById(R.id.etToken);

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.i("Msg" ,"Fetching FCM registration token failed");
                    return;
                }

                // Get new FCM registration token
                String token = task.getResult();

                // Log and toast
                System.out.println(token);
                Toast.makeText(Notyfication.this, "Device token is " + token, Toast.LENGTH_SHORT).show();
                Log.i("Token", token.toString());
                etToken.setText(token);
            }
        });
    }
}
