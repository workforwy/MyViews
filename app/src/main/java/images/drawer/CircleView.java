package images.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import images.AttributesTool;
import images.BitmapBuffer;
import images.ShapeDrawer;

public class CircleView extends ShapeDrawer {
    private float centerX;
    private float centerY;
    private float currentX;
    private float currentY;

    public CircleView(View view) {
        super(view);
    }

    @Override
    public void draw(Canvas viewCanvas) {
        super.draw(viewCanvas);
        drawCircle(viewCanvas);
    }

    /**
     * 画圆
     * @param viewCanvas
     */
    protected void drawCircle(Canvas viewCanvas) {
        //计算半径
        float r = (float) Math.sqrt(Math.pow(centerX - currentX, 2)
                + Math.pow(centerY - currentY, 2));
        Paint paint = AttributesTool.getInstance().getPaint();
        viewCanvas.drawCircle(centerX, centerY, Math.abs(r), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                centerX = currentX = x;
                centerY = currentY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = x;
                currentY = y;
                getView().invalidate();
                break;
            case MotionEvent.ACTION_UP:
                Canvas canvas = BitmapBuffer.getInstance().getCanvas();
                drawCircle(canvas);
                //画圆
                getView().invalidate();
                //保存到撤消栈中
                BitmapBuffer.getInstance().pushBitmap();
                break;
            default:

                break;
        }
        return true;
    }

    @Override
    public void logic() {

    }

}
