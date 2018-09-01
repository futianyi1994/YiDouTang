package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.GengDuoEntity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * Created by 天一 on 2016/11/6.
 */
public class GengDuoFlowLayoutAdapter extends TagAdapter<GengDuoEntity.DataBean.TagsBean> {
    private Context context;
    private LayoutInflater inflater;
    private TagFlowLayout flowLayout;

    public GengDuoFlowLayoutAdapter(List<GengDuoEntity.DataBean.TagsBean> datas) {
        super(datas);
    }

    public GengDuoFlowLayoutAdapter(List<GengDuoEntity.DataBean.TagsBean> datas, Context context, TagFlowLayout flowLayout) {
        super(datas);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.flowLayout = flowLayout;
    }

    @Override
    public View getView(FlowLayout parent, int position, GengDuoEntity.DataBean.TagsBean tagsBean) {
        TextView textView = (TextView) inflater.inflate(R.layout.flowlayouttextiew,flowLayout,false);
        textView.setText(tagsBean.getName());
        return textView;
    }
}
