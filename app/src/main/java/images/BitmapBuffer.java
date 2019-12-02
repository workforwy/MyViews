package images;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;

/**
 * λͼ������
 * @author �Ƽ������޺�
 *
 */
public class BitmapBuffer {
	private Bitmap bitmap;
	private Canvas canvas;
	private static BitmapBuffer self;
	
	private BitmapBuffer(int width, int height) {
		init(width, height);
	}
	
	private void init(int width, int height){
		bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		canvas = new Canvas();
		canvas.setBitmap(bitmap);
	}
	
	public static BitmapBuffer getInstance(){
		if(self == null){
			self = new BitmapBuffer(SystemParams.areaWidth,
					SystemParams.areaHeight);
		}
		return self;
	}
	
	/**
	 * ��ȡ�������Ļ���
	 * @return
	 */
	public Canvas getCanvas(){
		return canvas;
	}
	
	/**
	 * ��û�ͼ���
	 * @return
	 */
	public Bitmap getBitmap(){
		return bitmap;
	}
	
	/**
	 * ����ǰ�Ļ�ͼ������浽ջ��
	 */
	public void pushBitmap(){
		BitmapHistory.getInstance().pushBitmap(
				bitmap.copy(Config.ARGB_8888, false));
	}
	
	/**
	 * ����
	 */
	public void redo(){
		BitmapHistory his = BitmapHistory.getInstance();
		if(his.isReDo()){
			Bitmap bmp = his.reDo();
			if(bmp != null){
				bitmap = bmp.copy(Config.ARGB_8888, true);
				//�������¹�������
				canvas.setBitmap(bitmap);
				//����
				if(bmp!= null && !bmp.isRecycled()){
					bmp.recycle();
					System.gc();
					bmp = null;
				}
			}
		}
	}
}
