package com.htsc.morerecyclerview;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhangxiaoting on 2016/12/22.
 */
public class TypeTwoViewHolder extends AbstractViewHolder<ItemDataModelTwo> {
    public ImageView avatar;
    public TextView name;
    public TextView content;

    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void bindViewHolder(ItemDataModelTwo itemDataModel) {
        avatar.setImageResource(itemDataModel.getAvatarColor());
        name.setText(itemDataModel.getName());
        content.setText(itemDataModel.getContent());
    }
}
