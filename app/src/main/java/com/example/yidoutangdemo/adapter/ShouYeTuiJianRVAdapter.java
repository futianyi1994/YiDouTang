package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.ShouYeEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 天一 on 2016/10/31.
 */
public class ShouYeTuiJianRVAdapter extends RecyclerView.Adapter{
    private List<ShouYeEntity.DataBean.PicsBean> datas;
    private LayoutInflater inflater;
    private Context context;
    private String url;


    private itemOnClick itemOnClick;

    public void setItemOnClick(ShouYeTuiJianRVAdapter.itemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public ShouYeTuiJianRVAdapter(Context context) {
        this.datas = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(inflater.inflate(R.layout.item_shouyetuijian,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        Picasso.with(context).load(datas.get(position).getNormal_image()).into(viewHolder.imageView);
        viewHolder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        viewHolder.imageView.requestLayout();
        viewHolder.textView.setText(datas.get(position).getCase_title());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_imageViewId);
            textView = (TextView) itemView.findViewById(R.id.item_textViewId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClick.onClick(url,getLayoutPosition(),datas.get(getLayoutPosition()).getNormal_image());
                }
            });
        }
    }

    public ShouYeEntity.DataBean.PicsBean getMItem(int i){
        return datas.get(i);
    }

    public interface itemOnClick{
        void onClick(String url, int position, String normal_image);
    }

    /**
     * 添加一个url
     * @param s
     */
    public void addUrl(String s){
        url = s;
    }

    /**
     * 添加一个集合
     * @param dd
     */
    public void addAll(List<ShouYeEntity.DataBean.PicsBean> dd)
    {
        datas.addAll(dd);
        notifyDataSetChanged();
    }


    /**
     * 清空数据源
     */
    public void clear()
    {
        datas.clear();
        notifyDataSetChanged();
    }
}
