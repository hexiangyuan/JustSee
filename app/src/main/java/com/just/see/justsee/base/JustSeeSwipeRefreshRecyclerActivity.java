package com.just.see.justsee.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public abstract class JustSeeSwipeRefreshRecyclerActivity extends JustSeeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(this);
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(setLayoutManager());
        swipeRefreshLayout.addView(recyclerView);
        setContentView(swipeRefreshLayout);
    }

    protected abstract RecyclerView.LayoutManager setLayoutManager();
}
