package org.phonelab.autorouter.web;

import android.content.Intent;
import android.webkit.WebView;
import android.widget.Toast;

import org.phonelab.autorouter.ConfigureActivity;
import org.phonelab.autorouter.MainActivity;
import org.phonelab.autorouter.R;
import org.phonelab.autorouter.util.ARState;

/**
 * Created by anguslam on 7/15/16.
 */
public class Autorouter {
    private ConfigureActivity _context;
    private WebView _webView;
    private RouterAddressManager _addressMng;
    private RouterLoginManager _loginMng;

    private ARState state;

    public Autorouter(ConfigureActivity context) {
        _context = context;

        // Sets up the WebView with necessary settings.
        _webView = (WebView) (context.findViewById(R.id.webView));
        _webView.setWebViewClient(new ARWebViewClient(this)); // Handles HTTP-Authentication that most routers implement
        _webView.getSettings().setJavaScriptEnabled(true); // Enable Javascript for webpage manipulation.

        _addressMng = new RouterAddressManager();
        _loginMng = new RouterLoginManager();

        state = ARState.READY;
    }

    public void step() {
        switch (state) {
            case READY:
                state = ARState.ROUTER_ENTER_ADDRESS;
                step();

            case ROUTER_ENTER_ADDRESS:
                routerEnterAddress();

            case ROUTER_SEARCHING_SETTINGS:
                injectjQuery();

            case ROUTER_CONFIGURE:

            case COMPLETE:
        }
    }

    public void routerEnterAddress() {
        _webView.loadUrl(_addressMng.getNextAddress());
        // The WebViewClient will move Autorouter to the next step when the page is done loading.
    }

    public void injectjQuery() {
        _webView.loadUrl("javascript:(function(){var%20el=document.createElement(%22div%22),b=document.getElementsByTagName(%22body%22)[0],otherlib=!1,msg=%22%22;el.style.position=%22fixed%22,el.style.height=%2232px%22,el.style.width=%22220px%22,el.style.marginLeft=%22-110px%22,el.style.top=%220%22,el.style.left=%2250%25%22,el.style.padding=%225px%2010px%22,el.style.zIndex=1001,el.style.fontSize=%2212px%22,el.style.color=%22#222%22,el.style.backgroundColor=%22#f99%22;function%20showMsg(){var%20txt=document.createTextNode(msg);el.appendChild(txt),b.appendChild(el),window.setTimeout(function(){txt=null,typeof%20jQuery==%22undefined%22?b.removeChild(el):(jQuery(el).fadeOut(%22slow%22,function(){jQuery(this).remove()}),otherlib&&(window.$jq=jQuery.noConflict()))},2500)}if(typeof%20jQuery!=%22undefined%22)return%20msg=%22This%20page%20already%20using%20jQuery%20v%22+jQuery.fn.jquery,showMsg();typeof%20$==%22function%22&&(otherlib=!0);function%20getScript(url,success){var%20script=document.createElement(%22script%22);script.src=url;var%20head=document.getElementsByTagName(%22head%22)[0],done=!1;script.onload=script.onreadystatechange=function(){!done&&(!this.readyState||this.readyState==%22loaded%22||this.readyState==%22complete%22)&&(done=!0,success(),script.onload=script.onreadystatechange=null,head.removeChild(script))},head.appendChild(script)}getScript(%22//code.jquery.com/jquery.min.js%22,function(){return%20typeof%20jQuery==%22undefined%22?msg=%22Sorry,%20but%20jQuery%20was%20not%20able%20to%20load%22:(msg=%22This%20page%20is%20now%20jQuerified%20with%20v%22+jQuery.fn.jquery,otherlib&&(msg+=%22%20and%20noConflict().%20Use%20$jq(),%20not%20$().%22)),showMsg()})})();");
        _webView.loadUrl("javascript:$('tr').remove()");
        _webView.loadUrl("javascript:$('table').remove()");

        Toast msg = Toast.makeText(this.getContext(), "Loading JQuery", Toast.LENGTH_LONG);
        msg.show();
    }

    /**
     * Ends the Autorouter with an error.
     */
    public void errorWithAutoConfig() {
        Intent intent = new Intent(_context, MainActivity.class);
        _context.startActivity(intent);
    }

    public RouterAddressManager getRouterAddressManager() {
        return _addressMng;
    }

    public RouterLoginManager getRouterLoginManager() {
        return _loginMng;
    }

    public ConfigureActivity getContext() {
        return _context;
    }

    public ARState getState() {
        return state;
    }

    public void setState(ARState state) {
        this.state = state;
    }
}
