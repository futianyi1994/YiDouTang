package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.TuiJianEntity;
import com.example.yidoutangdemo.utils.OnClickCallBack;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by 天一 on 2016/10/31.
 */
    public class TuiJianRVadapter extends RecyclerView.Adapter {
        private static final int BODY2_TYPE = 3;
    private Context context;
    private List<TuiJianEntity.DataBean.RecommendBean> datas;
    private OnClickCallBack onClickCallBack;

    public void setOnClickCallBack(OnClickCallBack onClickCallBack) {
        this.onClickCallBack = onClickCallBack;
    }


        private LayoutInflater inflater;
        public static final int HEAD_TYPE = 0;
        public static final int FOOT_TYPE = 1;
        public static final int BODY_TYPE = 2;


        public TuiJianRVadapter(Context context) {
            this.datas = new ArrayList<>();
            this.inflater = LayoutInflater.from(context);
            footers = new ArrayList<>();
            headers = new ArrayList<>();
            this.context=context;
            headIndex = 0;
            footIndex = 0;
        }
        int headIndex;
        int footIndex;
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = null;
            switch (viewType) {
                case HEAD_TYPE:
                    view = headers.get(headIndex++);
                    break;
                case BODY_TYPE:
                    view = inflater.inflate(R.layout.item_tuijian, parent, false);
                    break;
                case FOOT_TYPE:
                    view = footers.get(footIndex++);
                    break;
            }
            return new ViewHolder(view);
        }
        /**
         * 返回对应位置的item类型
         *
         * @param position
         * @return
         */
        @Override
        public int getItemViewType(int position) {
            if (position < headers.size()) {
                return HEAD_TYPE;
            } else if (position+1 > getItemCount() - footers.size()) {
                return FOOT_TYPE;
            }
            return BODY_TYPE;
        }
        private List<View> headers;
        private List<View> footers;
        public void addHeaderView(View headerView) {

            headers.add(headerView);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            switch (getItemViewType(position)) {
                case HEAD_TYPE:
                    break;
                case BODY_TYPE:
                    ViewHolder viewHolder = (ViewHolder) holder;
                    viewHolder.userName.setText(datas.get(position).getAuthor());
                    viewHolder.mainTextView.setText(datas.get(position).getSubject());
                    viewHolder.sharingnum.setText(datas.get(position).getSharing_num());
                    viewHolder.clicknum.setText(datas.get(position).getClick_num());

                    Picasso.with(context).load(datas.get(position).getCover()).into(viewHolder.mainImg);
                    Picasso.with(context).load(datas.get(position).getUser_pic()).transform(new CropCircleTransformation()).into(viewHolder.userpic);
                    break;
                case FOOT_TYPE:
                    break;
            }
        }



        @Override
        public int getItemCount() {
            return datas.size() + footers.size()+headers.size()-2;
        }

        public void addAll(List<TuiJianEntity.DataBean.RecommendBean> dd) {
            datas.addAll(dd);
            notifyDataSetChanged();
        }

    public TuiJianEntity.DataBean.RecommendBean getItem(int i) {
        return datas.get(i);
    }

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView mainImg;
            private ImageView userpic;
            private TextView userName;
            private TextView clicknum;
            private TextView sharingnum;
            private TextView mainTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                mainImg= (ImageView) itemView.findViewById(R.id.item_tuijian_mainImg);
                userpic= (ImageView) itemView.findViewById(R.id.item_tuijian_userpic);
                userName= (TextView) itemView.findViewById(R.id.item_tuijian_username);
                clicknum= (TextView) itemView.findViewById(R.id.item_tuijian_clicknum);
                sharingnum= (TextView) itemView.findViewById(R.id.item_tuijian_sharingnum);
                mainTextView= (TextView) itemView.findViewById(R.id.item_tuijian_mainTextView);
            }
        }



    }