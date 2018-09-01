package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.ShouYeTuiJianRVAdapter;
import com.example.yidoutangdemo.bean.ShouYeEntity;
import com.example.yidoutangdemo.uri.UriInterface;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class KanTuActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ShouYeTuiJianRVAdapter adapter;
    private String order ;
    private String space ;
    private String style ;
    private String part ;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kan_tu);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_kan_tu_swipeRefreshLayoutId);
        recyclerView = (RecyclerView) findViewById(R.id.activity_kan_tu_recyclerViewId);
        textView = (TextView) findViewById(R.id.activity_kan_tu_textViewId);
        imageView = ((ImageView) findViewById(R.id.activity_kan_tu_back));
        Intent intent = getIntent();
        order = intent.getStringExtra("order");
        space = intent.getStringExtra("space");
        style = intent.getStringExtra("style");
        part = intent.getStringExtra("part");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new ShouYeTuiJianRVAdapter(this);
        recyclerView.setAdapter(adapter);
        //设置刷新样式
        swipeRefreshLayout.setColorSchemeColors(new int[]{Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW});
        //设置刷新监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                loadData();
            }
        });
        //加载数据
        loadData();
    }

    private void loadData() {
        if (order == null){
            order = "";
        }
        if (space == null){
            space = "";
        }
        if (style == null){
            style = "";
        }
        if (part == null){
            part = "";
        }
        OkHttpUtils.get().url(UriInterface.getSHAIXUAN(order,space,style,part)).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                ShouYeEntity shouYeEntity = JSON.parseObject(response, ShouYeEntity.class);
                textView.setText(shouYeEntity.getData().getTag());
                adapter.addAll(shouYeEntity.getData().getPics());
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
