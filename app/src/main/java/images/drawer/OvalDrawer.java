package images.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import images.AttributesTool;


/**
 * 椭圆绘制
 * @author 韬睿科技：李赞红
 *
 */
public class OvalDrawer extends RectDrawer {

    public OvalDrawer(View view) {
        super(view);
    }

    @Override
    protected void drawShape(Canvas canvas, float firstX, float firstY,
                             float currentX, float currentY) {
        Paint paint = AttributesTool.getInstance().getPaint();

        if(firstX < currentX && firstY < currentY){
            //↘
            canvas.drawOval(new RectF(firstX, firstY, currentX, currentY), paint);
        }else if(firstX > currentX && firstY > currentY){
            //↖
            canvas.drawOval(new RectF(currentX, currentY, firstX, firstY), paint);
        }else if(firstX > currentX && firstY < currentY){
            //↙
            canvas.drawOval(new RectF(currentX, firstY, firstX, currentY), paint);
        }else if(firstX < currentX && firstY > currentY){
            //↗
            canvas.drawOval(new RectF(firstX, currentY, currentX, firstY), paint);
        }

    }
}
