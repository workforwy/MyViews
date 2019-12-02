package images;

import android.graphics.Bitmap;

import java.util.Stack;

/**
 * ����
 * @author �Ƽ������޺�
 *
 */
public class BitmapHistory {
	private static Stack<Bitmap> stack;
	private static BitmapHistory self;
	
	private BitmapHistory() {
		if(stack == null){
			stack = new Stack<Bitmap>();
		}
	}
	
	public static BitmapHistory getInstance(){
		if(self == null){
			self = new BitmapHistory();
		}
		return self;
	}
	
	/**
	 * ����ǰ����ʷ��ͼ���ѹջ
	 * @param bitmap
	 */
	public void pushBitmap(Bitmap bitmap){
		int count = stack.size();
		if(count >= 6){
			Bitmap bmp = stack.remove(0);
			if(bmp!= null && !bmp.isRecycled()){
				bmp.recycle();
				System.gc();
				bmp = null;
			}
		}
		stack.push(bitmap);
	}
	
	/**
	 * ����
	 * @return
	 */
	public Bitmap reDo(){
		Bitmap bmp = stack.pop();//������Ԫ��ɾ��
		//����λͼ��Դ
		if(bmp!= null && !bmp.isRecycled()){
			bmp.recycle();
			System.gc();
			bmp = null;
		}
		if(stack.empty()) return null;
		//���س������λͼ����
		return stack.peek();
	}
	
	/**
	 * �ж��Ƿ��ܳ���
	 * @return true��ʾ���Գ�����false��ʾ���ܳ���
	 */
	public boolean isReDo(){
		return !stack.empty();
	}
}
