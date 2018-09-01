package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yidoutangdemo.R;

public class LogingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);
        boolean flag = getIntent().getBooleanExtra("flag",false);
        final Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("flag",flag);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2*1000);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
