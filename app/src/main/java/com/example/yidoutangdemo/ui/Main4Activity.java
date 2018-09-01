package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.PhotoAdapter;

import java.io.File;
import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    GridView gridView;
    PhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        gridView = ((GridView) findViewById(R.id.activity_main4_gridViewId));
        adapter = new PhotoAdapter(this);
        gridView.setAdapter(adapter);
        loadData();
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                File file = new File(adapter.getItem(position));
                file.delete();
                adapter.clear();
                loadData();
                Toast.makeText(Main4Activity.this, "删除成功", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("imgPath",adapter.getItem(position));
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsoluteFile();
        ArrayList<String> datas = new ArrayList<>();
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String absolutePath = files[i].getAbsolutePath();
            if (files[i].isFile() && absolutePath.endsWith(".jpg")) {
                datas.add(absolutePath);
            }
        }
        adapter.addAll(datas);
    }
}
