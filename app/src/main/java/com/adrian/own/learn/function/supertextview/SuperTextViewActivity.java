package com.adrian.own.learn.function.supertextview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adrian.own.learn.MainItem;
import com.adrian.own.learn.R;
import com.adrian.own.learn.common.webview.BrowserActivity;

/**
 * Created with Android Studio.
 * Authour：qifo
 * Date：2018/2/24 15:33
 * Des：
 */
public class SuperTextViewActivity extends AppCompatActivity implements View.OnClickListener {


    private MainItem mainItem;
    private ImageView mIvBack;
    private TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_text_view);

        mainItem = getIntent().getParcelableExtra("extra");

        mIvBack = findViewById(R.id.head_iv_back);
        mIvBack.setOnClickListener(this);
        mTvTitle = findViewById(R.id.head_tv_title);
        mTvTitle.setText("SuperTextView");
        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.list_button).setOnClickListener(this);
        findViewById(R.id.click_button).setOnClickListener(this);
        findViewById(R.id.super_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        int viewId = v.getId();
        switch (viewId) {
            case R.id.button0:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
                break;
            case R.id.button1:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
                break;
            case R.id.button2:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 2);
                startActivity(intent);
                break;
            case R.id.button3:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 3);
                startActivity(intent);
                break;
            case R.id.button4:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 4);
                startActivity(intent);
                break;
            case R.id.button5:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 5);
                startActivity(intent);
                break;
            case R.id.button6:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 6);
                startActivity(intent);
                break;
            case R.id.button7:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 7);
                startActivity(intent);
                break;
            case R.id.button8:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 8);
                startActivity(intent);
                break;
            case R.id.button9:
                intent.setClass(this, BrowserActivity.class);
                intent.putExtra("extra", mainItem);
                startActivity(intent);
                break;
            case R.id.list_button:
                intent.setClass(this, ListActivity.class);
                startActivity(intent);
                break;
            case R.id.click_button:
                intent.setClass(this, ClickActivity.class);
                startActivity(intent);
                break;
            case R.id.super_button:
                intent.setClass(this, SuperButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.head_iv_back:
                this.finish();
                break;
        }
    }
}
