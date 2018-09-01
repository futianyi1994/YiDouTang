package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.PinglunAdapter;
import com.example.yidoutangdemo.bean.PingLunEntity;
import com.example.yidoutangdemo.uri.UriInterface;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class PingLunActivity extends AppCompatActivity {
    private ImageView backImageView;
    private ListView listView;
    private PinglunAdapter adapter;
    private String match_id;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_lun);
        Intent intent = getIntent();
        match_id = intent.getStringExtra("match_id");
        Log.d("1606",match_id+"");
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_pinglun_swipeRefreshLayoutId);
        backImageView = (ImageView) findViewById(R.id.activity_pinglun_back);
        listView = (ListView) findViewById(R.id.activity_pinglun_ListViewId);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adapter = new PinglunAdapter(this);
        listView.setAdapter(adapter);
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
        OkHttpUtils.get().url(UriInterface.getPINGLUN(match_id)).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }
            @Override
            public void onResponse(String response, int id) {
                final PingLunEntity pingLunEntity = JSON.parseObject(response, PingLunEntity.class);
                adapter.addAll(pingLunEntity.getData().getComments());
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
