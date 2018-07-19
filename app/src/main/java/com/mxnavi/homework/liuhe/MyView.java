package com.mxnavi.homework.liuhe;

/**
 * Created by cikai on 2018/7/19.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;

import com.mxnavi.homework.MxColor;
import com.mxnavi.homework.R;

public class MyView extends View {

    private int x;
    private int y;
    private Context mContext;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, int height, int width) {
        this(context);
        this.y = height*2/5;
        this.x = width/2;
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBitmap(canvas,mContext);
        drawChild(canvas,0, MxColor.YELLOW,MxColor.LIGHT_YELLOW);
        drawChild(canvas,90,MxColor.RED,MxColor.LIGHT_RED);
        drawChild(canvas,180,MxColor.BLUE,MxColor.LIGHT_BLUE);
        drawChild(canvas,270,MxColor.GREEN,MxColor.LIGHT_GREEN);
        drawCircle(canvas);
//        drawBitmap(canvas,mContext);
    }

    void drawChild(Canvas canvas,float degrees,int color1,int color2){
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setColor(color1);
        Path path1 = new Path();
        path1.moveTo(x,y);

        path1.lineTo(x-y/4,y/4*3);
        path1.lineTo(x,y/2);
        path1.close();
        canvas.rotate (degrees,x,y);
        canvas.drawPath(path1,paint1);

        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(color2);

        Path path2 = new Path();
        path2.moveTo(x,y/2);
        path2.lineTo(x + y / 2,y / 2 );
        path2.lineTo(x,y);
        path2.close();
//        canvas.rotate (degrees,x,y);
        canvas.drawPath(path2,paint2);
    }

    void drawCircle(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(MxColor.WHITE);
        canvas.drawCircle(x,y,30,paint);
    }

    void drawBitmap(Canvas canvas,Context mContext){
        Paint paint = new Paint();
        Bitmap bitmap = ((BitmapDrawable)mContext.getResources()
                .getDrawable(R.drawable.mxnavi))
                .getBitmap();
        canvas.drawBitmap(bitmap,0,y*5/2-250,paint);
    }

}