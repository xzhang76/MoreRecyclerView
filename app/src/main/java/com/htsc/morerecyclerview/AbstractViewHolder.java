package com.htsc.morerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 三种ViewHolder的抽象类ViewHolder
 * Created by zhangxiaoting on 2016/12/22.
 */
public abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder{


    public AbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(T itemDataModel);
}
