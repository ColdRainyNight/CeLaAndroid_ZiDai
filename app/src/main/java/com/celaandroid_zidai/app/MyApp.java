package com.celaandroid_zidai.app;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * 类描述：
 * 创建人：xuyaxi
 * 创建时间：2017/7/19 9:13
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
