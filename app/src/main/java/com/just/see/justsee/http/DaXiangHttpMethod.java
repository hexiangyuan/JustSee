package com.just.see.justsee.http;

import com.just.see.justsee.json.daxiang.DaXiangInfo;
import com.just.see.justsee.json.daxiang.DaXiangList;
import com.just.see.justsee.api.urls.DaXiangUrl;
import com.just.see.justsee.api.service.DaXiangService;
import com.trello.rxlifecycle.components.support.RxFragment;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiyoung on 2016/7/8.
 */
public class DaXiangHttpMethod {
    private DaXiangService daXiangService = null;


    public DaXiangHttpMethod() {
        daXiangService = RetrofitHelper.setUrl(DaXiangUrl.DA_XIANG_URL).create(DaXiangService.class);
    }

    static class SingletonHolder {
        private static final DaXiangHttpMethod INSTANCE = new DaXiangHttpMethod();
    }

    public static DaXiangHttpMethod getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getDaXiangList(RxFragment activity, int pageSize, int page, Subscriber<DaXiangList> subscriber) {
        daXiangService.getDaXiangList(pageSize, page)
                .compose(activity.<DaXiangList>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public Subscription getDaXiangInfo(String id, Subscriber<DaXiangInfo> subscriber) {
        return daXiangService.getDaXiangInfo(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
