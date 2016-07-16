package org.phonelab.autorouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import org.phonelab.autorouter.web.AutorouterManager;
import org.phonelab.autorouter.web.AutorouterWebViewClient;

public class ConfigureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        // Set up WebView
        WebView webView = (WebView) findViewById(R.id.webView);
        AutorouterManager mng = new AutorouterManager(webView);
        mng.init();
        mng.start();
    }
}
