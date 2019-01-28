package com.szx.tidy.app;

import android.app.Application;
import android.content.res.Configuration;

import com.mob.MobSDK;
import com.mob.bbssdk.BBSSDK;
import com.mob.bbssdk.theme0.BBSTheme0;

public class TApp extends Application {

    private static TApp tApp;

    public static TApp getApp() {
        return tApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        tApp = this;
        MobSDK.init(this);
        BBSSDK.ensureInit();
//        BBSSDK.registerSDK();
        BBSTheme0.init();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
