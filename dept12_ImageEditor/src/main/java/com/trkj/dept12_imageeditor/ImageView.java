package com.trkj.dept12_imageeditor;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.trkj.dept12_imageeditor.drawer.LineDrawer;
import com.trkj.dept12_imageeditor.drawer.ShapeDrawer;

/**
 * ��ͼ��
 * @author �Ƽ������޺�
 *
 */
public class ImageView extends View {
	private ShapeDrawer shapeDrawer;//ͼ�λ�����
	
	public void setShapeDrawer(ShapeDrawer shapeDrawer) {
		this.shapeDrawer = shapeDrawer;
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		SystemParams.areaWidth = this.getMeasuredWidth();
		SystemParams.areaHeight = this.getMeasuredHeight();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		if(SystemParams.isRedo){
			//����
			canvas.drawBitmap(BitmapBuffer.getInstance().getBitmap(),
					0, 0, null);
			SystemParams.isRedo = false;
		}else{
			shapeDrawer.draw(canvas);
		}
		//�߼�
		shapeDrawer.logic();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return shapeDrawer.onTouchEvent(event);
	}

	public ImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		//Ĭ�ϻ����� 
		shapeDrawer = new LineDrawer(this);
	}

	public ImageView(Context context) {
		super(context);
	}

}
