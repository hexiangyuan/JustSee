package com.just.see.justsee.ezbuy;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.just.see.justsee.base.SwipRefreshReCyclerFragment;
import com.just.see.justsee.json.EzbuyProduct;

import java.util.ArrayList;

/**
 * Created by xiyoung on 16-10-12.
 */

public class EzbuyFragment extends SwipRefreshReCyclerFragment implements EzbuyContract.View {

    private EzbuyContract.Presenter mPresenter;

    public static EzbuyFragment newInstance() {
        return new EzbuyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new EzbuyPresenter(this);
        mPresenter.subscribe();
    }

    @Override
    public void showLoadingProgressBar(boolean show) {

    }

    @Override
    public void showLoadMore(boolean show) {

    }

    @Override
    public void showRefresh(boolean show) {

    }

    @Override
    public void showLoadProductError() {

    }

    @Override
    public void showProduct(ArrayList<EzbuyProduct> products) {

    }

    @Override
    public void setPresenter(EzbuyContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected RecyclerView.LayoutManager setLayoutManager() {
        return new LinearLayoutManager(getContext());
    }
}
