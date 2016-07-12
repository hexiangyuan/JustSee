package com.just.see.justsee.daxiang.presenter;

import android.util.Log;

import com.just.see.justsee.JsonBean.weather.WeatherBean;
import com.just.see.justsee.daxiang.View.IDaXiangListView;
import com.just.see.justsee.http.WeatherHttpMethod;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by 何祥源 on 16/7/12.
 * Desc:
 */
public class WeatherPresenter {
    private IDaXiangListView view;
    private WeatherHttpMethod model;

    public WeatherPresenter(IDaXiangListView view) {
        this.view = view;
        model = WeatherHttpMethod.getInstance();
    }

    public Subscription getWeather(String cityName) {
        return model.getWeather(cityName)
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
                });
    }
}
