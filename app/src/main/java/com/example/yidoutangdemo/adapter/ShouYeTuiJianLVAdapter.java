package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.ShouYeEntity;
import com.example.yidoutangdemo.utils.DateUtils;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by 天一 on 2016/11/1.
 */
public class ShouYeTuiJianLVAdapter extends MBaseAdapter<ShouYeEntity.DataBean.PicsBean>{
    private Context context;
    public ShouYeTuiJianLVAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = getInflater().inflate(R.layout.item_shouyetuijian_listview,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(getItem(position).getNormal_image()).into(viewHolder.imageView);
        ViewGroup.LayoutParams params = viewHolder.imageView.getLayoutParams();
        params.width = 1100;
        params.height = 1100*getItem(position).getData().getInfo().getImg_h()/getItem(position).getData().getInfo().getImg_w();
        viewHolder.imageView.setLayoutParams(params);
        viewHolder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        viewHolder.imageView.requestLayout();
        Picasso.with(context).load(getItem(position).getUser_pic()).transform(new CropCircleTransformation()).into(viewHolder.user_pic);

        viewHolder.user_name.setText(getItem(position).getUser_name());
        viewHolder.created.setText(DateUtils.timesOne(getItem(position).getCreated()+""));
        viewHolder.textView.setText(getItem(position).getCase_title());
        return convertView;
    }

    class ViewHolder{
        ImageView imageView,user_pic;
        TextView textView,created,user_name;
        public ViewHolder(View convertView){
            imageView = (ImageView) convertView.findViewById(R.id.item_listview_imageViewId);
            user_pic = (ImageView) convertView.findViewById(R.id.item_listview_user_pic);
            created = (TextView) convertView.findViewById(R.id.item_listview_created);
            user_name = (TextView) convertView.findViewById(R.id.item_listview_user_name);
            textView = (TextView) convertView.findViewById(R.id.item_listview_textViewId);
        }
    }
}
