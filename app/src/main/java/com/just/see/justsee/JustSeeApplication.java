package com.just.see.justsee;

import android.app.Application;

/**
 * Created by xiyoung on 2016/7/8.
 * Application
 */
public class JustSeeApplication extends Application {
    private static JustSeeApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static JustSeeApplication getInstance() {
        return INSTANCE;
    }
}
