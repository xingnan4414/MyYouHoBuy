package com.example.liyang.youhobuy;

import android.app.Application;

/**
 * Created by liyang on 2016/12/26.
 */

public class MyApplication extends Application {
    public static MyApplication app;
    public static boolean isDebug = true;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
