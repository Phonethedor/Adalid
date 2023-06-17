package com.example.sprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sprint.databinding.Activity2Binding;
import com.example.sprint.databinding.ActivityMainBinding;

public class Activity2 extends AppCompatActivity {
    private String TAG = Activity2.class.getSimpleName();
    private Activity2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Volviendo a main activity");
                finish();
            }
        });

        binding.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent url = new Intent(Intent.ACTION_VIEW);
                url.setData(Uri.parse("mailto:alvaroc.giovannim@gmail.com"));
                Log.i(TAG, "Utilizando Correo");
                startActivity(url);
            }
        });

        binding.ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent url = new Intent(Intent.ACTION_VIEW);
                url.setData(Uri.parse("https://www.linkedin.com/in/agcm2504"));
                Log.i(TAG, "Utilizando URL LinkedIn");
                startActivity(url);
            }
        });

        binding.btnWhats.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String msg = binding.et.getText().toString();
               Intent url = new Intent(Intent.ACTION_VIEW);
               url.setData(Uri.parse("https://wa.me/56997596088?text="+msg));
               Log.i(TAG, "Utilizando URL WhatsApp");
               startActivity(url);
           }
        });
    }
}