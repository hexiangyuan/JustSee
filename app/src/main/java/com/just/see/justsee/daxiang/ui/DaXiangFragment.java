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
public class DaXiangFragment extends JustSeeFragment implements IDaXiangListView, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private DaXiangListAdapter adapter;
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
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        adapter = new DaXiangListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisiblePos = manager.findFirstCompletelyVisibleItemPosition() + recyclerView.getChildCount();
                int itemCount = manager.getItemCount();
                if ((lastVisiblePos) >= itemCount - 1) {
                    presenter.loadDaXiangList(PAGE_SIZE, page);
                }
            }
        });
        presenter.loadDaXiangList(PAGE_SIZE, page);
    }

    @Override
    public void reFreshData(DaXiangList daXiangList) {
        if (daXiangList != null && daXiangList.body != null && daXiangList.body.article != null) {
            articles = daXiangList.body.article;
            adapter.setAdapterDate(articles);
            adapter.notifyDataSetChanged();
            this.page++;
        }
    }

    @Override
    public void loadMoreData(DaXiangList daXiangList) {
        if (daXiangList != null && daXiangList.body != null && daXiangList.body.article != null) {
            int fromPosition = articles.size();
            articles.addAll(daXiangList.body.article);
            adapter.setAdapterDate(articles);
            adapter.notifyItemMoved(fromPosition, fromPosition + daXiangList.body.article.size());
            this.page++;
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

    @Override
    public void onRefresh() {
        page = 0;
        presenter.loadDaXiangList(PAGE_SIZE, page);
    }
}
