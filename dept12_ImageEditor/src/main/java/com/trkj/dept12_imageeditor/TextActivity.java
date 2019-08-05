package com.trkj.dept12_imageeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * 输入文字
 * @author 韬睿科技：李赞红
 *
 */
public class TextActivity extends Activity {
	private EditText etText;
	private EditText etSize;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.text);
		etText = (EditText) findViewById(R.id.etText);
		etSize = (EditText) findViewById(R.id.etSize);
	}
	
	public void ok(View v){
		String text = etText.getText().toString();
		String size = etSize.getText().toString();
		Intent data = new Intent();
		data.putExtra("text", text);
		data.putExtra("size", size);
		setResult(0x001, data);
		this.finish();
	}
	
	public void cancel(View v){
		this.finish();
	}
}

