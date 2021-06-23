package com.pavankumar.htmlsourceviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button go;
    String uri;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
        go= findViewById(R.id.btn);


        go.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                uri = tv.getText().toString();
                webView = findViewById(R.id.webview);
                WebSettings webSettings = webView.getSettings();
                webView.loadUrl("view-source:" + uri);
                webSettings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();

        }
    }

}