package com.adrian.own.learn.function.supertextview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adrian.own.learn.R;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio.
 * Authour：qifo
 * Date：2018/2/24 17:35
 * Des：列表中使用
 */
public class ListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsAdapter adapter;
    private List<NewsBean> newsBeanList = new ArrayList<>();

    private ImageView mIvBack;
    private TextView mTvTitle;
    private String[] url = new String[]{
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1580482776,3214289843&fm=80&w=179&h=119&img.JPEG",
            "https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/vip/whcrop%3D176%2C106/sign=cffe5aed6363f6241c086f41e834d6c9/f3d3572c11dfa9ecb7f287c36ad0f703908fc102.jpg",
            "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1383170885,2038374031&fm=80&w=179&h=119&img.JPEG",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2218526845,522933158&fm=80&w=179&h=119&img.JPEG",
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=775731846,1370921386&fm=80",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG",
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=4096069947,473932952&fm=80&w=179&h=119&img.JPEG",
            "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3244336274,3651700434&fm=80&w=179&h=119&img.JPEG",
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=219781665,3032880226&fm=80&w=179&h=119&img.JPEG",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=831306574,2792494868&fm=80&w=179&h=119&img.GIF",

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_list);

        mIvBack = findViewById(R.id.head_iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListActivity.this.finish();
            }
        });
        mTvTitle = findViewById(R.id.head_tv_title);
        mTvTitle.setText("SuperTexView列表使用方式");

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new NewsAdapter(this, getData());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(ListActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private List<NewsBean> getData() {
        for (int i = 0; i < 10; i++) {
            NewsBean newsBean = new NewsBean();
            newsBean.setImgUrl(url[i]);
            newsBean.setTitle("新闻标题" + i);
            newsBean.setTime("哈佛有嘻哈教你如何用一个freestyle轻松毕业" + i);
            newsBeanList.add(newsBean);
        }
        return newsBeanList;
    }

    private List<NewsBean> getRefreshData() {
        for (int i = 0; i < 10; i++) {
            NewsBean newsBean = new NewsBean();
            newsBean.setImgUrl(url[i]);
            newsBean.setTitle("新标" + i);
            newsBean.setTime("哈佛有嘻哈教你如何用" + i);
            newsBeanList.add(newsBean);
        }
        return newsBeanList;
    }

    @Override
    public void onRefresh() {
        getRefreshData();
        adapter.notifyDataSetChanged();

        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}

