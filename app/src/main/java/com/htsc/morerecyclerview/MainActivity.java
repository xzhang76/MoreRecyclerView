package com.htsc.morerecyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MoreRecyclerViewAdapter mAdapter;

    private int mColors[] = {android.R.color.holo_blue_dark, android.R.color.holo_green_light,
            android.R.color.holo_orange_light};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int itemType = mRecyclerView.getAdapter().getItemViewType(position);
                if (MoreRecyclerViewAdapter.TYPE_THREE == itemType) {
                    return layoutManager.getSpanCount(); // 2
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(layoutManager);

//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize(); // 一行占两列的itemView自己所占列数为1
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != layoutManager.getSpanCount()) {
                    // 一行占两列的itemView自己所占列数为1
                    if (spanIndex == 1) {
                        outRect.left = 10;
                    } else {
                        outRect.right = 10;
                    }
                }
            }
        });
        mAdapter = new MoreRecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        List<ItemDataModelOne> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemDataModelOne item = new ItemDataModelOne();
            item.setAvatarColor(mColors[0]);
            item.setName("name: " + i);
            list1.add(item);
        }
        List<ItemDataModelTwo> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemDataModelTwo item = new ItemDataModelTwo();
            item.setAvatarColor(mColors[1]);
            item.setName("name: " + i);
            item.setContent("content: ");
            list2.add(item);
        }
        List<ItemDataModelThree> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemDataModelThree item = new ItemDataModelThree();
            item.setAvatarColor(mColors[2]);
            item.setName("name: " + i);
            item.setContent("content: ");
            item.setContentColor(mColors[2]);
            list3.add(item);
        }

        mAdapter.addList(list1, list2, list3);
        mAdapter.notifyDataSetChanged();
    }
}
