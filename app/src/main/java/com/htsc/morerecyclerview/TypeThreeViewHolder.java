package com.htsc.morerecyclerview;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhangxiaoting on 2016/12/22.
 */
public class TypeThreeViewHolder extends AbstractViewHolder<ItemDataModelThree> {
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
        contentImage = (ImageView) itemView.findViewById(R.id.content_image);
        itemView.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public void bindViewHolder(ItemDataModelThree itemDataModel) {
        avatar.setImageResource(itemDataModel.getAvatarColor());
        name.setText(itemDataModel.getName());
        content.setText(itemDataModel.getContent());
        contentImage.setImageResource(itemDataModel.getContentColor());
    }
}
