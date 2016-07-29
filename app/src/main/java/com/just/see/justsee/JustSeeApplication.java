package com.just.see.justsee;

import android.app.Application;

import com.orhanobut.logger.*;

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
        //Logger Init
        LogLevel logLevel = BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE;
        Logger.init("JustSee")               // default PRETTYLOGGER or use just init()
                .methodCount(0)               // default 2
                .hideThreadInfo()             // default shown
                .logLevel(logLevel);        // default LogLevel.FULL


    }

    public static JustSeeApplication getInstance() {
        return INSTANCE;
    }
}
