package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Administrator on 2016/10/24.
 */

public class PhotoAdapter extends MBaseAdapter<String> {

    private Context context;

    public PhotoAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = getInflater().inflate(R.layout.item_photo,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = ((ViewHolder) convertView.getTag());
        }
        //设置内容

        String item = getItem(position);

        viewHolder.textView.setText(item.substring(item.lastIndexOf("/")+1));
        Picasso.with(context).load(new File(item)).into(viewHolder.imageView);
//        Glide.with(context).load(new File(item)).into(viewHolder.imageView);

        return convertView;
    }
    class ViewHolder
    {
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(View convertView)
        {
            textView = ((TextView) convertView.findViewById(R.id.item_photo_textViewId));
            imageView = ((ImageView) convertView.findViewById(R.id.item_photo_imageViewId));
        }
    }
}
