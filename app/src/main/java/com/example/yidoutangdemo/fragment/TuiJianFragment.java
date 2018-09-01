package com.example.yidoutangdemo.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.header.StoreHouseHeader;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.MPagerAdapter;
import com.example.yidoutangdemo.adapter.TuiJianRVadapter;
import com.example.yidoutangdemo.bean.TuiJianEntity;
import com.example.yidoutangdemo.ui.DengLuActivity;
import com.example.yidoutangdemo.ui.JianHuoActivity;
import com.example.yidoutangdemo.ui.ShaiJiaActivity;
import com.example.yidoutangdemo.ui.XiangqingActivityi;
import com.example.yidoutangdemo.uri.UriInterface;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * Created by 天一 on 2016/10/31.
 */
public class TuiJianFragment extends BaseFragment implements View.OnClickListener{
    private RecyclerView recyclerview;
    private TuiJianRVadapter tuiJianRVadapter;
    private View headerView1;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private PtrFrameLayout ptrFrameLayout;

    private TuiJianEntity tuiJianEntity;
    public TuiJianFragment() {
    }

    public static TuiJianFragment newInstance() {

        Bundle args = new Bundle();

        TuiJianFragment fragment = new TuiJianFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.tuijianfragment,container,false);

        ptrFrameLayout= (PtrFrameLayout)rootView.findViewById(R.id.activity_tuijian_ptrFrameLayout);
        recyclerview = (RecyclerView) rootView.findViewById(R.id.fragment_tuijian_recyclerviewId);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        tuiJianRVadapter=new TuiJianRVadapter(getActivity());

        RecyclerAdapterWithHF adapter = new RecyclerAdapterWithHF(tuiJianRVadapter);
        //添加头布局1
        headerView1=inflater.inflate(R.layout.fragment_tuijian_header1,container,false);
        initHeaderView(inflater);
        tuiJianRVadapter.addHeaderView(headerView1);
        //添加头布局2
        View headerView2=inflater.inflate(R.layout.fragment_tuijian_header2,container,false);
        RelativeLayout shaiJia= (RelativeLayout) headerView2.findViewById(R.id.fragment_tuijian_headRelative1Id);
        RelativeLayout JianHuo= (RelativeLayout) headerView2.findViewById(R.id.fragment_tuijian_headRelative2Id);
        shaiJia.setOnClickListener(this);
        JianHuo.setOnClickListener(this);
        tuiJianRVadapter.addHeaderView(headerView2);
        /*tuiJianRVadapter.setOnClickCallBack(new OnClickCallBack() {
            @Override
            public void clickCallBack(String id) {
                Intent intent=new Intent(getActivity(), XiangqingActivityi.class);
                String url=String.format(UriInterface.SHAIJIAXIANGQING_URL,id);
                intent.putExtra("url",url);
                intent.putExtra("type",1);
                startActivity(intent);
            }
            @Override
            public void clickCallBack2(String id) {
                Intent intent=new Intent(getActivity(), XiangqingActivityi.class);
                String url=String.format(UriInterface.JIANHUOXIANGQING_URL,id);
                intent.putExtra("url",url);
                intent.putExtra("type",2);
                startActivity(intent);
            }

        });*/
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                Intent intent=new Intent(getActivity(), XiangqingActivityi.class);

                if (tuiJianRVadapter.getItem(position).getSubtype()!=null) {
                    String url = String.format(UriInterface.SHAIJIAXIANGQING_URL, tuiJianRVadapter.getItem(position).getId());
                    intent.putExtra("url", url);
                    intent.putExtra("type", 1);
                }else
                {
                    intent.putExtra("type", 2);
                }
                startActivity(intent);
            }
        });

        StoreHouseHeader ptrUIHandler = new StoreHouseHeader(getActivity());
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
                tuiJianRVadapter.clear();
                setData();
                //隐藏刷新进度
                frame.refreshComplete();
                //激活加载更多
                //frame.setLoadMoreEnable(true);
            }
        });
        /*ptrFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                page++;
                setData();
                //已经加载完成
                ptrFrameLayout.loadMoreComplete(true);
            }
        });*/
        setData();
        return rootView;
    }

    private void initHeaderView(LayoutInflater inflater) {
        //查找头布局的控件
        viewPager = ((ViewPager) headerView1.findViewById(R.id.fragment_tuijian_header_viewpagerId));
        linearLayout = ((LinearLayout) headerView1.findViewById(R.id.fragment_tuijian_header_linearLayout));
        //实例化ViewPager适配器
        ArrayList<View> views = new ArrayList<>();

        for (int i=0; i < linearLayout.getChildCount()*2; i++) {
            View view = inflater.inflate(R.layout.head_img, viewPager, false);
            ImageView imageView= (ImageView) view.findViewById(R.id.head_img);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getActivity(), DengLuActivity.class);
                    startActivity(intent);
                }
            });
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            setImgData(imageView,i%2);
            views.add(view);

            MPagerAdapter mPagerAdapter = new MPagerAdapter(views);
            //设置viewPager适配器
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

    private void setImgData(final ImageView imageView, final int i) {
        OkHttpUtils.get().url(UriInterface.TUIJIAN_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onResponse(String response, int id) {
                tuiJianEntity= JSON.parseObject(response,TuiJianEntity.class);
                Picasso.with(getActivity()).load(tuiJianEntity.getData().getBanner().get(i).getImage()).into(imageView);
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
        OkHttpUtils.get().url(UriInterface.TUIJIAN_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

                TuiJianEntity tuiJianEntity=JSON.parseObject(response,TuiJianEntity.class);
                tuiJianRVadapter.addAll(tuiJianEntity.getData().getRecommend());

            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {

            case R.id.fragment_tuijian_headRelative1Id:
                intent=new Intent(getActivity(), ShaiJiaActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_tuijian_headRelative2Id:
                intent=new Intent(getActivity(), JianHuoActivity.class);
                startActivity(intent);
                break;
        }

    }
}
