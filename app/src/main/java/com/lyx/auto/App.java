package com.lyx.auto;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * <p/>
 * Created by luoyingxing on 2018/8/29.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
