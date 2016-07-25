package org.phonelab.autorouter.web;

import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.phonelab.autorouter.util.ARState;

/**
 * Created by anguslam on 7/15/16.
 */
public class ARWebViewClient extends WebViewClient {
    private Autorouter _autorouter;

    public ARWebViewClient(Autorouter ar) {
        _autorouter = ar;
    }

    /**
     * Makes the authentication into the router.
     */
    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        if (_autorouter.getState() == ARState.ROUTER_ENTER_ADDRESS) {
            String username = _autorouter.getRouterLoginManager().getNextUsername();
            String password = _autorouter.getRouterLoginManager().getNextPassword();

            if (username == null || password == null) {
                _autorouter.errorWithAutoConfig();
                handler.cancel();
            }

            handler.proceed(username, password);
        }
    }

    /**
     * Responsible in checking if a page is finished loading.
     */
    @Override
    public void onPageFinished(WebView view, String url) {
        if (_autorouter.getState() == ARState.ROUTER_ENTER_ADDRESS) {
            _autorouter.setState(ARState.ROUTER_SEARCHING_SETTINGS);
            _autorouter.step();
        }
    }

    /**
     * Check if the page loaded up correctly.
     */
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        // TODO: Switch to a different IP address if the router's page cannot be found yet.
        Toast msg = Toast.makeText(_autorouter.getContext(), "Page has error.", Toast.LENGTH_LONG);
        msg.show();
        super.onReceivedError(view, request, error);
    }
}
