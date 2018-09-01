package com.example.yidoutangdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.bean.ShaiXuanEntity;
import com.example.yidoutangdemo.callback.IntentCallback;
import com.example.yidoutangdemo.ui.KanTuActivity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

/**
 * Created by 天一 on 2016/11/1.
 */
public class ShaiXuanAdaper extends MBaseAdapter<ShaiXuanEntity.DataBean.TagsBean>{
    private Context context;
    private Intent intent;
    private IntentCallback intentCallback;

    public void setIntentCallback(IntentCallback intentCallback) {
        this.intentCallback = intentCallback;
    }

    public ShaiXuanAdaper(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = getInflater().inflate(R.layout.item_shaixuan_activity,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ShaiXuanEntity.DataBean.TagsBean item = getItem(position);
        viewHolder.textView.setText(item.getName());
        //flowLayout
        viewHolder.flowLayout.setAdapter(new FlowLayoutAdapter(getDatas().get(position).getSonTags(),context,viewHolder.flowLayout));
        intent = new Intent(context,KanTuActivity.class);
        viewHolder.flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int p, FlowLayout parent) {
                if (position == 0){
                    intent.putExtra("order",getItem(0).getSonTags().get(p).getValue());
                }else if (position == 1){
                    intent.putExtra("space",getItem(1).getSonTags().get(p).getTitle());
                }else if (position == 2){
                    intent.putExtra("style",getItem(2).getSonTags().get(p).getTitle());
                }else if (position == 3){
                    intent.putExtra("part",getItem(3).getSonTags().get(p).getTitle());
                }
                return true;
            }
        });
        intentCallback.onClick(intent);
        return convertView;
    }
    class ViewHolder{
        TextView textView;
        TagFlowLayout flowLayout;
        public ViewHolder(View convertView){
            textView = (TextView) convertView.findViewById(R.id.item_shaixuan_textviewId);
            flowLayout = (TagFlowLayout) convertView.findViewById(R.id.item_shaixuan_flowlayoutId);
        }

    }
}
