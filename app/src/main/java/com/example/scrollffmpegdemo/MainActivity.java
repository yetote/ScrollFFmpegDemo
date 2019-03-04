package com.example.scrollffmpegdemo;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scrollffmpegdemo.playerif.OnCallPrepare;

public class MainActivity extends AppCompatActivity {
    private GLSurfaceView glSurfaceView;
    private MyRenderer renderer;
    private static final String TAG = "MainActivity";
    PlayerView playerView;
    ImageView play, fill;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Log.e(TAG, "onCreate: " + "weftryh");
//
        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setEGLConfigChooser(8,8,8,8,16,0);
        glSurfaceView.setRenderer(renderer);
        path = this.getExternalCacheDir().getPath() + "/res/test.mp4";
        Log.e(TAG, "onCreate: " + path);
        playerView = new PlayerView();


//
        playerView.setOnCallPrepare(new OnCallPrepare() {
            @Override
            public void prepare(int w, int h) {

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerView.play(path);
            }
        });

        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void initView() {
        glSurfaceView = findViewById(R.id.glsv);
        renderer = new MyRenderer(this);
        play = findViewById(R.id.play);
        fill = findViewById(R.id.fill_screen);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
