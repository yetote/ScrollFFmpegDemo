//
// Created by ether on 2019/3/4.
//

#ifndef SCROLLFFMPEGDEMO_CALLBACK_H
#define SCROLLFFMPEGDEMO_CALLBACK_H

#include <jni.h>
#include <cstdio>
#include <android/log.h>
#define LOG_TAG "callback"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

class CallBack {
public:
    CallBack(JavaVM *jvm, JNIEnv *env, jobject obj);

    ~CallBack();

    void onPrepare(int w, int h);

    void onCallYUVData(uint8_t y[], u_int8_t u[], uint8_t v[]);

private:
    JavaVM *javaVM;
    JNIEnv *jniEnv;
    jobject jobj;
    jmethodID callPrepare;
    jmethodID callYUVData;
};


#endif //SCROLLFFMPEGDEMO_CALLBACK_H
