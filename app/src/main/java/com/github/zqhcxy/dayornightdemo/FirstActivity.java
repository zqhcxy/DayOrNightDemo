package com.github.zqhcxy.dayornightdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FirstActivity extends BaseActivity {

    private TextView tv1;
    private Button btn_night;
    private Button btn_day;
    private RelativeLayout all_ly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        findView();
        initData();
    }

    private void findView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        btn_night = (Button) findViewById(R.id.btn_night);
        btn_day = (Button) findViewById(R.id.btn_day);
        all_ly = (RelativeLayout) findViewById(R.id.all_ly);
    }

    private void initData() {
//        btn_night.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getMyApplication().setIsNightMode(true);
//                recreateOnResume();
//            }
//        });
//        btn_day.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getMyApplication().setIsNightMode(false);
//                recreateOnResume();
//            }
//        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("zqh", "First:onResume()");
    }

}
