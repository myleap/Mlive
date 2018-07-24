package org.myleap.mlive.utils;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


/**
 * Created by lidongzhi on 2016/11/1.
 */

public class MliveApp extends Application {
    public static MliveApp sInstance;
    private static Handler mHandler;
    private static long mMainThreadId;
    private static Context mContext;
    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        mHandler = new Handler();
        mMainThreadId = android.os.Process.myTid();
        super.onCreate();
        sInstance =this;
    }
    public static Handler getHandler() {
        return mHandler;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static Context getContext() {
        return mContext;
    }
}
