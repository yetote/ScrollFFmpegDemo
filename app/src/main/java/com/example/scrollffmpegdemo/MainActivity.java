package com.example.scrollffmpegdemo;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GLSurfaceView glSurfaceView;
    private MyRenderer renderer;
    private static final String TAG = "MainActivity";
    PlayerView playerView;

    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Log.e(TAG, "onCreate: "+"weftryh" );
//
//        glSurfaceView.setEGLContextClientVersion(2);
//        glSurfaceView.setRenderer(renderer);
        path = this.getExternalCacheDir().getPath() + "/res/test.mp4";
        Log.e(TAG, "onCreate: "+path );
        playerView = new PlayerView();
        playerView.play(path);
    }

    private void initView() {
        glSurfaceView = findViewById(R.id.glsv);
//        renderer = new MyRenderer(this);
    }

}
