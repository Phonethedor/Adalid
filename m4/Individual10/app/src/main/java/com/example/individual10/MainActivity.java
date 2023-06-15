package com.example.individual10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.individual10.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        Log.i(TAG, "Main activity iniciada");
        setContentView(view);

        binding.tf1.setHint("Full Name");
        binding.tf2.setHint("E-mail");
        binding.tf3.setHint("Phone");
        binding.tf4.setHint("Password");
        binding.btn1.setText(R.string.create);
        Log.i(TAG, "Valores por defecto asignados");
    }
}