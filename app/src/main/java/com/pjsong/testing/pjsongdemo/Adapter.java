package com.pjsong.testing.pjsongdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pjsong.testing.pjsongdemo.inter.OnClickIndexRcyItem;

import java.util.List;

/**
 * Created by pjsong on 2017/12/5.
 */

public class Adapter extends RecyclerView.Adapter {
    private OnClickIndexRcyItem onClickIndexRcyItem;
    private List<String> mData;

    public void setOnClickIndexRcyItem(OnClickIndexRcyItem onClickIndexRcyItem){
        this.onClickIndexRcyItem = onClickIndexRcyItem;
    }

    public Adapter(List<String> mData){
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_adapter,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        h.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        public Holder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickIndexRcyItem != null){
                        onClickIndexRcyItem.clickItem(getAdapterPosition());
                    }
                }
            });
        }
    }
}
