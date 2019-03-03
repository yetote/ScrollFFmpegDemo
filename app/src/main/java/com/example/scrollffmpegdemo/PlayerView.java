package com.example.scrollffmpegdemo;

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
    static {
        System.loadLibrary("native-lib");
    }

    public native void play(String path);

    public void yuvData(byte[] yBytes, byte[] uBytes, byte[] vBytes) {

    }
}
