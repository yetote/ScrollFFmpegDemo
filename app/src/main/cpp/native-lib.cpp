#include <jni.h>
#include <string>
#include "Decode.h"
#include "CallBack.h"

CallBack *callBack;
JavaVM *javaVM;
Decode *decode;
extern "C" JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void *version) {
    jint result = -1;
    javaVM = jvm;
    JNIEnv *env;
    if (jvm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return result;
    }
    return JNI_VERSION_1_6;
}
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
    callBack = new CallBack(javaVM, env, instance);
    decode = new Decode(callBack);

    decode->prepare(path);

//    delete decode;
    env->ReleaseStringUTFChars(path_, path);
}