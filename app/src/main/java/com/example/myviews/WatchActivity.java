package com.example.myviews;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * Created by lizanhong on 16/1/22.
 */
public class WatchActivity extends Activity {

    private WatchView watchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch);
        watchView = (WatchView) findViewById(R.id.watch);
        watchView.run();
    }
}
