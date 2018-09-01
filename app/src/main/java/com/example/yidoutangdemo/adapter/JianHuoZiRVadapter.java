package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.JianHuoZiEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by 天一 on 2016/11/2.
 */
public class JianHuoZiRVadapter extends RecyclerView.Adapter {
    List<JianHuoZiEntity.DataBean.GuidesBean> datas;
    LayoutInflater inflater;
    Context context;

    public JianHuoZiRVadapter(Context context) {
        this.datas = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_jianhuozi,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.userName.setText(datas.get(position).getAuthor());
        viewHolder.mainTextView.setText(datas.get(position).getSubject());
        //Log.d("1606",datas.get(position).getTitle()+"");
        viewHolder.sharingnum.setText(datas.get(position).getSharings()+"");
        viewHolder.clicknum.setText(datas.get(position).getViews()+"");

        Picasso.with(context).load(datas.get(position).getHeader_image()).into(viewHolder.mainImg);
        Picasso.with(context).load(datas.get(position).getUser_pic()).transform(new CropCircleTransformation()).into(viewHolder.userpic);

    }

    @Override
    public int getItemCount() {
        return datas.size();

    }

    public void addAll(List<JianHuoZiEntity.DataBean.GuidesBean> dd) {
        Log.d("1606",dd+"");
        datas.addAll(dd);
        Log.d("1606",datas+"");
        notifyDataSetChanged();
    }

    public JianHuoZiEntity.DataBean.GuidesBean getItem(int position) {
        return datas.get(position);
    }

    public void clear() {
        datas.clear();
        notifyDataSetChanged();

    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mainImg;
        private ImageView userpic;
        private TextView userName;
        private TextView clicknum;
        private TextView sharingnum;
        private TextView mainTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mainImg= (ImageView) itemView.findViewById(R.id.item_jianhuozi_img);
            userpic= (ImageView) itemView.findViewById(R.id.item_jianhuozi_userpic);
            userName= (TextView) itemView.findViewById(R.id.item_jianhuozi_username);
            clicknum= (TextView) itemView.findViewById(R.id.item_jianhuozi_clicknum);
            sharingnum= (TextView) itemView.findViewById(R.id.item_jianhuozi_sharingnum);
            mainTextView= (TextView) itemView.findViewById(R.id.item_jianhuozi_title);
        }
    }

}
