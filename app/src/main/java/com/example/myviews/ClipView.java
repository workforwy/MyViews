package com.example.myviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lizanhong on 16/1/21.
 */
public class ClipView extends View {
    /**
     * 显示第i张小图片
     */
    private int i = 0;
    private Bitmap bmpBoom;

    public ClipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bmpBoom = BitmapFactory.decodeResource(getResources(), R.mipmap.boom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获取位置的宽度和高度
        int width = bmpBoom.getWidth();
        int height = bmpBoom.getHeight();
        //剪切区
        int shortWidth = width / 7;
        Rect rect = new Rect(0, 0, shortWidth, height);
        canvas.save();
        canvas.translate(100, 100);//平移坐标
        canvas.clipRect(rect);//设置剪切区
        canvas.drawBitmap(bmpBoom, -i * shortWidth, 0, null);//画1/7张图
        canvas.restore();
        i++;
        if (i == 7)
            i = 0;//重新播放
    }
}
