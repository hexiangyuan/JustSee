package com.just.see.justsee.daxiang.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.just.see.justsee.JsonBean.daxiang.DaXiangList;
import com.just.see.justsee.base.JustSeeFragment;
import com.just.see.justsee.daxiang.View.IDaXiangListView;
import com.just.see.justsee.daxiang.presenter.DaXiangListPresenter;
import com.just.see.justsee.util.ToastUtil;

import java.util.List;

/**
 * Created by xiyoung on 2016/7/8.
 * JustSeeFragment
 */
public class DaXiangFragment extends JustSeeFragment implements IDaXiangListView {
    private RecyclerView recyclerView;
    private DaXiangListAdapter adapter;
    private DaXiangList daXiangList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<DaXiangList.Body.Article> articles;
    private int page = 0;
    private final static int PAGE_SIZE = 20;
    DaXiangListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        swipeRefreshLayout = new SwipeRefreshLayout(getContext());
        recyclerView = new RecyclerView(getContext());
        swipeRefreshLayout.addView(recyclerView);
        return swipeRefreshLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new DaXiangListPresenter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DaXiangListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        presenter.loadDaXiangList(PAGE_SIZE,page);
    }

    @Override
    public void DaXiangListLoaded(DaXiangList daXiangList, int page) {
        if (daXiangList != null && daXiangList.body != null && daXiangList.body.article != null) {
            if (page == 0) {
                articles = daXiangList.body.article;
                adapter.setAdapterDate(articles);
                adapter.notifyDataSetChanged();
            }
            if (page > 0) {
                int fromPosition = articles.size();
                articles.addAll(daXiangList.body.article);
                adapter.setAdapterDate(articles);
                adapter.notifyItemMoved(fromPosition, fromPosition + daXiangList.body.article.size());
            }
            page++;
        }
    }

    @Override
    public void showRefresh() {
        if (!swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideRefresh() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showError(Throwable e) {
        ToastUtil.showLongToast(e.getMessage());
    }
}
