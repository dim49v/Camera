package com.example.admin.camera;

import android.app.Activity;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MainActivity extends Activity {

    SurfaceView surfaceView;
    Camera camera;
    MediaRecorder mediaRecorder;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    camera.setPreviewDisplay(holder);
                    camera.setDisplayOrientation(90);
                    camera.startPreview();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }
        });

         Display display = getWindowManager().getDefaultDisplay();
         DisplayMetrics metricsB = new DisplayMetrics();
         display.getMetrics(metricsB);
         int xDis = metricsB.widthPixels;
         int yDis = metricsB.heightPixels;



     }

    @Override
    protected void onResume() {
        super.onResume();
        camera = Camera.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (camera != null)
            camera.release();
        camera = null;
    }

    public void onClickAutoFocus(View view) {
        Camera.AutoFocusCallback cb = null;
        camera.autoFocus(cb);
    }

    public void onClickHelp(View view) {

    }

    public void onClickScan(View view){
        ////
        ////
        ////

    }

}