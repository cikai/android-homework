package com.mxnavi.homework.jiahuan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.mxnavi.homework.MxColor;
import com.mxnavi.homework.R;


/**
 * Created by Administrator on 2018/7/16.
 */

public class MyView extends View {
    private Paint mPaint;
    private int   x;
    private int   y;
    private int   color1;
    private int   color2;


    private RotateAnimation mAnimation;//旋转动画
    private int mWindVelocity = 1; //风速

    //旋转的矩形
    //    private Matrix mMatrix;
    ////旋转动画的角度
    //    int  degrees=0;
    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBlades(canvas);
        drawPoint(canvas);

        canvas.restore();
        drawCharacter(canvas);

    }



    //绘制扇叶 blades
    private void drawBlades(Canvas canvas) {

        //获取屏幕的宽、高
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        // 屏幕宽度（像素）
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        //        int width = getWidth();
        //        int height=getHeight();

        //坐标
        x = (width) / 2;
        y = (height) * 2 / 5;


        int x1 = x - y / 4;
        int y1 = y / 4 * 3;
        int x2 = x;
        int y2 = y / 2;
        int x3 = x + y / 2;
        int y3 = y / 2;

        //改变颜色
        for (int i = 0; i <= 270; i += 90) {
            switch (i) {
                case 0:
                    color1 = MxColor.LIGHT_YELLOW;
                    color2 = MxColor.YELLOW;
                    break;
                case 90:
                    color1 = MxColor.LIGHT_RED;
                    color2 = MxColor.RED;
                    break;
                case 180:
                    color1 = MxColor.LIGHT_GREEN;
                    color2 = MxColor.GREEN;
                    break;
                case 270:
                    color1 = MxColor.LIGHT_BLUE;
                    color2 = MxColor.BLUE;
                    break;
                default:
                    break;
            }

            canvas.rotate(i, x, y);
            //去锯齿
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(color1);
            mPaint.setStyle(Paint.Style.FILL);
            //画小三角形
            Path path = new Path();
            path.moveTo(x, y);
            path.lineTo(x1, y1);
            path.lineTo(x2, y2);
            path.close();
            canvas.drawPath(path, mPaint);
            //画大三角形
            //复原
            path.reset();
            mPaint.setColor(color2);
            mPaint.setStyle(Paint.Style.FILL);
            path.moveTo(x2, y2);
            path.lineTo(x3, y3);
            path.lineTo(x, y);
            path.close();
            canvas.drawPath(path, mPaint);

        }

    }

    //绘制圆
    private void drawPoint(Canvas canvas) {
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(x, y, 30, mPaint);
    }

    //风车扇叶动画
    private void init() {

        //在代码中使用动画
        //RELATIVE_TO_SELF(相对于自身)
        // RELATIVE_TO_PARENT(相对于父控件\容器)

        mAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        //不停顿
        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setRepeatCount(-1); //设置为无限重复
        mAnimation.setInterpolator(new LinearInterpolator());//匀速
        mAnimation.setFillAfter(true);//动画终止时停留在最后一帧

        startAnim();
    }

    public void startAnim() {
        stopAnim();
        //            //动画持续时间，毫秒为单位
        mAnimation.setDuration(1800 - mWindVelocity * 100);
        startAnimation(mAnimation);
    }

    public void stopAnim() {
        clearAnimation();
    }


    //设置文字
    private void drawCharacter(Canvas canvas) {
//        mPaint = new Paint();
//        //颜色
//        mPaint.setColor(Color.BLACK);
//       // 文本的大小
//        mPaint.setTextSize(50f);

        Bitmap bitmap = ((BitmapDrawable) getContext().getResources()
                .getDrawable(R.drawable.mxnavi))
                .getBitmap();
        //缩放
        canvas.scale(0.3f, 0.3f);
        canvas.drawBitmap(bitmap, 500, 3000, mPaint);


        // canvas.drawText("美行科技",50,100,mPaint);
    }


}
