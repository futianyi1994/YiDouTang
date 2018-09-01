package com.example.yidoutangdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.GouWuDanLVAdapter;
import com.example.yidoutangdemo.bean.GouWuEntity;
import com.lidroid.xutils.exception.DbException;

import static com.example.yidoutangdemo.MyApp.getApp;

public class GouWuDanActivity extends AppCompatActivity {

    private ListView listView;
    private GouWuDanLVAdapter gouWuDanLVAdapter;
    private TextView textView;
    private ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_dan);

        listView = (ListView) findViewById(R.id.activity_gouwudan_listViewId);
        textView = (TextView) findViewById(R.id.activity_gouwudan_delete);
        backImageView = (ImageView) findViewById(R.id.activity_gouwudan_back);
        gouWuDanLVAdapter = new GouWuDanLVAdapter(this);
        listView.setAdapter(gouWuDanLVAdapter);
        //注册上下文菜单
        registerForContextMenu(listView);
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
                    getApp().getDbUtils_buy().deleteAll(GouWuEntity.class);
                    gouWuDanLVAdapter.clear();
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            gouWuDanLVAdapter.addAll(getApp().getDbUtils_buy().findAll(GouWuEntity.class));
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gouwudan, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // 被点击菜单项的id
        int itemId = item.getItemId();
        // 获取使用适配器填充视图的相应菜单信息
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        // 获取ListView的位置信息
        int position = menuInfo.position;
        switch (itemId) {
            case R.id.buymenu:
                Toast.makeText(this,"购买成功！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.deletemenu:
                try {
                    GouWuEntity gouWuEntity = gouWuDanLVAdapter.getItem(position);
                    getApp().getDbUtils_buy().delete(gouWuEntity);
                    gouWuDanLVAdapter.clear();
                    gouWuDanLVAdapter.addAll(getApp().getDbUtils_buy().findAll(GouWuEntity.class));
                    Toast.makeText(GouWuDanActivity.this,"删除成功！",Toast.LENGTH_SHORT).show();
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
