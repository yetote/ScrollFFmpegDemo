package com.example.scrollffmpegdemo;

import android.util.Log;

import com.example.scrollffmpegdemo.playerif.OnCallPrepare;

/**
 * @author yetote QQ:503779938
 * @name ScrollFFmpegDemo
 * @class name：com.example.scrollffmpegdemo
 * @class describe
 * @time 2019/3/1 10:01
 * @change
 * @chang time
 * @class describe
 */
public class PlayerView {
    private static final String TAG = "PlayerView";
    public OnCallPrepare onCallPrepare;

    public void setOnCallPrepare(OnCallPrepare onCallPrepare) {
        this.onCallPrepare = onCallPrepare;
    }

    static {
        System.loadLibrary("native-lib");
    }

    public native void play(String path);

    public void yuvData(byte[] yBytes, byte[] uBytes, byte[] vBytes) {

    }

    public void onPrepare(int w, int h) {
        Log.e(TAG, "onPrepare: "+w+"\nh"+h);
        if (onCallPrepare != null) {
            onCallPrepare.prepare(w, h);
        }
    }

}
