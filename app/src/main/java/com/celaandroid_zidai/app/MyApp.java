package com.celaandroid_zidai.app;

import android.app.Application;

import com.celaandroid_zidai.User;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * 类描述：
 * 创建人：xuyaxi
 * 创建时间：2017/7/19 9:13
 */
public class MyApp extends Application {
    {
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }

    private static MyApp sApp;
    private User user;
    private UMShareAPI mUMShareAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        sApp = this;
        mUMShareAPI = UMShareAPI.get(this);
    }

    public static MyApp getInstance() {
        return sApp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UMShareAPI getUMShareAPI() {
        return mUMShareAPI;
    }

    public void setUMShareAPI(UMShareAPI UMShareAPI) {
        mUMShareAPI = UMShareAPI;
    }
}
