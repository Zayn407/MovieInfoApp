package edu.uic.cs478.s2024.project2;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, android.webkit.WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString());
        return true;
    }

}
