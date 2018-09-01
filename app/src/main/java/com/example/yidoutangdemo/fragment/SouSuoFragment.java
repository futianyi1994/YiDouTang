package com.example.yidoutangdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yidoutangdemo.MyApp;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.SouSuoEntity;
import com.example.yidoutangdemo.ui.SearchActivity;
import com.lidroid.xutils.exception.DbException;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 天一 on 2016/10/31.
 */
public class SouSuoFragment extends BaseFragment{
    private TagFlowLayout reMenFlowLayout;
    private TagFlowLayout liShiFlowLayout;
    private List<String> reMenDatas;
    private List<String> liShiDatas;
    private List<SouSuoEntity> datas;
    private LinearLayout clear;
    private TagAdapter<SouSuoEntity> tagAdapter;
    private LayoutInflater inflater;

    public SouSuoFragment() {
    }

    public static SouSuoFragment newInstance() {

        Bundle args = new Bundle();

        SouSuoFragment fragment = new SouSuoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reMenDatas = new ArrayList<>();
        liShiDatas = new ArrayList<>();
        reMenDatas.add("美式");
        reMenDatas.add("简约");
        reMenDatas.add("北欧");
        reMenDatas.add("宜家");
        reMenDatas.add("榻榻米");
        reMenDatas.add("沙发");
        reMenDatas.add("收纳");
        reMenDatas.add("日式");
        reMenDatas.add("原木");
        reMenDatas.add("客厅");
        reMenDatas.add("厨房");
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sousuofragment, container, false);
        this.inflater = inflater;
        reMenFlowLayout = (TagFlowLayout) rootView.findViewById(R.id.item_sousuo_remen_flowlayoutId);
        liShiFlowLayout = (TagFlowLayout) rootView.findViewById(R.id.item_sousuo_lishi_flowlayoutId);
        clear = (LinearLayout) rootView.findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //清空搜索记录
                    MyApp.getApp().getDbUtils().deleteAll(datas);
                    datas.clear();
                    liShiFlowLayout.removeAllViews();
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });

        //点击事件
        reMenFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("search", reMenDatas.get(position));
                startActivity(intent);
                //把搜索记录到数据库
                SouSuoEntity souSuoEntity = new SouSuoEntity(reMenDatas.get(position));
                try {
                    MyApp.getApp().getDbUtils().saveOrUpdate(souSuoEntity);
                    datas.add(souSuoEntity);
                    liShiDatas.add(souSuoEntity.getSearch());
                } catch (DbException e) {
                    e.printStackTrace();
                }
                return true;
            }
        });

        liShiFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("search", liShiDatas.get(position));
                startActivity(intent);
                return true;
            }
        });
        return rootView;
    }

    //重新回到界面的时候刷新历史记录数据
    @Override
    public void onResume() {
        //设置reMenFlowLayout适配器加载数据
        reMenFlowLayout.setAdapter(new TagAdapter<String>(reMenDatas) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView textView = (TextView) inflater.inflate(R.layout.flowlayouttextiew, reMenFlowLayout, false);
                textView.setText(s);
                return textView;
            }
        });
        //设置liShiFlowLayout适配器加载数据
        try {
            datas = MyApp.getApp().getDbUtils().findAll(SouSuoEntity.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        liShiFlowLayout.setAdapter(new TagAdapter<SouSuoEntity>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, SouSuoEntity souSuoEntity) {
                TextView textView = (TextView) inflater.inflate(R.layout.flowlayouttextiew, liShiFlowLayout, false);
                textView.setText(souSuoEntity.getSearch());
                return textView;
            }
        });
        tagAdapter = new TagAdapter<SouSuoEntity>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, SouSuoEntity souSuoEntity) {
                TextView textView = (TextView) inflater.inflate(R.layout.flowlayouttextiew, liShiFlowLayout, false);
                textView.setText(souSuoEntity.getSearch());
                return textView;
            }
        };
        liShiFlowLayout.getAdapter().notifyDataChanged();
        super.onResume();
    }

}
