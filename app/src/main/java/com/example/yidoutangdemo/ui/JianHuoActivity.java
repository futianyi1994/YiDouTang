package com.example.yidoutangdemo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.header.StoreHouseHeader;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.GridViewAdapter;
import com.example.yidoutangdemo.adapter.JianHuoRVadapter;
import com.example.yidoutangdemo.adapter.MPagerAdapter;
import com.example.yidoutangdemo.bean.JianHuoEntity;
import com.example.yidoutangdemo.uri.UriInterface;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class JianHuoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private JianHuoRVadapter jianHuoRVadapter;
    private View headerView1;
    private View headerView2;
    private ViewPager viewPager;
    private ImageView back;
    private ImageView shaixuan;
    private LinearLayout linearLayout;
    private GridViewAdapter gridViewAdapter;
    private List<JianHuoEntity.DataBean.RecommendTagBean> gridList;

    private PtrFrameLayout ptrFrameLayout;

    private GridView gridView;
    //private int page=1;
    private JianHuoEntity jianHuoEntity;
    private int page=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jian_huo);
        back= (ImageView) findViewById(R.id.activity_jianhuo_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        shaixuan= (ImageView) findViewById(R.id.activity_jianhuo_shaixuan);
        shaixuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JianHuoActivity.this,ShaiXuanActivity.class);
                startActivity(intent);
            }
        });
        ptrFrameLayout= (PtrFrameLayout) findViewById(R.id.activity_jianhuo_ptrFrameLayout);
        recyclerView= (RecyclerView) findViewById(R.id.activity_jianhuo_recyclerviewId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        jianHuoRVadapter=new JianHuoRVadapter(this);
        RecyclerAdapterWithHF adapter = new RecyclerAdapterWithHF(jianHuoRVadapter);

        LayoutInflater inflater=LayoutInflater.from(this);



        //头视图1
        headerView1=inflater.inflate(R.layout.activity_jianhuo_header1,recyclerView,false);
        jianHuoRVadapter.addHeaderView(headerView1);
        initHeaderView(inflater);
        //头视图2
        /*headerView2=inflater.inflate(R.layout.activity_jianhuo_header2,recyclerView,false);
        jianHuoRVadapter.addHeaderView(headerView2);
        initHeaderView2();*/

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                Intent intent=new Intent(JianHuoActivity.this, XiangqingActivityi.class);
                String url=String.format(UriInterface.JIANHUOXIANGQING_URL,jianHuoRVadapter.getItem(position).getTid());
                intent.putExtra("url",url);
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });
        StoreHouseHeader ptrUIHandler = new StoreHouseHeader(this);

        ptrUIHandler.initWithString("down loading");
        ptrUIHandler.setTextColor(Color.parseColor("#666666"));

        ptrUIHandler.setPadding(40,40,40,40);

        //添加头部ui处理功能
        ptrFrameLayout.addPtrUIHandler(ptrUIHandler);
        //设置头布局
        ptrFrameLayout.setHeaderView(ptrUIHandler);

        ptrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrFrameLayout.autoRefresh(true);
            }
        },200);


        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                jianHuoRVadapter.clear();
                page=1;
                setData();
                //隐藏刷新进度
                frame.refreshComplete();
                //激活加载更多
                frame.setLoadMoreEnable(true);
            }
        });
        ptrFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                page++;
                setData();
                //已经加载完成
                ptrFrameLayout.loadMoreComplete(true);
            }
        });

        setData();

    }

   /* private void initHeaderView2() {
        gridView= (GridView) headerView2.findViewById(R.id.activity_jianhuo_header_gridview);
        gridViewAdapter=new GridViewAdapter(this);
        gridView.setAdapter(gridViewAdapter);

        setGridData();

    }*/

    private void setGridData() {
        OkHttpUtils.get().url(UriInterface.JIANHUO_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                jianHuoEntity= JSON.parseObject(response,JianHuoEntity.class);
                gridList=new ArrayList<>();
                gridList.addAll(jianHuoEntity.getData().getRecommend_tag());
                gridViewAdapter.addAll(jianHuoEntity.getData().getRecommend_tag());
            }
        });
    }

    private void initHeaderView(LayoutInflater inflater) {
        //查找头布局的控件
        viewPager = ((ViewPager) headerView1.findViewById(R.id.activity_jianhuo_header_viewpagerId));
        linearLayout = ((LinearLayout) headerView1.findViewById(R.id.activity_jianhuo_header_linearLayout));

        gridView= (GridView) headerView1.findViewById(R.id.activity_jianhuo_header_gridview);
        gridViewSetClick(gridView);
        gridViewAdapter=new GridViewAdapter(this);
        gridView.setAdapter(gridViewAdapter);
        setGridData();

        //实例化ViewPager适配器
        ArrayList<View> views = new ArrayList<>();

        for (int i=0; i < linearLayout.getChildCount()*2; i++) {
            View view = inflater.inflate(R.layout.head_img, viewPager, false);
            ImageView imageView= (ImageView) view.findViewById(R.id.head_img);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(JianHuoActivity.this, DengLuActivity.class);
                    startActivity(intent);
                }
            });
            setImgData(imageView,i%3);
            views.add(view);

            MPagerAdapter mPagerAdapter = new MPagerAdapter(views);
            //3.设置viewPager适配器
            viewPager.setAdapter(mPagerAdapter);
            //设置中间页
            viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % views.size());

            //设置viewPager监听
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    selectIndicator(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            selectIndicator(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % views.size());
        }
    }

    private void gridViewSetClick(GridView gridView) {
        Log.d("lala","执行");
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent();
                if (gridList.get(i).getData()!=null&&gridList.get(i).getData().getClassX()!=null) {
                    intent.putExtra("name",gridList.get(i).getTitle());
                    intent.putExtra("url","class="+gridList.get(i).getData().getClassX());
                    intent.setClass(JianHuoActivity.this,JianHuoZiActivity.class);
                }else if (gridList.get(i).getData()!=null&&gridList.get(i).getData().getTag()!=null)
                {
                    intent.putExtra("name",gridList.get(i).getTitle());
                    intent.putExtra("url","class="+gridList.get(i).getData().getTag());
                    intent.setClass(JianHuoActivity.this,JianHuoZiActivity.class);
                }else
                {
                    intent.setClass(JianHuoActivity.this,GengDuoActivity.class);
                }
                startActivity(intent);
            }
        });

    }

    private void setImgData(final ImageView imageView, final int i) {
        OkHttpUtils.get().url(UriInterface.JIANHUO_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                jianHuoEntity= JSON.parseObject(response,JianHuoEntity.class);
                Log.d("lailai2",i+"");
                Picasso.with(JianHuoActivity.this).load(jianHuoEntity.getData().getBanners().get(i).getImage()).into(imageView);
            }
        });
    }

    private void selectIndicator(int position) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            ImageView view = (ImageView) linearLayout.getChildAt(i);
            if(position % linearLayout.getChildCount() == i)
            {
                view.setImageResource(R.drawable.abc_k);
            }
            else
            {
                view.setImageResource(R.drawable.abc_false);
            }
        }
    }


    private void setData() {
        String url= String.format(UriInterface.JIANHUO_URL,page);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onResponse(String response, int id) {
                JianHuoEntity jianHuoEntity= JSON.parseObject(response,JianHuoEntity.class);
                jianHuoRVadapter.addAll(jianHuoEntity.getData().getGuides());
            }
        });
    }
}
