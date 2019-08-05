package com.trkj.dept12_imageeditor.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.trkj.dept12_imageeditor.AttributesTool;
import com.trkj.dept12_imageeditor.BitmapBuffer;

/**
 * ��������
 * 
 * @author �Ƽ������޺�
 * 
 */
public class LineDrawer extends ShapeDrawer {
	private float preX;
	private float preY;
	private float currentX;
	private float currentY;
	
	public LineDrawer(View view) {
		super(view);
	}

	@Override
	public void draw(Canvas viewCanvas) {
		super.draw(viewCanvas);
		Paint paint = AttributesTool.getInstance().getPaint();
		viewCanvas.drawLine(preX, preY, currentX, currentY, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		Canvas bitmapCanvas = BitmapBuffer.getInstance().getCanvas();
		Paint paint = AttributesTool.getInstance().getPaint();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			preX = x;
			preY = y;
			break;
		case MotionEvent.ACTION_MOVE:
			currentX = x;
			currentY = y;
			bitmapCanvas.drawLine(preX, preY, currentX, currentY, paint);
			getView().invalidate();
			preX = x;
			preY = y;
			break;
		case MotionEvent.ACTION_UP:
			//���浽����ջ��
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
