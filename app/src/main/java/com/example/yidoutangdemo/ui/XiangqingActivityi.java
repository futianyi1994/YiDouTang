package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.XiangQing1Entity;
import com.example.yidoutangdemo.bean.XiangQing2Entity;
import com.example.yidoutangdemo.utils.AppBarStateChangeListener;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import cn.sharesdk.onekeyshare.OnekeyShare;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import okhttp3.Call;

public class XiangqingActivityi extends AppCompatActivity {

    private ImageView userPic;
    private ImageView img;
    private AppBarLayout mAppBarLayout;
    private Animation animation;
    private ImageView back;
    private TextView name;
    private TextView title;
    //private int type;
    private WebView webView;
    private ImageView fenxiang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing_activityi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        name= (TextView) findViewById(R.id.activity_xiangqing_textview1);
        title=(TextView) findViewById(R.id.activity_xiangqing_textview2);
        fenxiang= (ImageView) findViewById(R.id.activity_xiangqing_shareId);
        fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });
        webView= (WebView) findViewById(R.id.activity_xiangqing_webview);
        webView.getSettings().setUseWideViewPort(true);//web1就是你自己定义的窗口对象。
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
       /* //让缩放显示的最小值为起始
        webView.setInitialScale(5);
        // 设置支持缩放
        webView.getSettings().setSupportZoom(true);
        // 设置缩放工具的显示
        webView.getSettings().setBuiltInZoomControls(true);*/
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        back= (ImageView) findViewById(R.id.activity_xiangqing_backImageViewId);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*DisplayMetrics dm = getResources().getDisplayMetrics();
        // 获取当前界面的高度
        //int width = dm.widthPixels;
        //int height = dm.heightPixels;
        int scale = dm.densityDpi;
        if (scale == 240) {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else if (scale == 160) {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        } else {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        }*/
        setSupportActionBar(toolbar);
        userPic= (ImageView) findViewById(R.id.activity_xiangqing_userpic);
        img= (ImageView) findViewById(R.id.activity_xiangqing_img);
        mAppBarLayout= (AppBarLayout) findViewById(R.id.app_bar);
        setAppBarLayoutListener();
        setWebView();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent=new Intent(XiangqingActivityi.this,PhotoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setWebView() {
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        //type=intent.getIntExtra("type",1);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                XiangQing1Entity xiangQing1Entity= JSON.parseObject(response, XiangQing1Entity.class);
                XiangQing2Entity xiangQing2Entity= JSON.parseObject(response, XiangQing2Entity.class);
                if (xiangQing1Entity.getData().getCaseX()!=null&&xiangQing2Entity.getData().getPosts()==null)
                {
                    name.setText(xiangQing1Entity.getData().getCaseX().getUser_name());
                    title.setText(xiangQing1Entity.getData().getCaseX().getTitle());
                    if(!xiangQing1Entity.getData().getCaseX().getImage().isEmpty()) {
                        Picasso.with(XiangqingActivityi.this).load(xiangQing1Entity.getData().getCaseX().getImage()).into(img);
                    }
                    if (!xiangQing1Entity.getData().getCaseX().getUser_pic().isEmpty()) {
                        Picasso.with(XiangqingActivityi.this).load(xiangQing1Entity.getData().getCaseX().getUser_pic()).transform(new CropCircleTransformation()).into(userPic);
                    }
                    webView.loadDataWithBaseURL(null,xiangQing1Entity.getData().getCaseX().getContent(),"text/html","UTF-8",null);
                }else
                {
                    name.setText(xiangQing2Entity.getData().getPosts().get(0).getAuthor());
                    title.setText(xiangQing2Entity.getData().getPosts().get(0).getSubject());
                    if (!xiangQing2Entity.getData().getCover().isEmpty()) {
                        Picasso.with(XiangqingActivityi.this).load(xiangQing2Entity.getData().getCover()).into(img);
                    }
                    if (!xiangQing2Entity.getData().getPosts().get(0).getUser_pic().isEmpty()) {
                        Picasso.with(XiangqingActivityi.this).load(xiangQing2Entity.getData().getPosts().get(0).getUser_pic()).transform(new CropCircleTransformation()).into(userPic);
                    }
                    webView.loadDataWithBaseURL(null,xiangQing2Entity.getData().getPosts().get(0).getMessage_div(),"text/html","UTF-8",null);
                }

                /*try {
                    Log.d("kongbukong",response);
                    JSONObject jSONObject=new JSONObject(response);
                    jSONObject=jSONObject.getJSONObject("data");
                    jSONObject=jSONObject.getJSONObject("case");
                    String x=jSONObject.getString("content");
                    Log.d("kongbukong",x);


                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

            }
        });

    }

    private void setAppBarLayoutListener() {
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {
                    //fab.setVisibility(View.VISIBLE);
                    //展开状态

                    userPic.setVisibility(View.VISIBLE);

                   /* animation = new ScaleAnimation(0, 1, 0, 1,fab.getWidth()/2,fab.getHeight()/2);
                    // 动画持续时间
                    animation.setDuration(300);
                    // 让动画停留在结束的状态上
                    animation.setFillAfter(true);
                    fab.startAnimation(animation);*/


                }else if(state == State.COLLAPSED){

                    //fab.setVisibility(View.INVISIBLE);
                    //折叠状态
                    animation = new ScaleAnimation(1, 0, 1, 0,userPic.getWidth()/2,userPic.getHeight()/2);
                    // 动画持续时间
                    animation.setDuration(300);
                    // 让动画停留在结束的状态上
                    animation.setFillAfter(true);
                    userPic.startAnimation(animation);

                }else {
                    //中间状态
                    animation = new ScaleAnimation(1, 1, 1, 1,userPic.getWidth()/2,userPic.getHeight()/2);
                    // 动画持续时间
                    animation.setDuration(300);
                    // 让动画停留在结束的状态上
                    animation.setFillAfter(true);
                    userPic.startAnimation(animation);
                }
            }
        });
    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }
}
