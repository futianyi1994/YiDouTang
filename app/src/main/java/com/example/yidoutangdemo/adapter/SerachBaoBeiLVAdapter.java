package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.SerachBaoBeiEntity;
import com.squareup.picasso.Picasso;

/**
 * Created by 天一 on 2017/5/18.
 */

public class SerachBaoBeiLVAdapter extends MBaseAdapter<SerachBaoBeiEntity.DataBean.SharingsBean> {
    private Context context;
    public SerachBaoBeiLVAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = getInflater().inflate(R.layout.item_serach_baobei,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(getItem(position).getTitle());
        viewHolder.price.setText("¥  "+getItem(position).getPrice());
        Picasso.with(context).load(getItem(position).getNormal_image()).into(viewHolder.mainImg);
        return convertView;
    }
    class ViewHolder{
        private ImageView mainImg;
        private TextView title;
        private TextView price;
        public ViewHolder(View convertView) {
            mainImg= (ImageView) convertView.findViewById(R.id.item_serach_baobei_img);
            title= (TextView) convertView.findViewById(R.id.item_serach_baobei_tvmain);
            price= (TextView) convertView.findViewById(R.id.item_serach_baobei_jiage);
        }
    }
}
