package com.example.myviews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TextActivity extends AppCompatActivity {
	private EditText etText;
	private EditText etSize;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_text);
		etText = (EditText) findViewById(R.id.etText);
		etSize = (EditText) findViewById(R.id.etSize);
	}
	
	public void ok(View v){
		String text = etText.getText().toString();
		String size = etSize.getText().toString();
		Intent data = new Intent();
		data.putExtra("activity_text", text);
		data.putExtra("size", size);
		setResult(0x001, data);
		this.finish();
	}
	
	public void cancel(View v){
		this.finish();
	}
}

