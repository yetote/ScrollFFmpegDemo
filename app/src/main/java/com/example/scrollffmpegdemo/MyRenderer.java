package com.example.scrollffmpegdemo;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

import com.example.scrollffmpegdemo.objects.PlayerObj;
import com.example.scrollffmpegdemo.programs.PlayerProgram;
import com.example.scrollffmpegdemo.utils.YUVHelper;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glViewport;

/**
 * @author yetote QQ:503779938
 * @name ScrollFFmpegDemo
 * @class name：com.example.scrollffmpegdemo
 * @class describe
 * @time 2019/3/1 10:05
 * @change
 * @chang time
 * @class describe
 */
public class MyRenderer implements GLSurfaceView.Renderer {
    private PlayerObj playerObj;
    private PlayerProgram playerProgram;
    private int[] textureArr;
    private Context context;
    private static final String TAG = "MyRenderer";

    public MyRenderer(Context context) {
        this.context = context;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        glClearColor(1, 1, 1, 0);
        Log.e(TAG, "onSurfaceCreated: ");
        playerObj = new PlayerObj();
        textureArr = new int[3];
        playerProgram = new PlayerProgram(context);
        YUVHelper.loadTexture(textureArr);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        glClear(GL_COLOR_BUFFER_BIT);
//        playerProgram.useProgram();
//        playerProgram.setUniform(textureArr);
//        playerObj.bindData(playerProgram);
//        playerObj.draw();
    }

}
