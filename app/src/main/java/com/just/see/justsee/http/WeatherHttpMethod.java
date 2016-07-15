package com.just.see.justsee.http;

import com.just.see.justsee.JsonBean.weather.WeatherBean;
import com.just.see.justsee.api.urls.WeatherUrl;
import com.just.see.justsee.api.service.WeatherService;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiyoung on 2016/7/11.
 */
public class WeatherHttpMethod {
    private WeatherService weatherService = null;

    public WeatherHttpMethod() {
        weatherService =   RetrofitHelper.setUrl(WeatherUrl.WEATHERURL).create(WeatherService.class);
    }

    static class SingletonHolder {
        private static final WeatherHttpMethod INSTANCE = new WeatherHttpMethod();
    }

    public static WeatherHttpMethod getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Observable<WeatherBean> getWeather(String cityName) {
        return weatherService.getWeather(2, cityName, WeatherUrl.KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io());
    }
}
