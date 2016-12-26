package com.htsc.morerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 适用于RecyclerView的adapter
 *
 * Created by zhangxiaoting on 2016/12/22.
 */
public class MoreRecyclerViewAdapter extends RecyclerView.Adapter<AbstractViewHolder>{
    private LayoutInflater mInflater;
    private List<ItemDataModelOne> mList1 = new ArrayList<>();
    private List<ItemDataModelTwo> mList2 = new ArrayList<>();
    private List<ItemDataModelThree> mList3 = new ArrayList<>();


    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    /**
     *  mTypes是一个列表, 按照位置存放了每个item的类型
     */
    private List<Integer> mTypes = new ArrayList<>();
    /**
     * mFirstPositions存放了三种数据类型item列表的起始位置
     * 所以它应该是三个成员，对应每种数据类型存放对应的数据列表的起始位置
     */
    private Map<Integer, Integer> mFirstPositions = new HashMap<>();

    public MoreRecyclerViewAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void addList(List<ItemDataModelOne> list1, List<ItemDataModelTwo> list2, List<ItemDataModelThree> list3) {
        this.mList1 = list1;
        this.mList2 = list2;
        this.mList3 = list3;
        // 为三种类型的数据列表分别置顶type类型，并初始化每个列表的初始位置
        addListByType(TYPE_ONE, list1);
        addListByType(TYPE_TWO, list2);
        addListByType(TYPE_THREE, list3);
    }

    private void addListByType(int type, List list) {
        mFirstPositions.put(type, mTypes.size());
        for (int i = 0; i < list.size(); i++) {
            mTypes.add(type);
        }
    }

    @Override
    public AbstractViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AbstractViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_ONE:
                viewHolder = new TypeOneViewHolder(mInflater.inflate(R.layout.item_type_one, parent, false));
                break;
            case TYPE_TWO:
                viewHolder = new TypeTwoViewHolder(mInflater.inflate(R.layout.item_type_two, parent, false));
                break;
            case TYPE_THREE:
                viewHolder = new TypeThreeViewHolder(mInflater.inflate(R.layout.item_type_three, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AbstractViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int realPosition = position - mFirstPositions.get(viewType);
        switch (viewType) {
            case TYPE_ONE:
                holder.bindViewHolder(mList1.get(realPosition));
                break;
            case TYPE_TWO:
                holder.bindViewHolder(mList2.get(realPosition));
                break;
            case TYPE_THREE:
                holder.bindViewHolder(mList3.get(realPosition));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mTypes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mTypes.get(position);
    }
}
