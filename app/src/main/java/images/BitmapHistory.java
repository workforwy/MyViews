package images;

import android.graphics.Bitmap;

import java.util.Stack;

/**
 * 撤消
 * @author 韬睿科技：李赞红
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
	 * 将当前的历史绘图结果压栈
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
	 * 撤消
	 * @return
	 */
	public Bitmap reDo(){
		Bitmap bmp = stack.pop();//将顶部元素删除
		//回收位图资源
		if(bmp!= null && !bmp.isRecycled()){
			bmp.recycle();
			System.gc();
			bmp = null;
		}
		if(stack.empty()) return null;
		//返回撤消后的位图对象
		return stack.peek();
	}
	
	/**
	 * 判断是否还能撤消
	 * @return true表示可以撤消，false表示不能撤消
	 */
	public boolean isReDo(){
		return !stack.empty();
	}
}
