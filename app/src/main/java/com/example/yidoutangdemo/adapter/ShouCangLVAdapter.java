package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.ShouCangEntity;
import com.squareup.picasso.Picasso;

/**
 * Created by 天一 on 2017/5/17.
 */

public class ShouCangLVAdapter extends MBaseAdapter<ShouCangEntity> {
    private Context context;
    public ShouCangLVAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = getInflater().inflate(R.layout.item_shoucang_listview,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(getItem(position).getImagurl()).into(viewHolder.imageView);
        viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.imageView.requestLayout();
        viewHolder.textView.setText(getItem(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(View convertView){
            imageView = (ImageView) convertView.findViewById(R.id.item_shoucang_listview_imageViewId);
            textView = (TextView) convertView.findViewById(R.id.item_shoucang_listview_textViewId);
        }
    }
}
