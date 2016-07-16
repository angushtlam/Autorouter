package org.phonelab.autorouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import org.phonelab.autorouter.web.AutorouterWebViewClient;

public class ConfigureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        // Set up WebView
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new AutorouterWebViewClient()); // Handles HTTP-Authentication that most routers implement
        webView.getSettings().setJavaScriptEnabled(true); // Enable Javascript for webpage manipulation.
        webView.loadUrl("http://192.168.1.1");
    }
}
