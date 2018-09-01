package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.ShaiXuanAdaper;
import com.example.yidoutangdemo.bean.ShaiXuanEntity;
import com.example.yidoutangdemo.callback.IntentCallback;
import com.example.yidoutangdemo.uri.UriInterface;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

import static com.example.yidoutangdemo.R.id.activity_shaixuan_ok;

public class ShaiXuanActivity extends AppCompatActivity {
    private ImageView backImageView;
    private ImageView okImageView;
    private TextView textView;
    private ListView listView;
    private ShaiXuanAdaper adaper;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shai_xuan);
        backImageView = (ImageView) findViewById(R.id.activity_shaixuan_back);
        okImageView = (ImageView) findViewById(activity_shaixuan_ok);
        textView = (TextView) findViewById(R.id.activity_shaixuan_textviewId);
        listView = (ListView) findViewById(R.id.activity_shaixuan_listviewId);

        adaper = new ShaiXuanAdaper(this);
        adaper.setIntentCallback(new IntentCallback() {
            @Override
            public void onClick(Intent intent) {
                ShaiXuanActivity.this.intent = intent;
            }
        });
        listView.setAdapter(adaper);
        okImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent != null) {
                    ShaiXuanActivity.this.startActivity(intent);
                    finish();
                }
            }
        });
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        loadData();
    }

    private void loadData() {
        OkHttpUtils.get().url(UriInterface.SHAIXUAN).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                ShaiXuanEntity shaiXuanEntity = JSON.parseObject(response, ShaiXuanEntity.class);
                adaper.addAll(shaiXuanEntity.getData().getTags());
            }
        });
    }
}
