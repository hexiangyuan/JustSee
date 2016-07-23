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
    private SwipeRefreshLayout.OnRefreshListener refreshListener;
    private LoadMoreListener loadMoreListener;

    public SwipeRefreshLayout.OnRefreshListener getRefreshListener() {
        return refreshListener;
    }

    public void setRefreshListener(SwipeRefreshLayout.OnRefreshListener refreshListener) {
        this.refreshListener = refreshListener;
    }

    public LoadMoreListener getLoadMoreListener() {
        return loadMoreListener;
    }

    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public SwipeRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public void setRefreshLayout(SwipeRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public SwipRefreshRecyclerView() {
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
                int lastVisiblePos;
                int totalItemCount;
                if (layoutManager instanceof GridLayoutManager) {
                    lastVisiblePos = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    totalItemCount = layoutManager.getItemCount();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) layoutManager;
                    int[] into = new int[manager.getSpanCount()];
                    int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(into);
                    lastVisiblePos = finMax(lastVisibleItemPositions);
                    totalItemCount = layoutManager.getItemCount();
                } else if (layoutManager instanceof LinearLayoutManager) {
                    lastVisiblePos = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    totalItemCount = layoutManager.getItemCount();
                } else {
                    throw new ClassCastException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
                }
                if (lastVisiblePos >= totalItemCount - 1 && recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_IDLE && lastVisiblePos > 0) {
                    loadMoreListener.onLoadMore();
                }
            }
        });
    }

    private int finMax(int[] itemPositions) {
        int size = itemPositions.length;
        int temp = itemPositions[0];
        for (int i = 0; i < size; i++) {
            if (itemPositions[i] > temp) {
                temp = itemPositions[i];
            }
        }
        return temp;
    }

    interface LoadMoreListener {
        void onLoadMore();
    }


    public static class Builder {
        SwipRefreshRecyclerView swipRefreshRecyclerView;

        public Builder setRecyclerView(RecyclerView recyclerView) {
            swipRefreshRecyclerView.setRecyclerView(recyclerView);
            return this;
        }

        public Builder setSwipRefreshLayout(SwipeRefreshLayout swipRefreshLayout) {
            swipRefreshRecyclerView.setRefreshLayout(swipRefreshLayout);
            return this;
        }

        public Builder onRefreshing(SwipeRefreshLayout.OnRefreshListener refreshListener) {
            swipRefreshRecyclerView.setRefreshListener(refreshListener);
            return this;
        }

        public Builder onLoadMore(LoadMoreListener loadMore) {
            swipRefreshRecyclerView.setLoadMoreListener(loadMore);
            return this;
        }

        public void build() {
            this.swipRefreshRecyclerView = new SwipRefreshRecyclerView();
        }
    }
}
