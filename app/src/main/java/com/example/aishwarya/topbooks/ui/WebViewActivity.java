package com.example.aishwarya.topbooks.ui;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.aishwarya.topbooks.Constants;
import com.example.aishwarya.topbooks.R;
import com.example.aishwarya.topbooks.Utils.DialogUtils;
import com.example.aishwarya.topbooks.common.BaseActivity;

public class WebViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        setStatusBarColor(this);
        loadBookUrlIntoWebView();
    }

    private void loadBookUrlIntoWebView() {
        WebView webView = (WebView) findViewById(R.id.web_view);
        if (getIntent() != null) {
            String url = getIntent().getStringExtra(Constants.BOOK_URL);
            DialogUtils.showProgressDialog(WebViewActivity.this, getString(R.string.loading));
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    DialogUtils.dismissProgressDialog();
                }
            });
            webView.loadUrl(url);
        }
    }
}
