package com.example.myviews;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import images.drawer.BallMoveView;
import images.drawer.ClipView;
import images.drawer.CoordinateView;
import images.drawer.WatchView;

public class GIFActivity extends AppCompatActivity {

    private ClipView clipview;
    private WatchView watchView;
    private BallMoveView mBallMoveView;
    private CoordinateView mCoordinateView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        clipview = findViewById(R.id.clipview);
        mBallMoveView = findViewById(R.id.ball);
        mCoordinateView = findViewById(R.id.coord);
        watchView = findViewById(R.id.watch);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                clipview.postInvalidate();
                mBallMoveView.postInvalidate();
                mCoordinateView.postInvalidate();
            }
        }, 200, 100);

        watchView.run();


    }
}
