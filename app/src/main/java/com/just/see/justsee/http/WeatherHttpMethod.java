package com.just.see.justsee.http;

import com.just.see.justsee.JsonBean.weather.WeatherBean;
import com.just.see.justsee.api.WeatherUrl;
import com.just.see.justsee.api.service.WeatherService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiyoung on 2016/7/11.
 */
public class WeatherHttpMethod extends HttpMethod {
    private Retrofit retrofit = null;
    private WeatherService weatherService = null;

    @Override
    public void setRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(WeatherUrl.WEATHERURL)
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }

    public WeatherHttpMethod() {
        super();
        setRetrofit();
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
