package com.trkj.dept12_imageeditor.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.trkj.dept12_imageeditor.AttributesTool;
import com.trkj.dept12_imageeditor.BitmapBuffer;

public class CircleDrawer extends ShapeDrawer {
	private float centerX;
	private float centerY;
	private float currentX;
	private float currentY;

	public CircleDrawer(View view) {
		super(view);
	}
	
	@Override
	public void draw(Canvas viewCanvas) {
		super.draw(viewCanvas);
		drawCircle(viewCanvas);
	}

	/**
	 * »­Ô²
	 * @param viewCanvas
	 */
	protected void drawCircle(Canvas viewCanvas) {
		//¼ÆËã°ë¾¶
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
			//»­Ô²
			getView().invalidate();
			//±£´æµ½³·ÏûÕ»ÖÐ
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
