package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.ShaiXuanEntity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * Created by 天一 on 2016/11/1.
 */
public class FlowLayoutAdapter extends TagAdapter<ShaiXuanEntity.DataBean.TagsBean.SonTagsBean> {
    private Context context;
    private LayoutInflater inflater;
    private TagFlowLayout flowLayout;

    public FlowLayoutAdapter(List<ShaiXuanEntity.DataBean.TagsBean.SonTagsBean> datas) {
        super(datas);
    }

    public FlowLayoutAdapter(List<ShaiXuanEntity.DataBean.TagsBean.SonTagsBean> datas, Context context, TagFlowLayout flowLayout) {
        super(datas);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.flowLayout = flowLayout;

    }

    @Override
    public View getView(FlowLayout parent, int position, ShaiXuanEntity.DataBean.TagsBean.SonTagsBean sonTagsBean) {
        TextView textView = (TextView) inflater.inflate(R.layout.flowlayouttextiew,flowLayout,false);
        textView.setText(sonTagsBean.getTitle());
        return textView;
    }
}
