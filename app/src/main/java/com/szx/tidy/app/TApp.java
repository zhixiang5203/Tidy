package com.szx.tidy.app;

import android.app.Application;
import android.content.res.Configuration;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mob.MobSDK;
import com.mob.bbssdk.BBSSDK;
import com.mob.bbssdk.theme0.BBSTheme0;
import com.szx.tidy.utils.Utils;

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
//        if (Utils.isAppDebug()) {
//            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
//        }
        ARouter.init(this);
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
