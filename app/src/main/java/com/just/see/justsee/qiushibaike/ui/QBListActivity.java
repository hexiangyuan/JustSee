package com.just.see.justsee.qiushibaike.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.just.see.justsee.R;
import com.just.see.justsee.base.JustSeeActivity;
import com.just.see.justsee.json.QBBean.QBContent;
import com.just.see.justsee.qiushibaike.presenter.QBListPresenter;
import com.just.see.justsee.qiushibaike.view.IQBListView;
import com.just.see.justsee.util.SwipeRefreshRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 何祥源 on 16/7/19.
 * Desc:
 */
public class QBListActivity extends JustSeeActivity implements IQBListView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout refreshLayout;
    QBListAdapter adapter;
    QBListPresenter listPresenter;
    SwipeRefreshRecyclerView.Builder builder;
    private int page = 1;
    private final int PAGE_COUNT = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_recycler);
        ButterKnife.bind(this);
        adapter = new QBListAdapter();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        listPresenter = new QBListPresenter(this);
        listPresenter.getQBListByCategory("suggest", 1, PAGE_COUNT);
        builder = new SwipeRefreshRecyclerView.Builder();
        builder.setRecyclerView(recyclerView).setSwipeRefreshLayout(refreshLayout).setOnLoadMore(new SwipeRefreshRecyclerView.LoadMoreListener() {
            @Override
            public void onLoadMore() {
                listPresenter.getQBListByCategory("suggest", page, PAGE_COUNT);
            }
        }).setOnRefreshing(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                listPresenter.getQBListByCategory("suggest", page, PAGE_COUNT);
            }
        }).build();
    }

    @Override
    public void showRefresh() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefresh() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(String msg) {
        Snackbar.make(recyclerView, msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showCompleted() {
        builder.finishLoad();
    }

    @Override
    public void listLoaded(QBContent qbContent) {
        if (qbContent != null && qbContent.items.size() > 0) {
            if (page == 1) {
                adapter.setLists(qbContent.items);
                page++;
            } else if (page > 1) {
                adapter.addLists(qbContent.items);
                page++;
            }
        }
    }
}
