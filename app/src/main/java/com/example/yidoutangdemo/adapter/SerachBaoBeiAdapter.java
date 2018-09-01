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
import com.example.yidoutangdemo.bean.SerachBaoBeiEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 天一 on 2016/11/3.
 */
public class SerachBaoBeiAdapter extends RecyclerView.Adapter<SerachBaoBeiAdapter.ViewHolder> {
    List<SerachBaoBeiEntity.DataBean.SharingsBean> datas;
    LayoutInflater inflater;
    Context context;

    private OnItemClickListener onItemClickListener;

    public SerachBaoBeiAdapter(Context context) {
        this.datas = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_serach_baobei,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(datas.get(position).getTitle());
        holder.price.setText("¥  "+datas.get(position).getPrice());
        Picasso.with(context).load(datas.get(position).getNormal_image()).into(holder.mainImg);
    }

    @Override
    public int getItemCount() {
        return datas.size();

    }

    public void addAll(List<SerachBaoBeiEntity.DataBean.SharingsBean> dd) {
        Log.d("1606",dd+"");
        datas.addAll(dd);
        Log.d("1606",datas+"");
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mainImg;
        private TextView title;
        private TextView price;
        public ViewHolder(View itemView) {
            super(itemView);
            mainImg= (ImageView) itemView.findViewById(R.id.item_serach_baobei_img);
            title= (TextView) itemView.findViewById(R.id.item_serach_baobei_tvmain);
            price= (TextView) itemView.findViewById(R.id.item_serach_baobei_jiage);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(onItemClickListener!=null)
                    {
                        onItemClickListener.onItemClick(v,getLayoutPosition());
                    }
                    return false;
                }
            });
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener!=null)
                    {
                        onItemClickListener.onItemClick(v,getLayoutPosition());
                    }
                }
            });*/
        }
    }
    public interface OnItemClickListener{
        public void onItemClick(View itemView,int position);
    }

}

