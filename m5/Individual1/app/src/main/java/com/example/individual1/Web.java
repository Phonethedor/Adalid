package com.example.individual1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.individual1m5.databinding.FragmentWebBinding;


public class Web extends Fragment {

    private FragmentWebBinding webBinding;
    private WebView webView;


    public Web() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        webBinding = FragmentWebBinding.inflate(inflater, container, false);

        webView=webBinding.wv1;
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);





        return webBinding.getRoot();


    }

    public void loadUrl(String url){
        webView.loadUrl(url);
    }
}
