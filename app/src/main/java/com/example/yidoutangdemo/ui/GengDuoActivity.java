package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.GengDuoFlowLayoutAdapter;
import com.example.yidoutangdemo.adapter.GengDuoGridViewAdapter;
import com.example.yidoutangdemo.bean.GengDuoEntity;
import com.example.yidoutangdemo.uri.UriInterface;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class GengDuoActivity extends AppCompatActivity {

    private TagFlowLayout tagFlowLayout;
    private GridView gridView;
    private GengDuoFlowLayoutAdapter gengDuoFlowLayoutAdapter;
    private GengDuoGridViewAdapter gengDuoGridViewAdapter;
    private List<GengDuoEntity.DataBean.TagsBean> list=new ArrayList<>();
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gengduo);
        tagFlowLayout= (TagFlowLayout) findViewById(R.id.activity_gengduo_flowlayoutId);
        gridView= (GridView) findViewById(R.id.activity_gengduo_gridviewId);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        back= (ImageView) findViewById(R.id.activity_gengduo_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Intent intent = new Intent(GengDuoActivity.this, JianHuoZiActivity.class);
                intent.putExtra("search", list.get(position).getTagid());
                intent.putExtra("bj",1);
                intent.putExtra("name",list.get(position).getName());
                startActivity(intent);
                return true;
            }
        });
        gengDuoGridViewAdapter=new GengDuoGridViewAdapter(this);
        gridView.setAdapter(gengDuoGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GengDuoActivity.this, JianHuoZiActivity.class);
                intent.putExtra("search", gengDuoGridViewAdapter.getItem(i).getTagid());
                intent.putExtra("bj",2);
                intent.putExtra("name",gengDuoGridViewAdapter.getItem(i).getName());
                startActivity(intent);

            }
        });

        setData();


    }

    private void setData() {
        OkHttpUtils.get().url(UriInterface.GENGDUO_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                GengDuoEntity gengDuoEntity=JSON.parseObject(response, GengDuoEntity.class);
                list.addAll(gengDuoEntity.getData().get(0).getTags());
                gengDuoFlowLayoutAdapter=new GengDuoFlowLayoutAdapter(gengDuoEntity.getData().get(0).getTags(),GengDuoActivity.this,tagFlowLayout);

                tagFlowLayout.setAdapter(gengDuoFlowLayoutAdapter);

                gengDuoGridViewAdapter.addAll(gengDuoEntity.getData().get(1).getTags());

            }
        });
    }

}
