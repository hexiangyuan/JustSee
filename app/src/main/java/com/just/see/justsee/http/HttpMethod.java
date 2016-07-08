package com.just.see.justsee.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by xiyoung on 2016/7/8.
 * 这是httpMethod
 */
public abstract class HttpMethod {
    private final static int TIME_OUT_SECOND = 5;
    protected static OkHttpClient client = null;

    public HttpMethod() {
        if(client == null){
            client = new OkHttpClient.Builder()
                    .connectTimeout(TIME_OUT_SECOND,TimeUnit.SECONDS)
                    .build();
        }
    }

    public abstract void setRetrofit();
}
