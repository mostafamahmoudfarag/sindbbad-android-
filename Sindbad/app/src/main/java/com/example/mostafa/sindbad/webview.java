package com.example.mostafa.sindbad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView webView=(WebView)findViewById(R.id.web);
        int i=getIntent().getExtras().getInt("page");
        i++;
 webView.loadUrl("file:///android_asset/"+ i +".html");

    }
}
