//
// Created by ether on 2019/3/2.
//

#ifndef SCROLLFFMPEGDEMO_DECODE_H
#define SCROLLFFMPEGDEMO_DECODE_H

extern "C" {
#include "includes/libavformat/avformat.h"
#include "includes/libavcodec/avcodec.h"
#include "includes/libavutil/frame.h"
#include "includes/libswresample/swresample.h"
#include "includes/libswscale/swscale.h"
#include "includes/libavutil/avutil.h"
};
#include <android/log.h>
#define  null NULL
#define LOG_TAG "decode"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

class Decode {
public:


    void prepare(const char *path);

    void start();

private:
    AVFormatContext *pFmtCtx;
    AVCodecContext *pCodecCtx;
    AVCodec *pCodec;
    AVFrame pFrame;
    AVStream *pStream;
};


#endif //SCROLLFFMPEGDEMO_DECODE_H
