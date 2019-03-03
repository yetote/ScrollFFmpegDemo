#include <jni.h>
#include <string>
#include "Decode.h"

Decode decode;
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_scrollffmpegdemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_scrollffmpegdemo_PlayerView_play(JNIEnv *env, jobject instance, jstring path_) {
    const char *path = env->GetStringUTFChars(path_, 0);

    decode.prepare(path);

    env->ReleaseStringUTFChars(path_, path);
}