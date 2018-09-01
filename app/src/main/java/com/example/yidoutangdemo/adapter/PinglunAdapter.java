package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.PingLunEntity;
import com.example.yidoutangdemo.utils.DateUtils;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by 天一 on 2016/11/2.
 */
public class PinglunAdapter extends MBaseAdapter<PingLunEntity.DataBean.CommentsBean> {
    private Context context;

    public PinglunAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if (convertView == null){
            convertView = getInflater().inflate(R.layout.item_activity_pinglun,parent,false);
            viewholder = new Viewholder(convertView);
            convertView.setTag(viewholder);
        }else {
            viewholder = (Viewholder) convertView.getTag();
        }
        PingLunEntity.DataBean.CommentsBean item = getItem(position);
        Picasso.with(context).load(item.getUser_pic()).transform(new CropCircleTransformation()).into(viewholder.imageView);
        viewholder.user_name_tv.setText(item.getUser_name());
        viewholder.created_tv.setText(DateUtils.timesOne(item.getCreated()));
        viewholder.content_tv.setText(item.getContent());
        if (item.getQuote_content()!=null){
            viewholder.quote_content_tv.setText("回复"+item.getQuote_author()+":"+item.getQuote_content());
        }else {
            viewholder.linearLayout.setVisibility(View.GONE);
        }
        return convertView;
    }

    class Viewholder{
        ImageView imageView;
        TextView user_name_tv,created_tv,quote_content_tv,content_tv;
        LinearLayout linearLayout;
        public Viewholder(View convertView){
            imageView = (ImageView) convertView.findViewById(R.id.item_activity_pinglun_imageviewId);
            user_name_tv = (TextView) convertView.findViewById(R.id.item_activity_pinglun_user_name);
            created_tv = (TextView) convertView.findViewById(R.id.item_activity_pinglun_created);
            quote_content_tv = (TextView) convertView.findViewById(R.id.item_activity_pinglun_quote_content);
            content_tv = (TextView) convertView.findViewById(R.id.item_activity_pinglun_content);
            linearLayout = (LinearLayout) convertView.findViewById(R.id.item_activity_pinglun_LinearLayoutId);
        }
    }
}
