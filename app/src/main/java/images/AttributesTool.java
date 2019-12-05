package images;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

/**
 * 用于存储所有的绘图属性，单例模式
 *
 * @author 韬睿科技：李赞红
 *
 */
public class AttributesTool {
    /* 绘图颜色 */
    private int color;
    /* 线条的宽度 */
    private int borderWidth;
    /* 是否填充，默认是空心 */
    private boolean fill;

    private static AttributesTool self;

    private static Paint paint;

    /**
     * 将构造方法定义成为私有，目的为了防止创建对象
     */
    private AttributesTool() {
        reset();
    }

    /**
     * 向外部提供对象
     * @return
     */
    public static AttributesTool getInstance(){
        if(self == null){
            self = new AttributesTool();
        }
        return self;
    }

    /**
     * 将当前的绘图属性转换成Paint对象
     * @return
     */
    public Paint getPaint(){
        if(paint == null){
            paint = new Paint();
        }

        paint.setAntiAlias(true);
        paint.setColor(this.color);
        paint.setStrokeWidth(borderWidth);

        if(this.fill){
            paint.setStyle(Style.FILL);
        }else{
            paint.setStyle(Style.STROKE);
        }
        paint.setTextSize(30);

        return paint;
    }

    /**
     * 重置
     */
    public void reset(){
        this.color = Color.BLACK;
        this.borderWidth = 1;
        this.fill = false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

}
