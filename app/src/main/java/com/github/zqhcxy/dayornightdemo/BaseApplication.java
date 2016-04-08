package com.github.zqhcxy.dayornightdemo;

import android.app.Application;

/**
 * Created by zqh-pc on 2016/4/6.
 */
public class BaseApplication extends Application {

    private boolean isNight = true;
//    private boolean isDay = false;


//    public void setIsDay(boolean isDay) {
//        this.isDay = isDay;
//    }

    public void setIsNightMode(boolean isNight) {
        this.isNight = isNight;
    }

    public boolean isNightMode() {
        return isNight;
    }


}
