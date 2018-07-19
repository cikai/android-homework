package com.mxnavi.homework.jiangdi;

/**
 * Created by cikai on 2018/7/19.
 */

import android.content.Context;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.mxnavi.homework.MxColor;
import com.mxnavi.homework.R;

import java.util.concurrent.Exchanger;

/**
 * Created by Administrator on 2018/7/16.
 */

public class MyView extends View {
    private Path path;
    private int x;
    private int y;
    private Paint paint;
    private int exColor1;
    private int exColor2;
    private Context mcontext;
    private int mWindVelocity;
    private RotateAnimation mAnimation;

    public MyView(Context context) {
        super(context);
        mcontext = context;
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        //获取屏幕的宽度和高度
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        //风车的中间的点
        x = (dm.widthPixels) / 2;
        y = (dm.heightPixels) * 2 / 5;

        for (int i = 0; i <= 270; i += 90) {
            switch (i) {
                case 0:
                    exColor1 = MxColor.LIGHT_YELLOW;
                    exColor2 = MxColor.YELLOW;
                    break;
                case 90:
                    exColor1 = MxColor.LIGHT_RED;
                    exColor2 = MxColor.RED;
                    break;
                case 180:
                    exColor1 = MxColor.LIGHT_GREEN;
                    exColor2 = MxColor.GREEN;
                    break;
                case 270:
                    exColor1 = MxColor.LIGHT_BLUE;
                    exColor2 = MxColor.BLUE;
                    break;
                default:
                    break;
            }
            //根据某点旋转多少度
            canvas.rotate(i, x, y);
            //画笔
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(exColor1);
            paint.setStyle(Paint.Style.FILL);
            //绘画
            path = new Path();
            path.moveTo(x, y);
            path.lineTo(x - y / 4, y / 4 * 3);
            path.lineTo(x, y / 2);
            path.close();
            canvas.drawPath(path, paint);
            //回到初始状态
            path.reset();
            paint.setColor(exColor2);
            //填充颜色
            paint.setStyle(Paint.Style.FILL);
            path.moveTo(x, y / 2);
            path.lineTo(x + y / 2, y / 2);
            path.lineTo(x, y);
            path.close();
            canvas.drawPath(path, paint);
        }
        //画白色的圆
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x, y, 30, paint);
        Bitmap bitmap = ((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.mxnavi)).getBitmap();
        canvas.scale(0.2f, 0.2f);
        canvas.rotate(180, x, y);
        canvas.drawBitmap(bitmap, -2500, 500, paint);
    }

}