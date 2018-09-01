package com.example.yidoutangdemo;

import android.app.Application;

import com.example.yidoutangdemo.bean.GouWuEntity;
import com.example.yidoutangdemo.bean.ShouCangEntity;
import com.example.yidoutangdemo.bean.SouSuoEntity;
import com.example.yidoutangdemo.config.AppConfig;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.sharesdk.framework.ShareSDK;
import okhttp3.OkHttpClient;

/**
 * Created by 天一 on 2016/11/2.
 */
public class MyApp extends Application {
    private static MyApp app;
    private DbUtils dbUtils;
    private DbUtils dbUtils_sc;
    private DbUtils dbUtils_buy;

    @Override
    public void onCreate() {
        super.onCreate();
        this.app = this;
        initOkHttpUtils();
        ShareSDK.initSDK(this);
        initXUtils();
    }

    private void initXUtils() {
        initDbUtils();
        initDbUtils_sc();
        initDbUtils_buy();
    }

    //购物车的数据库
    private void initDbUtils_buy() {
        dbUtils_buy = DbUtils.create(this,AppConfig.DB_NAME_BUY,AppConfig.DB_VERSION_BUY,null);
        try {
            dbUtils_buy.configDebug(true);//是否显示debug信息
            dbUtils_buy.createTableIfNotExist(GouWuEntity.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    //收藏的数据库
    private void initDbUtils_sc(){
        dbUtils_sc = DbUtils.create(this,AppConfig.DB_NAME_SC,AppConfig.DB_VERSION_SC,null);
        try {
            dbUtils_sc.configDebug(true);//是否显示debug信息
            dbUtils_sc.createTableIfNotExist(ShouCangEntity.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    //搜索页的数据库
    private void initDbUtils() {
        //1.创建数据库
        dbUtils = DbUtils.create(this, AppConfig.DB_NAME,AppConfig.DB_VERSION,null);
        //2.创建表(ORM)
        try {
            dbUtils.configDebug(true);//是否显示debug信息
            dbUtils.createTableIfNotExist(SouSuoEntity.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    private void initOkHttpUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }
    public DbUtils getDbUtils() {
        return dbUtils;
    }
    public DbUtils getDbUtils_sc() {
        return dbUtils_sc;
    }
    public DbUtils getDbUtils_buy() {
        return dbUtils_buy;
    }
    public static MyApp getApp() {
        return app;
    }
}
