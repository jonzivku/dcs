package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebDisplay extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_display);

        String name = getIntent().getStringExtra("NAME");
        String url = getIntent().getStringExtra("URL");

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

    }
}
