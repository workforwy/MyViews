package views.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import views.AttributesTool;
import views.BitmapBuffer;
import views.ShapeDrawer;

public class TextDrawer extends ShapeDrawer {
	private String text;
	private int size;
	private float x;
	private float y;
	
	public TextDrawer(View view, String text, int size) {
		super(view);
		if(text == null){
			this.text = "";
		}else{
			this.text = text;
		}
		this.size = size;
	}
	
	@Override
	public void draw(Canvas viewCanvas) {
		super.draw(viewCanvas);
		drawText(viewCanvas, text, x, y);
	}
	private void drawText(Canvas canvas, String text,
			float x, float y){
		Paint paint = AttributesTool.getInstance().getPaint();
		paint.setTextSize(size);
		canvas.drawText(text, x, y, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			this.x = x;
			this.y = y;
			break;
		case MotionEvent.ACTION_MOVE:
			this.x = x;
			this.y = y;
			getView().invalidate();
			
			break;
		case MotionEvent.ACTION_UP:
			Canvas canvas = BitmapBuffer.getInstance().getCanvas();
			drawText(canvas, text, x, y);
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
