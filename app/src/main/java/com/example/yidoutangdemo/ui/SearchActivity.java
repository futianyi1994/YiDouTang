package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.SerachTabPagerAdapter;
import com.example.yidoutangdemo.fragment.BaseFragment;
import com.example.yidoutangdemo.fragment.sousuofragment.SerachBaobei;
import com.example.yidoutangdemo.fragment.sousuofragment.SerachJianHuo;
import com.example.yidoutangdemo.fragment.sousuofragment.SerachShaiJia;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private SerachShaiJia shaiJia;
    private SerachBaobei baobei;
    private SerachJianHuo jianHuo;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView backImageView;
    List<BaseFragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        tabLayout= (TabLayout) findViewById(R.id.activity_serach_tabLayoutId);
        viewPager= (ViewPager) findViewById(R.id.activity_serach_viewPagerId);
        backImageView = (ImageView) findViewById(R.id.activity_search_back);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        String key=intent.getStringExtra("search");

        list=new ArrayList<>();
        shaiJia=SerachShaiJia.newInstance(key);
        baobei=SerachBaobei.newInstance(key);
        jianHuo=SerachJianHuo.newInstance(key);
        list.add(shaiJia);
        list.add(baobei);
        list.add(jianHuo);

        SerachTabPagerAdapter serachTabPagerAdapter=new SerachTabPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(serachTabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

   /* private int backStep = 0;
    //重写back建
    @Override
    public void onBackPressed() {
        if (backStep == 0) {
            Toast.makeText(SearchActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2 * 1000);
                        backStep = 0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else if (backStep == 1) {
            super.onBackPressed();
        }
        backStep++;
    }*/
}
