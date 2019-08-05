package com.example.myviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lizanhong on 16/1/20.
 */
public class BallMoveView extends View {
    /**小球的水平位置*/
    private int x;
    /**小球的垂直位置，固定为100*/
    private static final int Y = 100;
    /**小球的半径*/
    private static final int RADIUS = 30;
    /**小球的颜色*/
    private static final int COLOR = Color.RED;
    private Paint paint;
    /**移动的方向*/
    private boolean direction;

    public BallMoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔，参数表示去锯齿
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(COLOR);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //根据x、y的坐标值画一个小球
        canvas.drawCircle(x, Y, RADIUS, paint);
        //改变x坐标的值，调用invalidate()方法后，
        //小球将因x的值发生改变而产生移动的效果
        int width = this.getMeasuredWidth();//获取组件的宽度
        if(x <= RADIUS){
            direction = true;
        }
        if(x >= width - RADIUS){
            direction = false;
        }
        x = direction ? x + 5 : x - 5;


    }
}
