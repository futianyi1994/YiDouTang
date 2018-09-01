package com.example.yidoutangdemo.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.TuiJianPagerAdapter;
import com.example.yidoutangdemo.fragment.shouyefragment.ShouYeTuiJianFragment;
import com.example.yidoutangdemo.fragment.shouyefragment.ShouYeZuiXinFragment;
import com.example.yidoutangdemo.ui.ShaiXuanActivity;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 天一 on 2016/10/31.
 */
public class ShouYeFragment extends BaseFragment{

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private Button pinterest_btn;
    private Button linear_btn;
    private Button photo_filter_btn;

    private List<BaseFragment> fragments;
    private TuiJianPagerAdapter pagerAdapter;
    private int position = 0;
    private RecyclerView recyclerView;
    private PullToRefreshListView listView;
    private LinearLayout linearLayout;

    boolean flag = true;
    private boolean ifLogin;


    public ShouYeFragment() {
    }

    public static ShouYeFragment newInstance(boolean ifLogin) {
        Bundle args = new Bundle();
        args.putBoolean("ifLogin",ifLogin);
        ShouYeFragment fragment = new ShouYeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        ifLogin = args.getBoolean("ifLogin");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.shouyefragment,container,false);
        viewPager = (ViewPager) rootView.findViewById(R.id.shouyefragment_viewPagerId);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.shouyefragment_radioGroupId);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.shouyefragment_TabId);

        pinterest_btn = (Button) rootView.findViewById(R.id.pinterest_btn);
        linear_btn = (Button) rootView.findViewById(R.id.linear_btn);
        photo_filter_btn = (Button) rootView.findViewById(R.id.photo_filter_btn);

        fragments = new ArrayList<>();
        fragments.add(ShouYeTuiJianFragment.newInstance(ifLogin));
        fragments.add(ShouYeZuiXinFragment.newInstance());


        pagerAdapter = new TuiJianPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0);

        linear_btn.setBackgroundResource(R.drawable.ic_view_linear);
        pinterest_btn.setBackgroundResource(R.drawable.ic_view_pinterest_checked);

        linear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showView(position);
                flag = false;
                recyclerView.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                linear_btn.setBackgroundResource(R.drawable.ic_view_linear_checked);
                pinterest_btn.setBackgroundResource(R.drawable.ic_view_pinterest);
            }
        });
        pinterest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showView(position);
                flag = true;
                recyclerView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                linear_btn.setBackgroundResource(R.drawable.ic_view_linear);
                pinterest_btn.setBackgroundResource(R.drawable.ic_view_pinterest_checked);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton view = (RadioButton) group.getChildAt(i);
                    if (view.getId() == checkedId) {
                        viewPager.setCurrentItem(i);
                        view.setTextColor(Color.BLACK);
                    }
                    else {
                        view.setTextColor(Color.rgb(175,175,175));
                    }
                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(final int position) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    if (i == position) {
                        RadioButton view = (RadioButton) radioGroup.getChildAt(i);
                        view.setChecked(true);
                        view.setTextColor(Color.BLACK);
                    }
                    else {
                        RadioButton view = (RadioButton) radioGroup.getChildAt(i);
                        view.setChecked(false);
                        view.setTextColor(Color.rgb(175,175,175));
                    }
                }
                ShouYeFragment.this.position = position;
                showView(position);
                if (flag){
                    recyclerView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.INVISIBLE);
                }else {
                    recyclerView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        photo_filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ShaiXuanActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    //根据position判断是显示recyclerView还是listView
    public void showView(int position){
        View fragment= viewPager.getChildAt(position);
        if (position == 0){
            recyclerView = (RecyclerView) fragment.findViewById(R.id.shouyetuijianfragment_recyclerViewId);
            listView = (PullToRefreshListView) fragment.findViewById(R.id.shouyetuijianfragment_listViewId);
        }else if (position == 1){
            recyclerView = (RecyclerView) fragment.findViewById(R.id.shouyezuixinfragment_recyclerViewId);
            listView = (PullToRefreshListView) fragment.findViewById(R.id.shouyezuixinfragment_listViewId);
        }
    }
}
