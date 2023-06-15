package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.myapplication.databinding.ActivityWelcomeBinding;

public class Welcome extends AppCompatActivity {
    private String TAG = Welcome.class.getSimpleName();
    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        Intent intent = getIntent();
        String greet = "Hi " + intent.getStringExtra("first") + " " + intent.getStringExtra("second");
        String email ="Your E-mail is :" + intent.getStringExtra("email");
        String pass = "And your PassWord is : " + intent.getStringExtra("pass");
        Log.i(TAG, "Displaying data");
        binding.saludo.setText(greet);
        binding.correo.setText(email);
        binding.pass.setText(pass);

        binding.back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent r = new Intent(Welcome.this, MainActivity.class);
                startActivity(r);
                Log.i(TAG, "Returning to main Activity");
            }
        });

    }
}