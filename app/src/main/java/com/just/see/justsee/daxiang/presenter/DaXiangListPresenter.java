package com.just.see.justsee.daxiang.presenter;

import com.just.see.justsee.json.daxiang.DaXiangList;
import com.just.see.justsee.daxiang.View.IDaXiangListView;
import com.just.see.justsee.http.DaXiangHttpMethod;
import com.trello.rxlifecycle.components.support.RxFragment;

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
        model.getDaXiangList((RxFragment)view,pageSize, page, new Subscriber<DaXiangList>() {
            @Override
            public void onStart() {
                super.onStart();
                showRefresh();
            }

            @Override
            public void onCompleted() {
                hideRefresh();
                view.daXiangLoadCompleted();
            }

            @Override
            public void onError(Throwable e) {
                hideRefresh();
                view.showError(e);
            }

            @Override
            public void onNext(DaXiangList daXiangList) {
                if(page == 1){
                    view.reFreshData(daXiangList);
                }else{
                    view.loadMoreData(daXiangList);
                }
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
