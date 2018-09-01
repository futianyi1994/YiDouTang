package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.header.StoreHouseHeader;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.JianHuoZiRVadapter;
import com.example.yidoutangdemo.bean.JianHuoZiEntity;
import com.example.yidoutangdemo.uri.UriInterface;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class JianHuoZiActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView textView;
    private String url;
    private JianHuoZiRVadapter jianHuoZiRVadapter;
    private ImageView back;
    private PtrFrameLayout ptrFrameLayout;
    private int page=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jianhuo_zi);
        back= (ImageView) findViewById(R.id.activity_jianhuozi_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent=getIntent();
        String title=intent.getStringExtra("name");
        String urlKey=intent.getStringExtra("url");
        String tagId=intent.getStringExtra("search");
        int bj=intent.getIntExtra("bj",1);
        if (tagId==null) {
            url = String.format(UriInterface.JIANHUOZI_URL,page, urlKey);
        }else
        {
            if (bj==1)
            {
                url = String.format(UriInterface.GENGDUOXAINGQING_URL,page,tagId);
            }else
            {
                url = String.format(UriInterface.GENGDUOXAINGQING_URL2,page,tagId);
            }

        }

        ptrFrameLayout= (PtrFrameLayout) findViewById(R.id.activity_jianhuozi_ptrFrameLayout);
        recyclerView= (RecyclerView) findViewById(R.id.activity_jianhuozi_recyclerviewId);
        textView= (TextView) findViewById(R.id.activity_jianhuozi_textviewId);
        textView.setText(title);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        jianHuoZiRVadapter=new JianHuoZiRVadapter(this);

        RecyclerAdapterWithHF adapter = new RecyclerAdapterWithHF(jianHuoZiRVadapter);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                Intent intent=new Intent(JianHuoZiActivity.this, XiangqingActivityi.class);
                String url=String.format(UriInterface.JIANHUOXIANGQING_URL,jianHuoZiRVadapter.getItem(position).getTid());
                intent.putExtra("url",url);
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });

        StoreHouseHeader ptrUIHandler = new StoreHouseHeader(this);

        ptrUIHandler.initWithString("down loading");
        ptrUIHandler.setTextColor(Color.parseColor("#666666"));

        ptrUIHandler.setPadding(40,40,40,40);

        //添加头部ui处理功能
        ptrFrameLayout.addPtrUIHandler(ptrUIHandler);
        //设置头布局
        ptrFrameLayout.setHeaderView(ptrUIHandler);

        /*//添加头部ui处理功能
        ptrFrameLayout.addPtrUIHandler(materialHeader);
        //设置头布局
        ptrFrameLayout.setHeaderView(materialHeader);*/

        ptrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrFrameLayout.autoRefresh(true);
            }
        },200);


        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                jianHuoZiRVadapter.clear();
                page=1;
                setData();
                //隐藏刷新进度
                frame.refreshComplete();
                //激活加载更多
                frame.setLoadMoreEnable(true);
            }
        });
        ptrFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                page++;
                setData();
                //已经加载完成
                ptrFrameLayout.loadMoreComplete(true);
            }
        });

        setData();

    }

    private void setData() {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onResponse(String response, int id) {
                JianHuoZiEntity jianHuoZiEntity= JSON.parseObject(response,JianHuoZiEntity.class);
                jianHuoZiRVadapter.addAll(jianHuoZiEntity.getData().getGuides());
            }
        });
    }
}
