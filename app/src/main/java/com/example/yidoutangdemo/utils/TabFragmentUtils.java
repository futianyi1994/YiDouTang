package com.example.yidoutangdemo.utils;

import android.support.v4.app.FragmentManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yidoutangdemo.fragment.BaseFragment;

import java.util.List;


/**
 * Created by 天一 on 2016/11/2.
 */
public class TabFragmentUtils implements RadioGroup.OnCheckedChangeListener {
    private List<BaseFragment> fragments;
    private int containerLayout;
    private FragmentManager fragmentManager;

    public TabFragmentUtils(RadioGroup radioGroup, List<BaseFragment> fragments, int containerLayout, FragmentManager fragmentManager) {
        this.fragments = fragments;
        this.containerLayout = containerLayout;
        this.fragmentManager = fragmentManager;
        //设置radiogroup的选中监听
        radioGroup.setOnCheckedChangeListener(this);
        //默认选中第0个
        showFragmentByIndex(0);
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < group.getChildCount(); i++) {
            RadioButton view = (RadioButton) group.getChildAt(i);
            if (view.getId() == checkedId) {
                //显示响应的页面，隐藏其他页面
                showFragmentByIndex(i);
            }
        }
    }

   /* public void showFragmentByIndex(int index) {
        for (int i = 0; i < 2; i++) {
            if (0 == index) {
                fragmentManager.beginTransaction().show(fragments.get(0)).commit();
                fragmentManager.beginTransaction().hide(fragments.get(1)).commit();
            } else if (1 == index){
                fragmentManager.beginTransaction().hide(fragments.get(0)).commit();
                fragmentManager.beginTransaction().show(fragments.get(1)).commit();
            }
        }
    }*/

    public void showFragmentByIndex(int index) {
        for (int i = 0; i < fragments.size(); i++) {
            if(i == index)
            {
                if (fragments.get(i).isAdded()) {
                    fragmentManager.beginTransaction().show(fragments.get(i)).commit();
                }
                else
                {
                    fragmentManager.beginTransaction().add(containerLayout,fragments.get(i)).commit();
                }
            }
            else
            {
                if (fragments.get(i).isAdded()) {
                    fragmentManager.beginTransaction().hide(fragments.get(i)).commit();
                }
            }
        }
    }
}
