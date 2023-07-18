package com.example.individual4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.individual4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mbinding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mbinding.getRoot());
    }
}