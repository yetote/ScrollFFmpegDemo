//
// Created by ether on 2019/3/2.
//

#ifndef SCROLLFFMPEGDEMO_DECODE_H
#define SCROLLFFMPEGDEMO_DECODE_H

extern "C" {
#include "libavformat/avformat.h"
#include "libavcodec/avcodec.h"
#include "libavutil/frame.h"
#include "libswresample/swresample.h"
#include "libswscale/swscale.h"
#include "libavutil/avutil.h"
#include "libavutil/imgutils.h"
#include "libavutil/time.h"
};

#include <android/log.h>
#include "CallBack.h"

#define  null NULL
#define LOG_TAG "decode"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

class Decode {
public:
    Decode(CallBack *callBack1);

    ~Decode();

    CallBack *callBack;

    void prepare(const char *path);

    void start();

private:
    AVFormatContext *pFmtCtx;
    AVCodecContext *pCodecCtx;
    AVCodec *pCodec;
    AVFrame *pFrame;
    AVStream *pStream;
};


#endif //SCROLLFFMPEGDEMO_DECODE_H
