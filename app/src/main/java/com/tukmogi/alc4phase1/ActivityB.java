package com.tukmogi.alc4phase1;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityB extends BaseActivity {

    @BindView(R.id.wv_about)
    WebView myWebView;

    @BindView(R.id.progressView)
    View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);

        removeActionBarElevation();
        // changeActionBarFont();

        // Set up loading snackBar
        Snackbar snackbar = Snackbar.make(mProgressView, R.string.loading,
                                          Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
        myWebView.setWebViewClient(new WebViewClient() {
            // Handle SSL error
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // dismiss snackBar and progressBar after page has loaded
                mProgressView.setVisibility(View.GONE);
                snackbar.dismiss();
            }
        });
        myWebView.loadUrl("https://andela.com/alc/");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
