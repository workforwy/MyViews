package images.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import images.AttributesTool;
import images.BitmapBuffer;
import images.ShapeDrawer;

public class RectDrawer extends ShapeDrawer {
	private float firstX;
	private float firstY;
	private float currentX;
	private float currentY;

	public RectDrawer(View view) {
		super(view);
	}

	@Override
	public void draw(Canvas viewCanvas) {
		super.draw(viewCanvas);
		drawShape(viewCanvas, firstX, firstY, currentX, currentY);
	}

	protected void drawShape(Canvas canvas, float firstX,
			float firstY, float currentX, float currentY){
		Paint paint = AttributesTool.getInstance().getPaint();

		if(firstX < currentX && firstY < currentY){
			//¨K
			canvas.drawRect(firstX, firstY, currentX, currentY, paint);
		}else if(firstX > currentX && firstY > currentY){
			//¨I
			canvas.drawRect(currentX, currentY, firstX, firstY, paint);
		}else if(firstX > currentX && firstY < currentY){
			//¨L
			canvas.drawRect(currentX, firstY, firstX, currentY, paint);
		}else if(firstX < currentX && firstY > currentY){
			//¨J
			canvas.drawRect(firstX, currentY, currentX, firstY, paint);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			firstX = x;
			firstY = y;
			break;
		case MotionEvent.ACTION_MOVE:
			currentX = x;
			currentY = y;
			getView().invalidate();
			break;
		case MotionEvent.ACTION_UP:
			Canvas canvas = BitmapBuffer.getInstance().getCanvas();
			drawShape(canvas, firstX, firstY, currentX, currentY);
			getView().invalidate();
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
