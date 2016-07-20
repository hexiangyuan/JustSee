package com.just.see.justsee.api.service;

import com.just.see.justsee.json.weather.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xiyoung on 2016/7/11.
 *
 */
public interface WeatherService {
    @GET("index")
    Observable<WeatherBean> getWeather(@Query("format")int format,@Query("cityname")String cityName,@Query("key")String apiKey);
}
