package com.mxnavi.homework.jiangdi;

import android.app.Activity;
import android.os.Bundle;

public class JiangDi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(getApplicationContext());
        setContentView(myView);
    }
}
