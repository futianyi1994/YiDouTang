package com.example.yidoutangdemo.fragment.shouyefragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.adapter.ShouYeTuiJianLVAdapter;
import com.example.yidoutangdemo.adapter.ShouYeTuiJianRVAdapter;
import com.example.yidoutangdemo.bean.ShouYeEntity;
import com.example.yidoutangdemo.callback.HideTabCallback;
import com.example.yidoutangdemo.callback.ShowTabCallback;
import com.example.yidoutangdemo.config.AppConfig;
import com.example.yidoutangdemo.fragment.BaseFragment;
import com.example.yidoutangdemo.ui.ShowDetailActivity;
import com.example.yidoutangdemo.uri.UriInterface;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 天一 on 2016/10/31.
 */
public class ShouYeZuiXinFragment extends BaseFragment implements AbsListView.OnScrollListener{
    private RecyclerView recyclerView;
    private PullToRefreshListView listView;
    private ShouYeTuiJianRVAdapter adapter;
    private ShouYeTuiJianLVAdapter listViewAdapter;
    private int page = 1;
    private String url_list;
    private Intent intent;
    private int Cposition = 0;

    private ShowTabCallback showTabCallback;
    private HideTabCallback hideTabCallback;
    private int dy;

    public ShouYeZuiXinFragment() {
    }

    public static ShouYeZuiXinFragment newInstance() {

        Bundle args = new Bundle();

        ShouYeZuiXinFragment fragment = new ShouYeZuiXinFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        showTabCallback = (ShowTabCallback) context;
        hideTabCallback = (HideTabCallback) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.shouyezuixinfragment,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.shouyezuixinfragment_recyclerViewId);
        listView = (PullToRefreshListView) rootView.findViewById(R.id.shouyezuixinfragment_listViewId);

        listView.setOnScrollListener(this);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == SCROLL_STATE_IDLE) {
                    if (dy>0){
                        hideTabCallback.hideFragmentTab();
                    }else if (dy<0){
                        showTabCallback.showFragmentTab();
                    }
                }
                if (newState == SCROLL_STATE_FLING){
                    if (dy>0){
                        hideTabCallback.hideFragmentTab();
                    }else if (dy<0){
                        showTabCallback.showFragmentTab();
                    }
                }
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                ShouYeZuiXinFragment.this.dy = dy;
            }
        });

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new ShouYeTuiJianRVAdapter(getContext());
        recyclerView.setAdapter(adapter);
        adapter.setItemOnClick(new ShouYeTuiJianRVAdapter.itemOnClick() {
            @Override
            public void onClick(String url, int position, String normal_image) {
                Cposition = position/21*20;
                int page = position / 21 + 1;
                if ((position-1)%20 == 0){
                    Cposition = position/20*20;
                    page = position / 20 + 1;
                }
                intent = new Intent(getContext(), ShowDetailActivity.class);
                intent.putExtra("normal_image",normal_image);
                intent.putExtra("position",position-Cposition);
                intent.putExtra("url_recycle",UriInterface.getShouyeZuixin(page));
                intent.putExtra("flag", AppConfig.FLAG_RECYCLEVIEW);
                getContext().startActivity(intent);
            }
        });
        listViewAdapter = new ShouYeTuiJianLVAdapter(getContext());
        listView.setAdapter(listViewAdapter);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                listViewAdapter.clear();
                loadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                loadData();
            }
        });

        loadData();
        return rootView;
    }

    private void loadData() {
        intent = new Intent(getContext(), ShowDetailActivity.class);
        //listview点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cposition = position/20*20;
                int page = position / 20 + 1;
                if ((position)%20 == 0){
                    Cposition = (position/20-1)*20;
                    page = position / 20;
                }
                if (position == 0){
                    Cposition = 0;
                    page = 1;
                }
                intent.putExtra("position",position-Cposition);
                intent.putExtra("flag", AppConfig.FLAG_LISTVIEW);
                intent.putExtra("url_list",UriInterface.getShouyeZuixin(page));
                startActivity(intent);
            }
        });
        url_list = UriInterface.getShouyeZuixin(page);
        OkHttpUtils. get().url(url_list).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                ShouYeEntity shouYeEntity = JSON.parseObject(response, ShouYeEntity.class);
                adapter.addAll(shouYeEntity.getData().getPics());
                adapter.addUrl(UriInterface.getShouyeZuixin(page));
                listViewAdapter.addAll(shouYeEntity.getData().getPics());
                listView.onRefreshComplete();
            }
        });
    }

    private int mLastFirstPostion;
    private int mLastFirstTop;
    private int touchSlop = 100;
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int currentTop;
        View firstChildView = absListView.getChildAt(0);
        if (firstChildView != null) {
            currentTop = absListView.getChildAt(0).getTop();
        } else {
            //ListView初始化的时候会回调onScroll方法，此时getChildAt(0)仍是为空的
            return;
        }
        //判断上次可见的第一个位置和这次可见的第一个位置
        if (firstVisibleItem != mLastFirstPostion) {
            //不是同一个位置
            if (firstVisibleItem > mLastFirstPostion) {
                Log.d("1606", "--->down");
                hideTabCallback.hideFragmentTab();
            } else {
                Log.d("1606", "--->up");
                showTabCallback.showFragmentTab();
            }
            mLastFirstTop = currentTop;
        } else {
            //是同一个位置
            if(Math.abs(currentTop - mLastFirstTop) > touchSlop){
                //避免动作执行太频繁或误触，加入touchSlop判断，具体值可进行调整
                if (currentTop > mLastFirstTop) {
                    Log.d("1607", "equals--->up");
                    showTabCallback.showFragmentTab();
                } else if (currentTop < mLastFirstTop) {
                    Log.d("1607", "equals--->down");
                    hideTabCallback.hideFragmentTab();
                }
                mLastFirstTop = currentTop;
            }
        }
        mLastFirstPostion = firstVisibleItem;
    }

}
