package com.adrian.own.learn;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created with Android Studio.
 * Authour：qifo
 * Date：2018/2/23 08:59
 * Des：
 */
public class MainAdapter extends BaseQuickAdapter<MainItem,BaseViewHolder> {


    public MainAdapter() {
        super(R.layout.main_item_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainItem item) {
        helper.setText(R.id.text, item.getTitle());
        //helper.setImageResource(R.id.icon, item.getImageResource());
    }
}
