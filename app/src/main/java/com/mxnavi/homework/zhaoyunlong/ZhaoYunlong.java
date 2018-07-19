package com.mxnavi.homework.zhaoyunlong;

import android.app.Activity;
import android.os.Bundle;

public class ZhaoYunlong extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(getApplicationContext());
        setContentView(myView);
    }
}
