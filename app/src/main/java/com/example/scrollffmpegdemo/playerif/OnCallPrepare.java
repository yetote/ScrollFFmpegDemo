package com.example.scrollffmpegdemo.playerif;

/**
 * @author yetote QQ:503779938
 * @name ScrollFFmpegDemo
 * @class name：com.example.scrollffmpegdemo.playerif
 * @class describe
 * @time 2019/3/4 14:54
 * @change
 * @chang time
 * @class describe
 */
public interface OnCallPrepare {
    /**
     * 准备完成回调接口
     * @param w 视频的宽度
     * @param h 视频的高度
     */
    void prepare(int w,int h);
}
