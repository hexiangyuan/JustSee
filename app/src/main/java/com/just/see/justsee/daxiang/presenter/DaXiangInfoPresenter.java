package com.just.see.justsee.daxiang.presenter;

import com.just.see.justsee.jsonBean.daxiang.DaXiangInfo;
import com.just.see.justsee.base.BasePresenter;
import com.just.see.justsee.daxiang.View.IDaXiangInfoView;
import com.just.see.justsee.http.DaXiangHttpMethod;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by xiyoung on 2016/7/9.
 * 这是大象 detail的presenter
 */
public class DaXiangInfoPresenter extends BasePresenter{
    DaXiangHttpMethod model = null;
    IDaXiangInfoView view = null;
    Subscription subscription = null;

    public DaXiangInfoPresenter(IDaXiangInfoView view) {
        this.model = DaXiangHttpMethod.getInstance();
        this.view = view;
    }

    public void loadDaXiangInfo(String id) {
        subscription = model.getDaXiangInfo(id, new Subscriber<DaXiangInfo>() {
            @Override
            public void onStart() {
                super.onStart();
                view.showRefresh();
            }

            @Override
            public void onCompleted() {
                view.hideRefresh();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e);
            }

            @Override
            public void onNext(DaXiangInfo daXiangInfo) {
                view.daXiangInfoLoaded(daXiangInfo);
            }
        });
        compositeSubscription.add(subscription);
    }
}
