package com.just.see.justsee.util;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by 何祥源 on 16/7/21.
 * Desc:
 */
public class SwipRefreshRecyclerView {
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    public SwipRefreshRecyclerView(SwipeRefreshLayout refreshLayout,
                                   RecyclerView recyclerView,
                                   SwipeRefreshLayout.OnRefreshListener refreshListener,
                                   final SwipRefreshRecyclerView.LoadMore loadMore) {
        this.refreshLayout = refreshLayout;
        this.recyclerView = recyclerView;
        if (refreshLayout == null || recyclerView == null)
            throw new NullPointerException("RecyclerView 和 SwipeRefreshLayout不能为空");
        refreshLayout.setOnRefreshListener(refreshListener);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
//                    ((StaggeredGridLayoutManager)layoutManager).findLastCompletelyVisibleItemPositions();
                }
                loadMore.loadMoreListenner();
            }
        });
    }

    interface LoadMore {
        void loadMoreListenner();
    }
}
