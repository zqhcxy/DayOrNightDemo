package com.github.zqhcxy.dayornightdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class BaseActivity extends AppCompatActivity {
    private BaseApplication mBaseApp = null;
    private WindowManager mWindowManager = null;
    private View mNightView = null;
    private LayoutParams mNightViewParam;
    private boolean mIsAddedView;//是否已经添加了透明View

    private SharedPreferences sharedPreferences;

    private final BroadcastReceiver mUpdateUIReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            recreateOnResume();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBaseApp = (BaseApplication) getApplication();
        if (mBaseApp.isNightMode())
            setTheme(R.style.AppTheme_night);
        else
            setTheme(R.style.AppTheme_day);
        super.onCreate(savedInstanceState);
        mIsAddedView = false;
        if (mBaseApp.isNightMode()) {
            initNightView();
            mNightView.setBackgroundResource(R.color.night_mask);
        }
        registerReceiver(mUpdateUIReceiver, new IntentFilter(
                "com.github.zqhcxy.dayornightdemo.NOTIFICATION"));
    }

    public void ChangeToDay() {
        mBaseApp.setIsNightMode(false);
        if (mNightView != null)
            mNightView.setBackgroundResource(android.R.color.transparent);
    }

    public void ChangeToNight() {
        mBaseApp.setIsNightMode(true);
        initNightView();
        mNightView.setBackgroundResource(R.color.night_mask);
    }

    /**
     * wait a time until the onresume finish
     */
    public void recreateOnResume() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                recreate();
            }
        }, 100);
    }

    private void initNightView() {
        if (mIsAddedView == true)
            return;
        mNightViewParam = new LayoutParams(
                LayoutParams.TYPE_APPLICATION,
                LayoutParams.FLAG_NOT_TOUCHABLE | LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mNightView = new View(this);
        mWindowManager.addView(mNightView, mNightViewParam);
        mIsAddedView = true;
    }

    public BaseApplication getMyApplication() {
        return mBaseApp;
    }

    public void changeMode() {
        if (mBaseApp.isNightMode())
            ChangeToNight();
        else
            ChangeToDay();

        Intent intent = new Intent("com.github.zqhcxy.dayornightdemo.NOTIFICATION");
        sendBroadcast(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("zqh", "BaseActivity:onResume()");
    }

    @Override
    protected void onDestroy() {
        if (mIsAddedView) {
            mBaseApp = null;
            mWindowManager.removeViewImmediate(mNightView);
            mWindowManager = null;
            mNightView = null;
        }
        unregisterReceiver(mUpdateUIReceiver);
        super.onDestroy();
    }

}
