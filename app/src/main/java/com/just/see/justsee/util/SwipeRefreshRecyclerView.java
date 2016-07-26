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
public class SwipeRefreshRecyclerView {
    private boolean isLoading;//记录是正在Loading；

    public SwipeRefreshRecyclerView(RecyclerView recyclerView,
                                    SwipeRefreshLayout refreshLayout,
                                    final LoadMoreListener loadMoreListener,
                                    SwipeRefreshLayout.OnRefreshListener refreshListener) {
        if (refreshLayout == null || recyclerView == null)
            throw new NullPointerException("RecyclerView 和 SwipeRefreshLayout不能为空");
        refreshLayout.setOnRefreshListener(refreshListener);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
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
                if (lastVisiblePos >= totalItemCount - 1
                        && newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisiblePos > 0
                        && !isLoading
                        ) {
                    isLoading = true;
                    loadMoreListener.onLoadMore();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

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

    public interface LoadMoreListener {
        void onLoadMore();
    }


    public static class Builder {
        SwipeRefreshRecyclerView swipeRefreshRecyclerView;
        RecyclerView recyclerView;
        SwipeRefreshLayout refreshLayout;
        LoadMoreListener loadMoreListener;
        SwipeRefreshLayout.OnRefreshListener refreshListener;


        public Builder setRecyclerView(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
            return this;
        }

        public Builder setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
            this.refreshLayout = swipeRefreshLayout;
            return this;
        }

        public Builder setOnRefreshing(SwipeRefreshLayout.OnRefreshListener refreshListener) {
            this.refreshListener = refreshListener;
            return this;
        }

        public Builder setOnLoadMore(LoadMoreListener loadMore) {
            this.loadMoreListener = loadMore;
            return this;
        }

        public Builder finishLoad() {
            if (swipeRefreshRecyclerView == null) {
                throw new RuntimeException("在finish 之前请先build;");
            }
            swipeRefreshRecyclerView.isLoading = false;
            return this;
        }

        public void build() {
            this.swipeRefreshRecyclerView = new SwipeRefreshRecyclerView(recyclerView, refreshLayout, loadMoreListener, refreshListener);
        }
    }
}
