package com.trkj.dept12_imageeditor.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import com.trkj.dept12_imageeditor.AttributesTool;

/**
 * Õ÷‘≤ªÊ÷∆
 * @author Ë∫Ó£ø∆ºº£∫¿Ó‘ﬁ∫Ï
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
			//®K
			canvas.drawOval(new RectF(firstX, firstY, currentX, currentY), paint);
		}else if(firstX > currentX && firstY > currentY){
			//®I
			canvas.drawOval(new RectF(currentX, currentY, firstX, firstY), paint);
		}else if(firstX > currentX && firstY < currentY){
			//®L
			canvas.drawOval(new RectF(currentX, firstY, firstX, currentY), paint);
		}else if(firstX < currentX && firstY > currentY){
			//®J
			canvas.drawOval(new RectF(firstX, currentY, currentX, firstY), paint);
		}
		
	}
}
