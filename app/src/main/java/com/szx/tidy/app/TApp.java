package com.szx.tidy.app;

import android.app.Application;
import android.content.res.Configuration;

import com.mob.MobSDK;

public class TApp extends Application {

    public static TApp tApp;

    public static TApp gettApp() {
        return tApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        tApp = this;
        MobSDK.init(this);
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
