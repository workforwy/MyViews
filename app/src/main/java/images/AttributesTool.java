package images;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

/**
 * ���ڴ洢���еĻ�ͼ���ԣ�����ģʽ
 * 
 * @author �Ƽ������޺�
 * 
 */
public class AttributesTool {
	/* ��ͼ��ɫ */
	private int color;
	/* �����Ŀ�� */
	private int borderWidth;
	/* �Ƿ���䣬Ĭ���ǿ��� */
	private boolean fill;
	
	private static AttributesTool self;
	
	private static Paint paint;
	
	/**
	 * �����췽�������Ϊ˽�У�Ŀ��Ϊ�˷�ֹ��������
	 */
	private AttributesTool() {
		reset();
	}
	
	/**
	 * ���ⲿ�ṩ����
	 * @return
	 */
	public static AttributesTool getInstance(){
		if(self == null){
			self = new AttributesTool();
		}
		return self;
	}
	
	/**
	 * ����ǰ�Ļ�ͼ����ת����Paint����
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
	 * ����
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
