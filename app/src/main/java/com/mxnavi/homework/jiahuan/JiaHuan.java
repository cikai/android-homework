package com.mxnavi.homework.jiahuan;

import android.app.Activity;
import android.os.Bundle;

public class JiaHuan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(getApplicationContext());
        setContentView(myView);
    }
}
