package com.just.see.justsee;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

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
        initEveryThing();
    }

    private void initEveryThing() {
        //内存泄漏的
        LeakCanary.install(this);
    }

    public static JustSeeApplication getInstance() {
        return INSTANCE;
    }
}
