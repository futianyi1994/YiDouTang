package com.example.yidoutangdemo.fragment.sousuofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.SerachShaiJiaAdapter;
import com.example.yidoutangdemo.bean.SerachShaiJiaEntity;
import com.example.yidoutangdemo.fragment.BaseFragment;
import com.example.yidoutangdemo.uri.UriInterface;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 来来 on 2016/11/3.
 */
public class SerachShaiJia extends BaseFragment {
    private String key;

    public static SerachShaiJia newInstance(String key) {

        Bundle args = new Bundle();
        args.putString("key",key);
        SerachShaiJia fragment = new SerachShaiJia();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.key=getArguments().getString("key");
    }

    private RecyclerView recyclerView;
    private int page=1;
    private SerachShaiJiaAdapter shaiJiaRVadapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_serach_shaijia,container,false);

        recyclerView= (RecyclerView) view.findViewById(R.id.fragment_serach_shaijia_recyclerviewId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        shaiJiaRVadapter=new SerachShaiJiaAdapter(getActivity());

        recyclerView.setAdapter(shaiJiaRVadapter);

        setData();
        return view;
    }
    private void setData() {
        OkHttpUtils.get().url(UriInterface.getSOUSUO_SHAIJIA(key,page)).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onResponse(String response, int id) {
                SerachShaiJiaEntity serachShaiJiaEntity= JSON.parseObject(response,SerachShaiJiaEntity.class);

                shaiJiaRVadapter.addAll(serachShaiJiaEntity.getData().getCases());
            }
        });
    }
}
