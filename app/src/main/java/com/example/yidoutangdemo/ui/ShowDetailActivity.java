package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.MyApp;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.ImageViewPagerAdapter;
import com.example.yidoutangdemo.bean.ShouCangEntity;
import com.example.yidoutangdemo.bean.ShouYeEntity;
import com.example.yidoutangdemo.config.AppConfig;
import com.example.yidoutangdemo.uri.UriInterface;
import com.lidroid.xutils.exception.DbException;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;

public class ShowDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private int page = 1;
    private ViewPager viewPager;
    private List<View> views;
    private ImageViewPagerAdapter imageViewPagerAdapter;
    private String urlRecycle;
    private String urlList;
    private int position;
    private String normal_image;
    private String case_title;
    private int flag;
    private int Cposition;
    private String match_id;

    private ShouYeEntity shouYeEntity;

    private Button button;
    private ImageView backImageView;
    private ImageView commentsImagview;
    private ImageView favImageView;
    private ImageView shareImageView;
    private boolean ifLogin;

    private String shoucang_image;
    private String shoucang_title;

    private String case_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        viewPager = (ViewPager) findViewById(R.id.activity_showdetail_viewPagerId);
        button = (Button) findViewById(R.id.activity_showdetail_ButtonId);
        backImageView = (ImageView) findViewById(R.id.activity_showdetail_backImageViewId);
        //退出activity
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        favImageView = (ImageView) findViewById(R.id.activity_showdetail_favtId);
        favImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifLogin){
                    Toast.makeText(ShowDetailActivity.this,"收藏成功！",Toast.LENGTH_SHORT).show();
                    //点击收藏室收藏的图片和标题
                    shoucang_image = shouYeEntity.getData().getPics().get(Cposition).getNormal_image();
                    shoucang_title = shouYeEntity.getData().getPics().get(Cposition).getCase_title();
                    ShouCangEntity shouCangEntity = new ShouCangEntity(shoucang_image,shoucang_title,case_id);
                    try {
                        //收藏信息加入数据库
                        MyApp.getApp().getDbUtils_sc().saveOrUpdate(shouCangEntity);
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }else {
                    Intent intent = new Intent(ShowDetailActivity.this,DengLuActivity.class);
                    startActivity(intent);
                }
            }
        });
        commentsImagview = (ImageView) findViewById(R.id.activity_showdetail_commenttId);
        shareImageView= (ImageView) findViewById(R.id.activity_showdetail_shareId);
        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });

        Intent intent = getIntent();
        ifLogin = intent.getBooleanExtra("ifLogin",false);
        normal_image = intent.getStringExtra("normal_image");
        case_title = intent.getStringExtra("case_title");
        position = intent.getIntExtra("position", 0);
        flag = intent.getIntExtra("flag", -1);
        urlRecycle = intent.getStringExtra("url_recycle");
        urlList = intent.getStringExtra("url_list");
        //设置初始展示的照片位置
        if (flag == AppConfig.FLAG_LISTVIEW) {
            Cposition = position-1;
        }
        if (flag == AppConfig.FLAG_RECYCLEVIEW) {
            Cposition = position;
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Cposition = position;
                match_id = shouYeEntity.getData().getPics().get(Cposition).getMatch_id();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //下载数据
        loadData(flag);
    }

    private void loadData(int flag) {
        String url = null;
        if (flag == AppConfig.FLAG_LISTVIEW) {
            url = urlList;
        }
        if (flag == AppConfig.FLAG_RECYCLEVIEW) {
            url = urlRecycle;

        }
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {

            }
            @Override
            public void onResponse(String response, int id) {
                shouYeEntity = JSON.parseObject(response, ShouYeEntity.class);
                views = new ArrayList<>();
                for (int i = 0; i < shouYeEntity.getData().getPics().size(); i++) {
                    View view = LayoutInflater.from(ShowDetailActivity.this).inflate(R.layout.activity_imagedetail, viewPager, false);
                    imageView = (ImageView) view.findViewById(R.id.activity_imagedetail_ImageViewId);
                    /*//动态设置图片宽高
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = shouYeEntity.getData().getPics().get(i).getData().getInfo().getImg_h();
                    layoutParams.width = shouYeEntity.getData().getPics().get(i).getData().getInfo().getImg_w();
                    imageView.setLayoutParams(layoutParams);*/
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.requestLayout();
                    Picasso.with(ShowDetailActivity.this).load(shouYeEntity.getData().getPics().get(i).getNormal_image()).into(imageView);
                    views.add(view);
                }
                imageViewPagerAdapter = new ImageViewPagerAdapter(views);
                viewPager.setAdapter(imageViewPagerAdapter);
                viewPager.setCurrentItem(Cposition);
//                final String case_id = shouYeEntity.getData().getPics().get(Cposition).getCase_id();
                case_id = shouYeEntity.getData().getPics().get(Cposition).getCase_id();
                //查看原帖点击事件
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ShowDetailActivity.this,XiangqingActivityi.class);
                        intent.putExtra("url", UriInterface.getShaijiaxiangqingUrl(case_id));
                        startActivity(intent);
                    }
                });
                //查看评论
                match_id = shouYeEntity.getData().getPics().get(Cposition).getMatch_id();
                commentsImagview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ShowDetailActivity.this,PingLunActivity.class);
                        intent.putExtra("match_id",match_id);
                        startActivity(intent);
                    }
                });
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

    @Override
    protected void onDestroy() {
        //停止服务
        ShareSDK.stopSDK();
        super.onDestroy();
    }
}
