package com.example.yidoutangdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yidoutangdemo.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 天一 on 2016/10/31.
 */
public class TuiJianPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;

    public TuiJianPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
