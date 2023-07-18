package com.example.individual1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

import com.example.individual1m5.databinding.ActivityMainBinding;
import com.example.individual1m5.databinding.FragmentWebBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se obtiene el texto desde el textfield
                String url= binding.textField.getEditText().getText().toString();
                //Se define webview, se da soporte a fragment manager, se indica ubicacion de fragmento, se muestra y se indica ubicacion del webview
                WebView webView= (WebView)getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView3).getView().findViewById(R.id.wv1);
                //se carga la string url
                webView.loadUrl(url);

            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });


    }
}