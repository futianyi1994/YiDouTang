package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 天一 on 2016/11/2.
 */
public abstract class MBaseAdapter<T> extends BaseAdapter {
    private List<T> datas;
    private LayoutInflater inflater;
    public LayoutInflater getInflater() {
        return inflater;
    }

    public MBaseAdapter(Context context) {
        this.datas = new ArrayList<T>();
        this.inflater = LayoutInflater.from(context);
    }

    public List<T> getDatas() {
        return datas;
    }

    @Override
    public int getCount() {
        return datas.size();

    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 添加一个集合
     * @param dd
     */
    public void addAll(List<T> dd)
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
