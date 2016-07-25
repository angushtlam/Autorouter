package org.phonelab.autorouter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import org.phonelab.autorouter.web.Autorouter;

public class ConfigureActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        // Set up WebView
        Autorouter mng = new Autorouter(this);
        mng.step();
    }

    /*
        Moves to the configuration activity.
    */
    public void toMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
