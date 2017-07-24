package com.celaandroid_zidai;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatDelegate;

/**
 * 类描述： 夜间切换模式
 * 创建人：xuyaxi
 * 创建时间：2017/7/24 15:12
 */
public class DayNigthUtils {
    public static void changeDayNight(Activity activity){
        //切换夜间模式
        SharedPreferences sp = activity.getSharedPreferences("user", activity.MODE_PRIVATE);
        if (sp.getBoolean("isNight", false)) {
            sp.edit().putBoolean("isNight", false).commit();
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            sp.edit().putBoolean("isNight", true).commit();
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        activity.recreate();
    }
}
