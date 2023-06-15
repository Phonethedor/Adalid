package com.example.individual3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Toast;

import com.example.individual3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()){
                    int resultado = Integer.parseInt(binding.et1.getText().toString().trim()) + Integer.parseInt(binding.et2.getText().toString().trim());
                    binding.result.setText(Integer.toString(resultado));
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Numbers", Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()){
                    int resultado = Integer.parseInt(binding.et1.getText().toString().trim()) - Integer.parseInt(binding.et2.getText().toString().trim());
                    binding.result.setText(Integer.toString(resultado));
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Numbers", Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    Toast.makeText(MainActivity.this, "Incorrect Numbers", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(binding.et2.getText().toString().trim()) == 0) {
                    Toast.makeText(MainActivity.this, "It is impossible to divide by 0", Toast.LENGTH_LONG).show();
                } else{
                    int resultado = Integer.parseInt(binding.et1.getText().toString().trim()) / Integer.parseInt(binding.et2.getText().toString().trim());
                    binding.result.setText(Integer.toString(resultado));
                }
            }
        });

        binding.multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()){
                    int resultado = Integer.parseInt(binding.et1.getText().toString().trim()) * Integer.parseInt(binding.et2.getText().toString().trim());
                    binding.result.setText(Integer.toString(resultado));
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Numbers", Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public boolean validate() {
        boolean error = false;

        if (binding.et1.getText().toString().trim().isEmpty() || binding.et2.getText().toString().trim().isEmpty()) {
            error = true;
        }

        return error;
    }


}