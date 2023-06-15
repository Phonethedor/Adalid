package com.example.individual8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.individual8.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {
    private String TAG = Activity2.class.getSimpleName();
    private Activity2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent url = new Intent(Intent.ACTION_VIEW);
                url.setData(Uri.parse("https://kotlindoc.blogspot.com/2019/10/android-log-con-timber.html"));
                Log.i(TAG, "Utilizando URL");
                startActivity(url);
            }
        });

        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Volviendo a Main activity");
                finish();
            }
        });
    }
}