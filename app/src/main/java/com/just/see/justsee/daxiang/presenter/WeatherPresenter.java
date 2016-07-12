package com.just.see.justsee.daxiang.presenter;

import com.just.see.justsee.JsonBean.weather.WeatherBean;
import com.just.see.justsee.base.BasePresenter;
import com.just.see.justsee.daxiang.View.IDaXiangListView;
import com.just.see.justsee.http.WeatherHttpMethod;

import rx.Subscriber;

/**
 * Created by 何祥源 on 16/7/12.
 * Desc:
 */
public class WeatherPresenter extends BasePresenter {
    private IDaXiangListView view;
    private WeatherHttpMethod model;

    public WeatherPresenter(IDaXiangListView view) {
        this.view = view;
        model = WeatherHttpMethod.getInstance();
    }

    public void getWeather(String cityName) {
        compositeSubscription.add(model.getWeather(cityName)
                .subscribe(new Subscriber<WeatherBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        view.weatherLoaded(weatherBean);
                    }
                }));
    }
}
