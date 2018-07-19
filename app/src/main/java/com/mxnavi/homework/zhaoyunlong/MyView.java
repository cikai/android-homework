package com.mxnavi.homework.zhaoyunlong;

/**
 * Created by cikai on 2018/7/19.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.mxnavi.homework.MxColor;
import com.mxnavi.homework.R;


public class MyView extends View{
    Context mContext;
    public MyView(Context context) {

        super(context);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float screenWidth = dm.widthPixels;
        float screenHeight = dm.heightPixels;
        float x = screenWidth/2;
        float y = (float)(screenHeight/2.5) ;
        Paint paint = new Paint();
        Paint paint1 = new Paint();
        Paint paint2 = new Paint();
        Paint paint3 = new Paint();
        Paint paint4 = new Paint();
        Paint paint5 = new Paint();
        Paint paint6 = new Paint();
        Paint paint7 = new Paint();

        paint.setColor(MxColor.LIGHT_YELLOW);
        paint.setStyle(Paint.Style.FILL);
        Path path  = new Path();
        path.moveTo(x, y);
        path.lineTo((x-y/4),y/4*3);
        path.lineTo(x,y/2);
        path.close();
        canvas.drawPath(path, paint);


        paint1.setColor(MxColor.YELLOW);
        paint1.setStyle(Paint.Style.FILL);
        Path path1  = new Path();
        path1.moveTo(x,y);
        path1.lineTo(x,y/2);
        path1.lineTo(x + y / 2,y / 2);
        path1.close();
        canvas.drawPath(path1, paint1);


        paint2.setColor(MxColor.LIGHT_RED);
        paint2.setStyle(Paint.Style.FILL);
        Path path2  = new Path();
        path2.moveTo(x, y);
        path2.lineTo((x-y/4),y/4*3);
        path2.lineTo(x,y/2);
        path2.close();
        canvas.rotate (90,x,y);
        canvas.drawPath(path2,paint2);


        paint3.setColor(MxColor.RED);
        paint3.setStyle(Paint.Style.FILL);
        Path path3  = new Path();
        path3.moveTo(x,y);
        path3.lineTo(x,y/2);
        path3.lineTo(x + y / 2,y / 2);
        path3.close();
        // canvas.rotate (45,x,y);
        canvas.drawPath(path3, paint3);

        paint4.setColor(MxColor.LIGHT_BLUE);
        paint4.setStyle(Paint.Style.FILL);
        Path path4  = new Path();
        path4.moveTo(x, y);
        path4.lineTo((x-y/4),y/4*3);
        path4.lineTo(x,y/2);
        path4.close();
        canvas.rotate (90,x,y);
        canvas.drawPath(path4,paint4);


        paint5.setColor(MxColor.BLUE);
        paint5.setStyle(Paint.Style.FILL);
        Path path5  = new Path();
        path5.moveTo(x,y);
        path5.lineTo(x,y/2);
        path5.lineTo(x + y / 2,y / 2);
        path5.close();
        // canvas.rotate (45,x,y);
        canvas.drawPath(path5, paint5);


        paint6.setColor(MxColor.LIGHT_GREEN);
        paint6.setStyle(Paint.Style.FILL);
        Path path6  = new Path();
        path6.moveTo(x, y);
        path6.lineTo((x-y/4),y/4*3);
        path6.lineTo(x,y/2);
        path6.close();
        canvas.rotate (90,x,y);
        canvas.drawPath(path6,paint6);


        paint7.setColor(MxColor.GREEN);
        paint7.setStyle(Paint.Style.FILL);
        Path path7  = new Path();
        path7.moveTo(x,y);
        path7.lineTo(x,y/2);
        path7.lineTo(x + y / 2,y / 2);
        path7.close();
        // canvas.rotate (45,x,y);
        canvas.drawPath(path7, paint7);


        Paint paint8 = new Paint();
        paint8.setColor(MxColor.WHITE);
        paint8.setStyle(Paint.Style.FILL);
        canvas.drawCircle(  x,  y,  20,paint8);

        Paint paint9 = new Paint();
//
        Bitmap bitmap = ((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.mxnavi)).getBitmap();
//        canvas.drawBitmap(bitmap,100,100,paint9);
        canvas.scale(0.3f, 0.3f);
        canvas.rotate (90);
        canvas.translate(700, -450);
        canvas.drawBitmap(bitmap,0,0,paint9);
    }

}
