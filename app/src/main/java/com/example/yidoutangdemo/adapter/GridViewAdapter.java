package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.JianHuoEntity;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by 天一 on 2016/11/1.
 */
public class GridViewAdapter extends MBaseAdapter<JianHuoEntity.DataBean.RecommendTagBean> {
    private Context context;
    public GridViewAdapter(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=getInflater().inflate(R.layout.item_jianhuo_header,viewGroup,false);
        TextView textView= (TextView) view.findViewById(R.id.item_jianhuo_textView);
        ImageView imageView= (ImageView) view.findViewById(R.id.item_jianhuo_header_img);

        if (getItem(i).getTitle()!=null) {
            textView.setText(getItem(i).getTitle());
        }else
        {
            textView.setText("更多");
        }
        /*if (getItem(i).getData()!=null&&getItem(i).getData().getClassX()!=null) {
            Log.d("test", getItem(i).getData().getClassX());
        }*/
        Picasso.with(context).load(getItem(i).getIcon()).transform(new CropCircleTransformation()).into(imageView);

        return view;
    }
}
