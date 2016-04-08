package com.github.zqhcxy.dayornightdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class SecondActivity extends BaseActivity {

    private Toolbar my_tb;
    private ImageView my_iv1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findView();
    }


    private void findView() {
        my_iv1 = (ImageView) findViewById(R.id.my_iv1);
        my_iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }


}
