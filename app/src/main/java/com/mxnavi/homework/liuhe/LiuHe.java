package com.mxnavi.homework.liuhe;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class LiuHe extends Activity {

    private int height;
    private int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DisplayMetrics dm = getResources().getDisplayMetrics();
        height = dm.heightPixels;
        width = dm.widthPixels;

        MyView myView = new MyView(getApplicationContext(),height,width);
        setContentView(myView);
    }
}
