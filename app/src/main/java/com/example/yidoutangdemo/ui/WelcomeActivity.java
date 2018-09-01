package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yidoutangdemo.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        newThread();
    }

    private void newThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3*1000);
                    WelcomeActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
