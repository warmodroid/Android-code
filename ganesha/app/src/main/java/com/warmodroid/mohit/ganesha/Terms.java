package com.warmodroid.mohit.ganesha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Terms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://warmodroid.xyz/batteryTermAndPolicy.html");
    }
}
