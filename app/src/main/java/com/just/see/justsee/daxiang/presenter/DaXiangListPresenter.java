package com.just.see.justsee.daxiang.presenter;

import com.just.see.justsee.JsonBean.daxiang.DaXiangList;
import com.just.see.justsee.daxiang.View.IDaXiangListView;
import com.just.see.justsee.http.DaXiangHttpMethod;

import rx.Subscriber;

/**
 * Created by xiyoung on 2016/7/9.
 */
public class DaXiangListPresenter {
    private DaXiangHttpMethod model = null;
    private IDaXiangListView view = null;

    public DaXiangListPresenter(IDaXiangListView view) {
        this.view = view;
        model = DaXiangHttpMethod.getInstance();
    }

    public void loadDaXiangList(int pageSize, final int page) {
        model.getDaXiangList(pageSize, page, new Subscriber<DaXiangList>() {
            @Override
            public void onStart() {
                super.onStart();
                showRefresh();
            }

            @Override
            public void onCompleted() {
                hideRefresh();
            }

            @Override
            public void onError(Throwable e) {
                hideRefresh();
                view.showError(e);
            }

            @Override
            public void onNext(DaXiangList daXiangList) {
                view.DaXiangListLoaded(daXiangList,page);
            }
        });
    }

    public void showRefresh() {
        view.showRefresh();
    }

    public void hideRefresh() {
        view.hideRefresh();
    }

}
