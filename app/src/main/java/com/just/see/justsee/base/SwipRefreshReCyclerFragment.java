package com.just.see.justsee.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xiyoung on 16-10-12.
 */

public abstract class SwipRefreshReCyclerFragment extends JustSeeFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(getContext());
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(setLayoutManager());
        swipeRefreshLayout.addView(recyclerView);
        return swipeRefreshLayout;
    }

    protected abstract RecyclerView.LayoutManager setLayoutManager();
}
