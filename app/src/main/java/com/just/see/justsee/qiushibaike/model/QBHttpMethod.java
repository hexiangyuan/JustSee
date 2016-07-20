package com.just.see.justsee.qiushibaike.model;

import com.just.see.justsee.api.service.QBService;
import com.just.see.justsee.api.urls.QBUrl;
import com.just.see.justsee.http.RetrofitHelper;
import com.just.see.justsee.json.QBBean.QBContent;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 何祥源 on 16/7/19.
 * Desc:
 */
public class QBHttpMethod {
    QBService service = null;
    private static QBHttpMethod INSTANCE = null;

    public static synchronized QBHttpMethod getInstance() {
        if (INSTANCE == null) INSTANCE = new QBHttpMethod();
        return INSTANCE;
    }

    private QBHttpMethod() {
        service = RetrofitHelper.setUrl(QBUrl.QB_URL).create(QBService.class);
    }


    public Subscription loadQBListByCategory(String category, int page, int count, Subscriber<QBContent> subscriber) {
        return service.getContentByCategory(category, page, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
