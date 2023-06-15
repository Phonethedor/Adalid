package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        Log.i(TAG, "Initiating Main activity");
        setContentView(view);

        binding.bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (validate().isEmpty()) {
                    Intent intent = new Intent(view.getContext(), Welcome.class);
                    intent.putExtra("first", binding.et1.getText().toString());
                    intent.putExtra("second", binding.et2.getText().toString());
                    intent.putExtra("email", binding.et3.getText().toString());
                    intent.putExtra("pass", binding.et4.getText().toString());
                    Log.i(TAG, "Data retrieval completed successfully");
                    Log.i(TAG, "Redirecting to Welcome activity");
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, validate(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String validate() {
        String errors = "";
        String regex = "[0-9]+";
        if (binding.et1.getText().toString().trim().isEmpty()){
            errors += "First Name is Empty ";
            Log.w(TAG, "Empty Field");
        }
        if (binding.et1.getText().toString().trim().matches(regex)){
            errors += "Last Name cannot contain numbers ";
            Log.w(TAG, "Wrong Field");
        }
        if (binding.et2.getText().toString().trim().isEmpty()){
            errors += "Last Name is Empty ";
            Log.w(TAG, "Empty Field");
        }
        if (binding.et2.getText().toString().trim().matches(regex)){
            errors += "Last Name cannot contain numbers ";
            Log.w(TAG, "Wrong Field");
        }
        if (binding.et3.getText().toString().trim().isEmpty()){
            errors += "Email is Empty ";
            Log.w(TAG, "Empty Field");
        }
        if (binding.et4.getText().toString().trim().isEmpty()){
            errors += "Password is Empty";
            Log.w(TAG, "Empty Field");
        }

        return errors;
    }
}