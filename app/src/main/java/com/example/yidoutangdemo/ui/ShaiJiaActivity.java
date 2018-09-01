package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.header.StoreHouseHeader;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.ShaiJiaRVadapter;
import com.example.yidoutangdemo.bean.ShaiJiaEntity;
import com.example.yidoutangdemo.uri.UriInterface;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class ShaiJiaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int page=1;
    private ShaiJiaRVadapter shaiJiaRVadapter;
    private ImageView back;
    private ImageView shaixuan;
    private PtrFrameLayout ptrFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shai_jia);

        back= (ImageView) findViewById(R.id.activity_shaijia_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        shaixuan= (ImageView) findViewById(R.id.activity_shaijia_shaixuan);
        shaixuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShaiJiaActivity.this,ShaiXuanActivity.class);
                startActivity(intent);
            }
        });


        ptrFrameLayout= (PtrFrameLayout) findViewById(R.id.activity_shaijia_ptrFrameLayout);
        recyclerView= (RecyclerView) findViewById(R.id.activity_shaijia_recyclerviewId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        shaiJiaRVadapter=new ShaiJiaRVadapter(this);

        RecyclerAdapterWithHF adapter = new RecyclerAdapterWithHF(shaiJiaRVadapter);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                Intent intent=new Intent(ShaiJiaActivity.this, XiangqingActivityi.class);
                String url=String.format(UriInterface.SHAIJIAXIANGQING_URL,shaiJiaRVadapter.getItem(position).getGroup_id());
                intent.putExtra("url",url);
                intent.putExtra("type",1);
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
                shaiJiaRVadapter.clear();
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
        String url= String.format(UriInterface.SHAIJIA_URL,page);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onResponse(String response, int id) {
                ShaiJiaEntity shaiJiaEntity=JSON.parseObject(response,ShaiJiaEntity.class);
                shaiJiaRVadapter.addAll(shaiJiaEntity.getData().getCases());
            }
        });
    }
}
