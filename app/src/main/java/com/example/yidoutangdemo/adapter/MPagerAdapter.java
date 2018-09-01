package com.example.yidoutangdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 天一 on 2016/11/2.
 */
public class MPagerAdapter extends PagerAdapter {

    private List<View> views;

    public MPagerAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position%views.size()));
        return views.get(position%views.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(views.get(position%views.size()));
    }
}
