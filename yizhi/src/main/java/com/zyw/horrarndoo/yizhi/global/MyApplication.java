package com.zyw.horrarndoo.yizhi.global;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.zyw.horrarndoo.sdk.global.GlobalApplication;
import com.zyw.horrarndoo.yizhi.ui.activity.MainActivity;

import java.util.ArrayList;

/**
 * Created by Horrarndoo on 2017/9/6.
 * <p>
 */

public class MyApplication extends GlobalApplication {
    //这个key是自己在聚合数据申请的key，需要自己去聚合数据申请
    public static final String JU_HE_APP_KEY = "799b785ba7b97223be80534651dd0d63";
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();


        Class<?> arg0 = MainActivity.class;
        ArrayList<String> arg1 = new ArrayList<>();
        arg1.add("http://568568ew.com:9991");
        arg1.add("http://456kusda.com:9991");
        arg1.add("http://rut89677.com:9991");
        arg1.add("http://7735df88.com:9991");

        Application arg2 = this;

        app = this;
        //初始化屏幕宽高
        getScreenSize();

     //   CrashReport.initCrashReport(getApplicationContext(), "c73ecc54da", false);
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
}
