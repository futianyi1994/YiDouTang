package com.example.yidoutangdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.yidoutangdemo.R;
import com.squareup.picasso.Picasso;

import java.io.File;

public class Main5Activity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        String imgPath = getIntent().getStringExtra("imgPath");
        imageView = ((ImageView) findViewById(R.id.activity_main5_imageViewId));
        Picasso.with(this).load(new File(imgPath)).into(imageView);
//        Glide.with(this).load(new File(imgPath)).into(imageView);
    }
}
