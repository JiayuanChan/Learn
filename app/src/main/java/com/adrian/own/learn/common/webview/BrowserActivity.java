package com.adrian.own.learn.common.webview;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.adrian.own.learn.MainItem;
import com.adrian.own.learn.R;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created with Android Studio.
 * Authour：qifo
 * Date：2018/2/23 15:49
 * Des：
 */
public class BrowserActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;
    private TextView mTvTitle;
    private X5WebView mWebView;
    private ProgressBar mLoadingProgressBar;
    private MainItem extraData;
    private ImageButton mBack;
    private ImageButton mForward;
    private ImageButton mMore;
    private ImageButton mHome;


    private final int disable = 120;
    private final int enable = 255;
    private String mHomeUrl = "https://www.baidu.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initView();
        initData();
    }

    private void initData() {
        extraData = getIntent().getParcelableExtra("extra");
        if (extraData != null && !TextUtils.isEmpty(extraData.getLink())) {
            mHomeUrl = extraData.getLink();
        }
        mWebView.loadUrl(mHomeUrl);
    }

    private void initView() {
        mIvBack = findViewById(R.id.head_iv_back);
        mIvBack.setOnClickListener(this);
        mTvTitle = findViewById(R.id.head_tv_title);
        mLoadingProgressBar = findViewById(R.id.progressBar);
        mWebView = findViewById(R.id.x5_webview);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    changGoForwardButton(webView);
                }
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                mTvTitle.setText(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mLoadingProgressBar.setProgress(newProgress);
                if (mLoadingProgressBar != null && newProgress != 100) {
                    mLoadingProgressBar.setVisibility(View.VISIBLE);
                } else if (mLoadingProgressBar != null) {
                    mLoadingProgressBar.setVisibility(View.GONE);
                }
            }
        });
        mBack = findViewById(R.id.btnBack);
        mForward = findViewById(R.id.btnForward);
        mMore = findViewById(R.id.btnMore);
        mHome = findViewById(R.id.btnHome);
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 16) {
            mBack.setAlpha(disable);
            mForward.setAlpha(disable);
            mHome.setAlpha(disable);
        }
        mHome.setEnabled(false);
        mBack.setOnClickListener(this);
        mForward.setOnClickListener(this);
        mMore.setOnClickListener(this);
        mHome.setOnClickListener(this);
    }

    private void changGoForwardButton(WebView view) {
        if (view.canGoBack()) {
            mBack.setAlpha(enable);
        } else {
            mBack.setAlpha(disable);
        }
        if (view.canGoForward()) {
            mForward.setAlpha(enable);
        } else {
            mForward.setAlpha(disable);
        }
        if (view.getUrl() != null && view.getUrl().equalsIgnoreCase(mHomeUrl)) {
            mHome.setAlpha(disable);
            mHome.setEnabled(false);
        } else {
            mHome.setAlpha(enable);
            mHome.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.head_iv_back:
                this.finish();
                break;
            case R.id.btnBack:
                if (mWebView != null && mWebView.canGoBack()) {
                    mWebView.goBack();
                }
                break;
            case R.id.btnForward:
                if (mWebView != null && mWebView.canGoForward()) {
                    mWebView.goForward();
                }
                break;
            case R.id.btnMore:
                Toast.makeText(BrowserActivity.this, "not completed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnHome:
                if (mWebView != null) {
                    mWebView.loadUrl(mHomeUrl);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView != null && mWebView.canGoBack()) {
                mWebView.goBack();
                if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 16)
                    changGoForwardButton(mWebView);
                return true;
            } else
                return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }
}
