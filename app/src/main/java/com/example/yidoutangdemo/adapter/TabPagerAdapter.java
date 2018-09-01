package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 天一 on 2016/10/31.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;
    private String[] title = new String[]{"首页", "推荐", "搜索", "登陆"};
    private int[]imageView ={R.drawable.selector_shouye,R.drawable.selector_tuijian,R.drawable.selector_sousuo,R.drawable.selector_denglu};

    private Context context;



    public TabPagerAdapter(FragmentManager fragmentManager, List<BaseFragment> fragments, Context context) {
        super(fragmentManager);
        this.fragments = fragments;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

   /* @Override
    public CharSequence getPageTitle(int position) {

        return title[position];
    }*/

    public View getTabView(int position){
        //首先为子tab布置一个布局
        View v = LayoutInflater.from(context).inflate(R.layout.tab,null);
        TextView tv = (TextView) v.findViewById(R.id.tab_textView);
        tv.setText(title[position]);
        ImageView iv = (ImageView) v.findViewById(R.id.tab_imagView);
        iv.setImageResource(imageView[position]);
        return v;
    }
}
