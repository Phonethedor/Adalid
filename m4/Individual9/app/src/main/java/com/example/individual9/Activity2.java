package com.example.individual9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.individual9.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {
    private String TAG = Activity2.class.getSimpleName();
    private Activity2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        Log.i(TAG, "Desplegando lo enviado desde main activity");
        binding.imV5.setImageResource(Integer.parseInt(intent.getStringExtra("img")));
        binding.tv1.setText(intent.getStringExtra("msg"));

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Volviendo a Main activity");
                finish();
            }
        });
    }
}