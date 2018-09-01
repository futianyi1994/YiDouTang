package com.example.yidoutangdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yidoutangdemo.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 天一 on 2016/11/3.
 */
public class SerachTabPagerAdapter extends FragmentPagerAdapter {
    String[] title={"晒家","宝贝","荐货"};
    List<BaseFragment> list;
    public SerachTabPagerAdapter(FragmentManager fm,List<BaseFragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
