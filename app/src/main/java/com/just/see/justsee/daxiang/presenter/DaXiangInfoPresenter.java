package com.just.see.justsee.daxiang.presenter;

import com.just.see.justsee.JsonBean.daxiang.DaXiangInfo;
import com.just.see.justsee.daxiang.View.IDaXiangInfoView;
import com.just.see.justsee.http.DaXiangHttpMethod;

import rx.Subscriber;

/**
 * Created by xiyoung on 2016/7/9.
 * 这是大象 detail的presenter
 */
public class DaXiangInfoPresenter {
    DaXiangHttpMethod model = null;
    IDaXiangInfoView view = null;

    public DaXiangInfoPresenter(IDaXiangInfoView view) {
        this.model = DaXiangHttpMethod.getInstance();
        this.view = view;
    }

    public void loadDaXiangInfo(String id) {
        model.getDaXiangInfo(id, new Subscriber<DaXiangInfo>() {
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
    }
}
