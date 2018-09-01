package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.GouWuEntity;
import com.squareup.picasso.Picasso;

/**
 * Created by 天一 on 2017/5/18.
 */

public class GouWuDanLVAdapter extends MBaseAdapter<GouWuEntity> {
    private Context context;
    public GouWuDanLVAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = getInflater().inflate(R.layout.item_gouwudan_listview,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(getItem(position).getImagurl()).into(viewHolder.imageView);
        viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.imageView.requestLayout();
        viewHolder.title.setText(getItem(position).getTitle());
        viewHolder.price.setText(getItem(position).getPrice());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView price;
        public ViewHolder(View convertView){
            imageView = (ImageView) convertView.findViewById(R.id.item_gouwudan_listview_imageViewId);
            title = (TextView) convertView.findViewById(R.id.item_gouwudan_listview_titleId);
            price = (TextView) convertView.findViewById(R.id.item_gouwudan_listview_priceId);
        }
    }
}
