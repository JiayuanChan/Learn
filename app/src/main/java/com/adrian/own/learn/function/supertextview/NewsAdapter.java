package com.adrian.own.learn.function.supertextview;

import android.content.Context;

import com.adrian.library.widget.superView.SuperTextView;
import com.adrian.own.learn.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created with Android Studio.
 * Authour：qifo
 * Date：2018/2/24 17:36
 * Des：
 */
public class NewsAdapter extends BaseQuickAdapter<NewsBean,BaseViewHolder> {
    private Context mContext;

    public NewsAdapter(Context context,List<NewsBean> datas) {
        super(R.layout.super_item_view,datas);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsBean item) {
        ((SuperTextView) helper.getView(R.id.super_tv)).setLeftTopString(item.getTitle()).setLeftBottomString(item.getTime());
        Picasso.with(mContext).load(item.getImgUrl()).placeholder(R.drawable.super_head_default
        ).into(((SuperTextView) helper.getView(R.id.super_tv))
                .getLeftIconIV());
    }
}

