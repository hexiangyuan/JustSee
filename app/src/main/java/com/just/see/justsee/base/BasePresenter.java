package com.just.see.justsee.base;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by xiyoung on 2016/7/12.
 */
public abstract class BasePresenter {
    protected CompositeSubscription compositeSubscription = new CompositeSubscription();

    public void unsubscribe() {
        if (compositeSubscription != null && !compositeSubscription.isUnsubscribed())
            compositeSubscription.unsubscribe();
    }
}
