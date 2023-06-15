package com.example.individual9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.individual9.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        Log.i(TAG, "Main activity iniciada");
        Log.i(TAG, ""+R.drawable.img2);
        setContentView(view);

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        binding.imV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Enviando a segunda activity");
                send(String.valueOf(R.drawable.img1), "Esta es la primera imagen");
            }
        });

        binding.imV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Enviando a segunda activity");
                send(String.valueOf(R.drawable.img2), "Esta es la segunda imagen");
            }
        });

        binding.imV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Enviando a segunda activity");
                send(String.valueOf(R.drawable.img3), "Esta es la tercera imagen");
            }
        });

        binding.imV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Enviando a segunda activity");
                send(String.valueOf(R.drawable.img4), "Esta es la cuarta imagen");
            }
        });
    }

    protected  void send(String image, String msg){
        Intent intent = new Intent(MainActivity.this, Activity2.class) ;
        intent.putExtra("img",image);
        intent.putExtra("msg", msg);
        startActivity(intent);
    }
}