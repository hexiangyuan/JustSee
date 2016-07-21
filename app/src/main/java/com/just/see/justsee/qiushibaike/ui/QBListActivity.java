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
        listPresenter.getQBListByCategory("suggest", 1, 20);
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

    }

    @Override
    public void listLoaded(QBContent qbContent) {
        adapter.setLists(qbContent.items);
        adapter.notifyDataSetChanged();
    }
}
