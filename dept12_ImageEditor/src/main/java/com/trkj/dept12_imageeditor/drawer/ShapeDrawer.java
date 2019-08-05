package com.trkj.dept12_imageeditor.drawer;

import com.trkj.dept12_imageeditor.BitmapBuffer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * ͼ�λ�����
 * 
 * @author �Ƽ������޺�
 * 
 */
public abstract class ShapeDrawer {
	private View view;
	
	public ShapeDrawer(View view) {
		super();
		this.view = view;
	}
	
	public View getView() {
		return view;
	}

	/**
	 * ���ڻ�ͼ
	 * 
	 * @param viewCanvas
	 *            ����չʾ����Ļ���
	 * @return
	 */
	public void draw(Canvas viewCanvas){
		//����ʷ���
		Bitmap bitmap = BitmapBuffer.getInstance().getBitmap();
		viewCanvas.drawBitmap(bitmap, 0, 0, null);
	}

	/**
	 * ������Ӧ�����¼�
	 * 
	 * @param event
	 * @return
	 */
	public abstract boolean onTouchEvent(MotionEvent event);

	/**
	 * ��ͼ���߼�
	 */
	public abstract void logic();
}
