package org.phonelab.autorouter.web;

import android.webkit.WebView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anguslam on 7/15/16.
 */
public class AutorouterManager {
    private WebView _webView;

    private ArrayList<String> commonRouterAddresses;
    private HashMap<String, String> commonRouterLogins;

    // Takes a WebView with no settings applied to it.
    public AutorouterManager(WebView webView) {
        _webView = webView;
    }

    // Initially sets up the autorouter.
    public void init() {
        setUpCommonData();
        setUpWebView();
    }

    // Begin the autorouter.
    public void start() {
        _webView.loadUrl(commonRouterAddresses.get(0));
    }

    // Sets up the arraylist with common router IP addresses and logins.
    public void setUpCommonData() {
        // Create an arraylist of common IP addresses.
        // http://www.techspot.com/guides/287-default-router-ip-addresses/
        commonRouterAddresses = new ArrayList<>();
        commonRouterAddresses.add("http://192.168.1.1");
        commonRouterAddresses.add("http://192.168.0.1");
        commonRouterAddresses.add("http://10.0.1.1");
        commonRouterAddresses.add("http://10.1.1.1");
        commonRouterAddresses.add("http://10.0.0.2");
        commonRouterAddresses.add("http://192.168.0.254");

        commonRouterLogins = new HashMap<>();
        commonRouterLogins.put("admin", "password");
        commonRouterLogins.put("admin", "admin");
        commonRouterLogins.put("admin", "");
        commonRouterLogins.put("root", "");
    }

    // Sets up the WebView with necessary settings.
    public void setUpWebView() {
        _webView.setWebViewClient(new AutorouterWebViewClient()); // Handles HTTP-Authentication that most routers implement
        _webView.getSettings().setJavaScriptEnabled(true); // Enable Javascript for webpage manipulation.
    }
}
