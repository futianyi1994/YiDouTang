package com.example.yidoutangdemo.fragment.sousuofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.MyApp;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.SerachBaoBeiLVAdapter;
import com.example.yidoutangdemo.bean.GouWuEntity;
import com.example.yidoutangdemo.bean.SerachBaoBeiEntity;
import com.example.yidoutangdemo.fragment.BaseFragment;
import com.example.yidoutangdemo.uri.UriInterface;
import com.lidroid.xutils.exception.DbException;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 来来 on 2016/11/3.
 */
public class SerachBaobei extends BaseFragment {

    private String key;
//    private RecyclerView recyclerView;
    private ListView listView;
    private int page=1;
    private SerachBaoBeiLVAdapter serachBaoBeiLVAdapter;
    private SerachBaoBeiEntity serachBaoBeiEntity;

    public static SerachBaobei newInstance(String key) {

        Bundle args = new Bundle();
        args.putString("key",key);
        SerachBaobei fragment = new SerachBaobei();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.key=getArguments().getString("key");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_serach_baobei,container,false);

        listView= (ListView) view.findViewById(R.id.fragment_serach_baobei_listviewId);
        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);*/
        serachBaoBeiLVAdapter=new SerachBaoBeiLVAdapter(getActivity());
        listView.setAdapter(serachBaoBeiLVAdapter);

        /*serachBaoBeiAdapter.setOnItemClickListener(new SerachBaoBeiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
            }
        });*/

        // 为视图注册上下文菜单
        registerForContextMenu(listView);

        setData();
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, R.id.buymenu, Menu.NONE, "购买");
        menu.add(Menu.NONE, R.id.favmenu, Menu.NONE, "先加入购物车");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.buymenu:
                Toast.makeText(getActivity(),"购买成功！",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favmenu:
                // 获取使用适配器填充视图的相应菜单信息
                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                // 获取ListView的位置信息
                int position = menuInfo.position;
                String normal_image = serachBaoBeiEntity.getData().getSharings().get(position).getNormal_image();
                String title = serachBaoBeiEntity.getData().getSharings().get(position).getTitle();
                String price = serachBaoBeiEntity.getData().getSharings().get(position).getPrice();
                GouWuEntity gouWuEntity  = new GouWuEntity(normal_image,price,title);
                try {
                    MyApp.getApp().getDbUtils_buy().saveOrUpdate(gouWuEntity);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getActivity(),"已加入购物车！",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void setData() {
        OkHttpUtils.get().url(UriInterface.getSOUSUO_BAOBEI(key,page)).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onResponse(String response, int id) {
                serachBaoBeiEntity= JSON.parseObject(response,SerachBaoBeiEntity.class);
                serachBaoBeiLVAdapter.addAll(serachBaoBeiEntity.getData().getSharings());
            }
        });
    }
}
