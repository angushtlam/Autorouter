package org.phonelab.autorouter.web;

import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by anguslam on 7/15/16.
 */
public class AutorouterWebViewClient extends WebViewClient {
    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        // TODO: Switch to a different IP address if the router's page cannot be found yet.
        super.onReceivedHttpError(view, request, errorResponse);
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        // TODO: Attempt login to router.
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
    }
}
