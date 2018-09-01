package com.example.yidoutangdemo.ui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yidoutangdemo.MyApp;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.TabPagerAdapter;
import com.example.yidoutangdemo.bean.SouSuoEntity;
import com.example.yidoutangdemo.callback.HideTabCallback;
import com.example.yidoutangdemo.callback.ShowTabCallback;
import com.example.yidoutangdemo.fragment.BaseFragment;
import com.example.yidoutangdemo.fragment.DengLuFragment;
import com.example.yidoutangdemo.fragment.LoginFragment;
import com.example.yidoutangdemo.fragment.ShouYeFragment;
import com.example.yidoutangdemo.fragment.SouSuoFragment;
import com.example.yidoutangdemo.fragment.TuiJianFragment;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ShowTabCallback,HideTabCallback{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<BaseFragment> fragments;
    private TabPagerAdapter tabPagerAdapter;
    private FragmentManager fragmentManager;
    private LinearLayout linearLayout;
    private LinearLayout tab;
    private LinearLayout nullTab;


    //搜索关键字
    private String getSearch;
    //搜索栏
    private EditText editText;
    private ImageView ivDeleteText;
    private ImageView searchImageView;
    private RadioGroup radioGroup;

    // 属性动画
    private ObjectAnimator animator;
    //标记是否登陆成功
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.activity_main_tabLayoutId);
        viewPager = (ViewPager) findViewById(R.id.activity_main_viewpagerId);
        linearLayout = (LinearLayout) findViewById(R.id.activity_main_LinearLayoutId);
        editText = (EditText) findViewById(R.id.activity_main_EditTextId);
        ivDeleteText = (ImageView) findViewById(R.id.ivDeleteText);
        searchImageView = (ImageView) findViewById(R.id.activity_main_searchImageView);

        fragments = new ArrayList<>();

        //判断是否登陆
        flag = getIntent().getBooleanExtra("flag",false);
        if (flag){
            fragments.add(ShouYeFragment.newInstance(true));
            fragments.add(TuiJianFragment.newInstance());
            fragments.add(SouSuoFragment.newInstance());
            fragments.add(LoginFragment.newInstance());
            Toast.makeText(this,"登陆成功！",Toast.LENGTH_SHORT);
        }else {
            fragments.add(ShouYeFragment.newInstance(false));
            fragments.add(TuiJianFragment.newInstance());
            fragments.add(SouSuoFragment.newInstance());
            fragments.add(DengLuFragment.newInstance());
        }
        fragmentManager = getSupportFragmentManager();
        tabPagerAdapter = new TabPagerAdapter(fragmentManager, fragments, this);
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView imageView = (ImageView) view.findViewById(R.id.tab_imagView);
                TextView textView = (TextView) view.findViewById(R.id.tab_textView);
                if (textView.getText().toString().equals("首页")) {
                    tabLayout.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.GONE);
                    imageView.setImageResource(R.drawable.ic_home_home_focus);
                    viewPager.setCurrentItem(0);
                } else if (textView.getText().toString().equals("推荐")) {
                    tabLayout.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.GONE);
                    imageView.setImageResource(R.drawable.ic_home_article_focus);
                    viewPager.setCurrentItem(1);
                } else if (textView.getText().toString().equals("搜索")){
                    imageView.setImageResource(R.drawable.ic_home_search_focus);
                    viewPager.setCurrentItem(2);
                    tabLayout.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);
                }else {
                    tabLayout.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.GONE);
                    imageView.setImageResource(R.drawable.ic_home_mine_focus);
                    viewPager.setCurrentItem(3);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView imageView = (ImageView) view.findViewById(R.id.tab_imagView);
                TextView textView = (TextView) view.findViewById(R.id.tab_textView);
                if (textView.getText().toString().equals("首页")) {
                    imageView.setImageResource(R.drawable.ic_home_home_normal);
                } else if (textView.getText().toString().equals("推荐")) {
                    imageView.setImageResource(R.drawable.ic_home_article_normal);
                } else if (textView.getText().toString().equals("搜索")){
                    imageView.setImageResource(R.drawable.ic_home_search_normal);
                }else {
                    imageView.setImageResource(R.drawable.ic_home_mine_normal);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //监听输入关键字的时候显示删除按钮
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //文本框内容改变时调用
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //得到关键字搜索uri
                getSearch = editText.getText().toString();
                searchImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                        intent.putExtra("search",getSearch);
                        startActivity(intent);
                    }
                });
                //把搜索记录到数据库
                SouSuoEntity souSuoEntity = new SouSuoEntity(getSearch);
                try {
                    MyApp.getApp().getDbUtils().saveOrUpdate(souSuoEntity);
                } catch (DbException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0){
                    ivDeleteText.setVisibility(View.GONE);
                }else {
                    ivDeleteText.setVisibility(View.VISIBLE);
                }
            }
        });

        //点击清空输入搜索的关键字
        ivDeleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                showFragmentByIndex(position);

                animator = ObjectAnimator.ofFloat(viewPager,"translationY", 0, 0, 0, 0);
                animator.setDuration(0);
                // 启动属性动画
                animator.start();
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        showTab();
    }

    //循环加入tab中文字和图片
    public void showTab() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(tabPagerAdapter.getTabView(i));
            }
        }
    }

    //显示响应的页面，隐藏其他页面
    private void showFragmentByIndex(int index) {
        for (int i = 0; i < fragments.size(); i++) {
            if (i == index) {
                if (fragments.get(i).isAdded()) {
                    fragmentManager.beginTransaction().show(fragments.get(i)).commit();
                } else {
                    fragmentManager.beginTransaction().add(R.id.activity_main_viewpagerId, fragments.get(i)).commit();
                }
            } else {
                if (fragments.get(i).isAdded()) {
                    fragmentManager.beginTransaction().hide(fragments.get(i)).commit();
                }
            }
        }
    }

    private int backStep = 0;
    //重写back建
    @Override
    public void onBackPressed() {
        if (backStep == 0) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
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
    }

    boolean isShowFirst = true;
    @Override
    public void showFragmentTab() {
        View fragment= viewPager.getChildAt(0);
        tab = (LinearLayout) fragment.findViewById(R.id.shouyefragment_TabId);
        nullTab = (LinearLayout) fragment.findViewById(R.id.shouyefragment_nullLinearLayoutId);
        radioGroup = ((RadioGroup) fragment.findViewById(R.id.shouyefragment_radioGroupId));
        radioGroup.setVisibility(View.VISIBLE);
        tab.setVisibility(View.VISIBLE);
        nullTab.setVisibility(View.GONE);
        if (!isShowFirst&&isHideFirst){
            animator = ObjectAnimator.ofFloat(tab, "translationY", 0, 0, 0, 0);
            animator = ObjectAnimator.ofFloat(viewPager,"translationY", 0, 0, 0, 0);
            animator.setDuration(300);
            // 启动属性动画
            animator.start();
            isHideFirst = false;
            isShowFirst = true;
        }
    }

    boolean isHideFirst = false;
    @Override
    public void hideFragmentTab() {
        View fragment = viewPager.getChildAt(0);
        tab = (LinearLayout) fragment.findViewById(R.id.shouyefragment_TabId);
        nullTab = (LinearLayout) fragment.findViewById(R.id.shouyefragment_nullLinearLayoutId);
        radioGroup = ((RadioGroup) fragment.findViewById(R.id.shouyefragment_radioGroupId));
        radioGroup.setVisibility(View.INVISIBLE);
        nullTab.setVisibility(View.VISIBLE);
        tab.setVisibility(View.INVISIBLE);

        if (!isHideFirst&&isShowFirst){
            //获取当前像素密度比
            float density = getResources().getDisplayMetrics().density;
            float px = -40 * density;
            animator = ObjectAnimator.ofFloat(tab, "translationY", 0, 0, 0, px);
            animator = ObjectAnimator.ofFloat(viewPager,"translationY", 0, 0, 0, px);

            animator.setDuration(300);
            // 启动属性动画
            animator.start();
            isHideFirst = true;
            isShowFirst = false;
        }
    }
}
