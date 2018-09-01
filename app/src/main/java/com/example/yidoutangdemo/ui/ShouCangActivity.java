package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yidoutangdemo.MyApp;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.ShouCangLVAdapter;
import com.example.yidoutangdemo.bean.ShouCangEntity;
import com.example.yidoutangdemo.uri.UriInterface;
import com.lidroid.xutils.exception.DbException;

import static com.example.yidoutangdemo.MyApp.getApp;

public class ShouCangActivity extends AppCompatActivity {
    private ListView listView;
    private ShouCangLVAdapter shouCangLVAdapter;
    private TextView textView;
    private ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_cang);
        listView = (ListView) findViewById(R.id.activity_shoucang_listViewId);
        textView = (TextView) findViewById(R.id.activity_shoucang_delete);
        backImageView = (ImageView) findViewById(R.id.activity_shoucang_back);
        shouCangLVAdapter = new ShouCangLVAdapter(this);
        listView.setAdapter(shouCangLVAdapter);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getApp().getDbUtils_sc().deleteAll(ShouCangEntity.class);
                    shouCangLVAdapter.clear();
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShouCangActivity.this,XiangqingActivityi.class);
                try {
                    String case_id = MyApp.getApp().getDbUtils_sc().findAll(ShouCangEntity.class).get(position).getCase_id();
                    intent.putExtra("url", UriInterface.getShaijiaxiangqingUrl(case_id));
                    startActivity(intent);
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    ShouCangEntity shouCangEntity = shouCangLVAdapter.getItem(position);
                    getApp().getDbUtils_sc().delete(shouCangEntity);
                    shouCangLVAdapter.clear();
                    shouCangLVAdapter.addAll(getApp().getDbUtils_sc().findAll(ShouCangEntity.class));
                    Toast.makeText(ShouCangActivity.this,"删除成功！",Toast.LENGTH_SHORT).show();
                } catch (DbException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        try {
            shouCangLVAdapter.addAll(getApp().getDbUtils_sc().findAll(ShouCangEntity.class));
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
