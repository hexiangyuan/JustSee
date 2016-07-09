package com.just.see.justsee.http;

import com.just.see.justsee.JsonBean.daxiang.DaXiangInfo;
import com.just.see.justsee.JsonBean.daxiang.DaXiangList;
import com.just.see.justsee.api.DaXiangUrl;
import com.just.see.justsee.api.service.DaXiangService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiyoung on 2016/7/8.
 */
public class DaXiangHttpMethod extends HttpMethod {
    private Retrofit retrofit = null;
    private DaXiangService daXiangService = null;

    @Override
    public void setRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(DaXiangUrl.DA_XIANG_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        daXiangService = retrofit.create(DaXiangService.class);
    }

    public DaXiangHttpMethod() {
        super();
        setRetrofit();
    }

    static class SingletonHolder {
        private static final DaXiangHttpMethod INSTANCE = new DaXiangHttpMethod();
    }

    public static DaXiangHttpMethod getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getDaXiangList(int pageSize, int page, Subscriber<DaXiangList> subscriber) {
        daXiangService.getDaXiangList(pageSize, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getDaXiangInfo(String id, Subscriber<DaXiangInfo> subscriber) {
        daXiangService.getDaXiangInfo(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
