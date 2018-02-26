package com.adrian.own.learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.adrian.own.learn.common.webview.BrowserActivity;
import com.adrian.own.learn.function.supertextview.TypeActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //private static final Class<?>[] ACTIVITY = {AnimationUseActivity.class, MultipleItemUseActivity.class, HeaderAndFooterUseActivity.class, PullToRefreshUseActivity.class, SectionUseActivity.class, EmptyViewUseActivity.class, ItemDragAndSwipeUseActivity.class, ItemClickActivity.class, ExpandableUseActivity.class, DataBindingUseActivity.class,UpFetchUseActivity.class};
    //private static final String[] TITLE = {"Animation", "MultipleItem", "Header/Footer", "PullToRefresh", "Section", "EmptyView", "DragAndSwipe", "ItemClick", "ExpandableItem", "DataBinding", "UpFetchData"};
    //private static final int[] IMG = {R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh, R.mipmap.gv_section, R.mipmap.gv_empty, R.mipmap.gv_drag_and_swipe, R.mipmap.gv_item_click, R.mipmap.gv_expandable, R.mipmap.gv_databinding,R.drawable.gv_up_fetch};
    private ArrayList<MainItem> mDataList;

    private RecyclerView mRecyclerView;
    private BaseQuickAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
        initData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void initAdapter() {
        mainAdapter = new MainAdapter();
        mainAdapter.openLoadAnimation();
        //View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        //mainAdapterv.addHeaderView(top);
        mainAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MainItem mainItem = mDataList.get(position);
                Intent intent = new Intent();
                intent.putExtra("extra", mainItem);
                if (mainItem.getActivity() != null) {
                    intent.setClass(MainActivity.this,mainItem.getActivity());
                } else {
                    intent.setClass(MainActivity.this,BrowserActivity.class);
                }
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mainAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        String[] title = getResources().getStringArray(R.array.category);
        String[] links = getResources().getStringArray(R.array.link);
        String[] activitys = getResources().getStringArray(R.array.activity);
        int count = title.length;
        for (int i = 0; i < count; i++) {
            MainItem item = new MainItem();
            item.setTitle(title[i]);
            item.setLink(links[i]);
            item.setClassName(activitys[i]);
            //item.setActivity(ACTIVITY[i]);
            //item.setImageResource(IMG[i]);
            mDataList.add(item);
        }
        mainAdapter.setNewData(mDataList);
    }

}
