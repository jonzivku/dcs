package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.declutterersystems.Classes.Resource;

import java.net.URL;

public class WebDisplay extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String url = intent.getStringExtra("URL");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_display);

        // change this to the name of the Url
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webview = findViewById(R.id.webViewId);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);

        // this will be the place to change the url
        webview.loadUrl(url);
    };
};