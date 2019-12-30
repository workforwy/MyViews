package views;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * 图形绘制器
 *
 * @author 韬睿科技：李赞红
 *
 */
public abstract class ShapeDrawer {
    private View view;

    public ShapeDrawer(View view) {
        super();
        this.view = view;
    }

    public View getView() {
        return view;
    }

    /**
     * 用于绘图
     *
     * @param viewCanvas
     *            用于展示结果的画布
     * @return
     */
    public void draw(Canvas viewCanvas){
        //画历史结果
        Bitmap bitmap = BitmapBuffer.getInstance().getBitmap();
        viewCanvas.drawBitmap(bitmap, 0, 0, null);
    }

    /**
     * 用于响应触摸事件
     *
     * @param event
     * @return
     */
    public abstract boolean onTouchEvent(MotionEvent event);

    /**
     * 绘图的逻辑
     */
    public abstract void logic();
}
