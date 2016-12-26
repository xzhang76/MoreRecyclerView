package com.htsc.morerecyclerview;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhangxiaoting on 2016/12/22.
 */
public class TypeOneViewHolder extends AbstractViewHolder<ItemDataModelOne> {
    public ImageView avatar;
    public TextView name;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    public void bindViewHolder(ItemDataModelOne itemDataModel) {
        avatar.setImageResource(itemDataModel.getAvatarColor());
        name.setText(itemDataModel.getName());
    }
}
