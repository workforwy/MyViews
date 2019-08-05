package com.example.myviews;

import android.app.Activity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private ClipView clipview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clipview = (ClipView) findViewById(R.id.clipview);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                clipview.postInvalidate();
            }
        }, 200, 100);
    }
}
