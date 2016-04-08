package com.github.zqhcxy.dayornightdemo;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ThirdActivity extends BaseActivity {
    private Switch my_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        my_switch = (Switch) findViewById(R.id.my_switch);
        my_switch.setChecked(getMyApplication().isNightMode());
        my_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getMyApplication().setIsNightMode(true);
                } else {
                    getMyApplication().setIsNightMode(false);
                }
                changeMode();
            }
        });
    }

}
