package com.just.see.justsee.qiushibaike.presenter;

import com.just.see.justsee.base.BasePresenter;
import com.just.see.justsee.jsonBean.QBBean.QBContent;
import com.just.see.justsee.qiushibaike.model.QBHttpMethod;
import com.just.see.justsee.qiushibaike.view.IQBListView;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by 何祥源 on 16/7/19.
 * Desc:
 */
public class QBListPresenter extends BasePresenter {

    private QBHttpMethod model;
    private IQBListView view;

    public QBListPresenter(IQBListView view) {
        this.view = view;
        model = QBHttpMethod.getInstance();
    }

    public void getQBListByCategory(String category, int page, int count) {
        view.showRefresh();
        Subscription subscription = model.loadQBListByCategory(category, page, count, new Subscriber<QBContent>() {
            @Override
            public void onCompleted() {
                view.hideRefresh();
                view.showCompleted();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(QBContent qbContent) {
                view.listLoaded(qbContent);
            }
        });
        compositeSubscription.add(subscription);
    }
}
