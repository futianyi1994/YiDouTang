package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.GengDuoEntity;
import com.squareup.picasso.Picasso;

/**
 * Created by 天一 on 2016/11/6.
 */
public class GengDuoGridViewAdapter extends MBaseAdapter<GengDuoEntity.DataBean.TagsBean> {
    private Context context;
    public GengDuoGridViewAdapter(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=getInflater().inflate(R.layout.item_gengduo,viewGroup,false);
        TextView textView= (TextView) view.findViewById(R.id.item_gengduo_tv);
        ImageView imageView= (ImageView) view.findViewById(R.id.item_gengduo_img);
        textView.setText(getItem(i).getName());
        Picasso.with(context).load(getItem(i).getIcon()).into(imageView);
        return view;
    }
}
