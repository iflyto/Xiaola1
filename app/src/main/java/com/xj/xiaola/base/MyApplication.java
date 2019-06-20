package com.xj.xiaola.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.awen.photo.FrescoImageLoader;
import com.lzy.okhttputils.OkHttpUtils;

import cn.jpush.android.api.JPushInterface;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        if (TextUtils.equals(getCurrentProcessName(this), getPackageName())) {
            FrescoImageLoader.init(this);
            JPushInterface.init(this);
            OkHttpUtils.init(this);
        }
    }


    private String getCurrentProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
