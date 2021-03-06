package com.just.see.justsee.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 何祥源 on 16/7/12.
 * Desc:
 */
public class RetrofitHelper {
    private static retrofit2.Retrofit.Builder retrofit = null;
    private final static int TIME_OUT_SECOND = 20;


    public static Retrofit setUrl(String url) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder();
            retrofit.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create());

        }
        return retrofit.baseUrl(url)
                .build();
    }

    protected static OkHttpClient client = null;

    private static OkHttpClient getClient() {
        if (client == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        }
        return client;
    }
}
