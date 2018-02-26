package com.adrian.own.learn.function.supertextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.adrian.library.widget.superView.SuperTextView;
import com.adrian.own.learn.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.squareup.picasso.Picasso;

/**
 * Created with Android Studio.
 * Authour：qifo
 * Date：2018/2/24 15:44
 * Des：
 */
public class TypeActivity extends AppCompatActivity {
    private int type;
    private SuperTextView superTextView, superTextView2, superTextView3, alipayStv, superTextView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getIntExtra("type", 0);
        switch (type) {
            case 0:
                setContentView(R.layout.activity_super_main);
                break;
            case 1:
                setContentView(R.layout.activity_super_layout1);
                break;
            case 2:
                setContentView(R.layout.activity_super_layout2);
                break;
            case 3:
                setContentView(R.layout.activity_super_layout3);
                break;
            case 4:
                setContentView(R.layout.activity_super_layout4);
                break;
            case 5:
                setContentView(R.layout.activity_super_layout5);
                setData();
                break;
            case 6:
                setContentView(R.layout.activity_super_layout6);
                superTextView4 = (SuperTextView) findViewById(R.id.super_tv4);
                superTextView4.setCenterTextGravity(Gravity.LEFT);

                break;
            case 7:
                setContentView(R.layout.activity_super_layout7);
                break;
            case 8:
                setContentView(R.layout.activity_super_layout8);
                break;

        }

    }

    private void setData() {
        superTextView = (SuperTextView) findViewById(R.id.super_tv1);
        superTextView2 = (SuperTextView) findViewById(R.id.super_tv2);
        superTextView3 = (SuperTextView) findViewById(R.id.super_tv3);
        alipayStv = (SuperTextView) findViewById(R.id.alipay_stv);

        String url1 = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG";
        String url2 = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=219781665,3032880226&fm=80&w=179&h=119&img.JPEG";
        String url3 = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG";
        String url4 = "http://osnoex6vf.bkt.clouddn.com/original_label.png";

        Picasso.with(this)
                .load(url1)
                .placeholder(R.drawable.super_head_default)
                .into(superTextView.getLeftIconIV());
        Glide.with(this)
                .load(url2)
                .placeholder(R.drawable.super_head_default)
                .fitCenter()
                .into(superTextView2.getRightIconIV());

        Glide.with(this)
                .load(url3)
                .placeholder(R.drawable.super_head_default)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        superTextView3.setRightTvDrawableRight(resource);
                    }
                });

        Glide.with(this)
                .load(url4)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        alipayStv.setLeftTvDrawableRight(resource);
                    }
                });
    }

}
