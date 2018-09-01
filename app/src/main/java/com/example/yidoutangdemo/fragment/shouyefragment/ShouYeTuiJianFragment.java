package com.example.yidoutangdemo.fragment.shouyefragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.header.StoreHouseHeader;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
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
public class ShouYeTuiJianFragment extends BaseFragment implements AbsListView.OnScrollListener {
    private RecyclerView recyclerView;
    private PullToRefreshListView listView;
    private ShouYeTuiJianRVAdapter adapter;
    private ShouYeTuiJianLVAdapter listViewAdapter;
    private PtrFrameLayout ptrFrameLayout;
    private int page = 1;
    private String url_list;
    private Intent intent;
    private int LCposition = 0;
    private RecyclerAdapterWithHF adapterWithHF;
    private int RCposition = 0;

    private ShowTabCallback showTabCallback;
    private HideTabCallback hideTabCallback;
    private int dy;
    private boolean ifLogin;

    public ShouYeTuiJianFragment() {
    }

    public static ShouYeTuiJianFragment newInstance(boolean ifLogin) {

        Bundle args = new Bundle();
        args.putBoolean("ifLogin",ifLogin);
        ShouYeTuiJianFragment fragment = new ShouYeTuiJianFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        ifLogin = bundle.getBoolean("ifLogin");
        showTabCallback = (ShowTabCallback) context;
        hideTabCallback = (HideTabCallback) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.shouyetuijianfragment,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.shouyetuijianfragment_recyclerViewId);
        listView = (PullToRefreshListView) rootView.findViewById(R.id.shouyetuijianfragment_listViewId);
        ptrFrameLayout = (PtrFrameLayout) rootView.findViewById(R.id.shouyetuijianfragment_ptrFrameLayout);

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
                ShouYeTuiJianFragment.this.dy = dy;
            }
        });

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new ShouYeTuiJianRVAdapter(getContext());
        adapterWithHF = new RecyclerAdapterWithHF(adapter){
            //下拉跨行
            @Override
            public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
                super.onViewAttachedToWindow(holder);
                if (isStaggeredGridLayout(holder)) {
                    handleLayoutIfStaggeredGridLayout(holder, holder.getLayoutPosition());
                }
            }

            private boolean isStaggeredGridLayout(RecyclerView.ViewHolder holder) {
                ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
                if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                    return true;
                }
                return false;
            }

            protected void handleLayoutIfStaggeredGridLayout(RecyclerView.ViewHolder holder, int position) {
                if(position == adapter.getItemCount()){
                    StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
                    p.setFullSpan(true);
                }
            }
        };

        listViewAdapter = new ShouYeTuiJianLVAdapter(getContext());
        recyclerView.setAdapter(adapterWithHF);
        listView.setAdapter(listViewAdapter);

        //设置默认显示为recycleview隐藏listview
        listView.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
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

        StoreHouseHeader ptrUIHandler = new StoreHouseHeader(getContext());
        ptrUIHandler.initWithString("downLoader");
        ptrUIHandler.setTextColor(Color.rgb(253, 185, 52));
        /*MaterialHeader ptrUIHandler = new MaterialHeader(getContext());*/
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
        //设置下拉刷新
        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                adapter.clear();
                page=1;
                adapter.clear();
                loadData();
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
                loadData();
                //已经加载完成
                ptrFrameLayout.loadMoreComplete(true);
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
                LCposition = position/20*20;
                int page = position / 20 + 1;
                if ((position)%20 == 0){
                    LCposition = (position/20-1)*20;
                    page = position / 20;
                }
                if (position == 0){
                    LCposition = 0;
                    page = 1;
                }
                intent.putExtra("position",position-LCposition);
                intent.putExtra("flag", AppConfig.FLAG_LISTVIEW);
                intent.putExtra("url_list",UriInterface.getShouyeTuijian(page));
                intent.putExtra("ifLogin",ifLogin);
                startActivity(intent);
            }
        });
        url_list = UriInterface.getShouyeTuijian(page);
        OkHttpUtils.get().url(url_list).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                final ShouYeEntity shouYeEntity = JSON.parseObject(response, ShouYeEntity.class);
                adapter.addAll(shouYeEntity.getData().getPics());
                listViewAdapter.addAll(shouYeEntity.getData().getPics());
                listView.onRefreshComplete();

                adapterWithHF.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
                    @Override
                    public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                        intent = new Intent(getContext(), ShowDetailActivity.class);
                        RCposition = position/20*20;
                        int page = position / 20 + 1;
                        if ((position)%20 == 0){
                            RCposition = (position/20)*20;
                            page = position / 20+1;
                        }
                        Log.d("1607",position+"position");
                        Log.d("1607",RCposition+"RCposition");
                        Log.d("1607",page+""+"page");
                        ShouYeEntity.DataBean.PicsBean mItem = ShouYeTuiJianFragment.this.adapter.getMItem(position);
                        intent.putExtra("normal_image",mItem.getNormal_image());
                        intent.putExtra("case_title",mItem.getCase_title());
                        intent.putExtra("position",position-RCposition);
                        intent.putExtra("url_recycle",UriInterface.getShouyeTuijian(page));
                        intent.putExtra("flag", AppConfig.FLAG_RECYCLEVIEW);
                        intent.putExtra("ifLogin",ifLogin);
                        startActivity(intent);
                    }
                });
            }
        });
    }


    private int mLastFirstPostion;
    private int mLastFirstTop;
    private int touchSlop = 100;

   /* private boolean scrollFlag = false;// 标记是否滑动
    private int lastVisibleItemPosition;// 标记上次滑动位置*/
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        /*if (scrollState == SCROLL_STATE_TOUCH_SCROLL) {
            scrollFlag = true;
        } else {
            scrollFlag = false;
        }*/
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
                    Log.d("1606", "equals--->up");
                    showTabCallback.showFragmentTab();
                } else if (currentTop < mLastFirstTop) {
                    Log.d("1606", "equals--->down");
                    hideTabCallback.hideFragmentTab();
                }
                mLastFirstTop = currentTop;
            }
        }
        mLastFirstPostion = firstVisibleItem;
    }
}

