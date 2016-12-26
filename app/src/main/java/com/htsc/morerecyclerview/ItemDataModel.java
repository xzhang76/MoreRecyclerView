package com.htsc.morerecyclerview;

/**
 * 每个item数据的模型
 *
 * Created by zhangxiaoting on 2016/12/22.
 */
public class ItemDataModel {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    public int type;
    public int avatarColor;
    public String name;
    public String content;
    public int contentColor;

    public void setType(int type) {
        this.type = type;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }

    public int getType() {
        return type;
    }

    public int getAvatarColor() {
        return avatarColor;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getContentColor() {
        return contentColor;
    }
    
}
