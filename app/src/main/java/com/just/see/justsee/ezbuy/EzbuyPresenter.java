package com.just.see.justsee.ezbuy;

import com.just.see.justsee.http.EzbuyModel;
import com.just.see.justsee.json.EzbuyProduct;

import java.util.ArrayList;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public class EzbuyPresenter implements EzbuyContract.Presenter {
    private final EzbuyContract.View mEzbuyView;
    private final EzbuyModel ezbuyModel;
    private CompositeSubscription mSubscriptions;

    public EzbuyPresenter(EzbuyContract.View view) {
        this.mEzbuyView = view;
        this.ezbuyModel = new EzbuyModel();
        mSubscriptions = new CompositeSubscription();
        mEzbuyView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        mEzbuyView.showLoadingProgressBar(true);
        loadProducts(0, 20);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void loadProducts(int offset, int limit) {
        Subscription subscribe = ezbuyModel.getEzbuyProducts(offset, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ArrayList<EzbuyProduct>>() {
                    @Override
                    public void onCompleted() {
                        mEzbuyView.showLoadingProgressBar(false);
                        mEzbuyView.showLoadMore(false);
                        mEzbuyView.showRefresh(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mEzbuyView.showLoadProductError();
                    }

                    @Override
                    public void onNext(ArrayList<EzbuyProduct> ezbuyProducts) {
                        mEzbuyView.showProduct(ezbuyProducts);
                    }
                });
        mSubscriptions.add(subscribe);
    }
}
