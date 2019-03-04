//
// Created by ether on 2019/3/4.
//

#include "CallBack.h"


CallBack::CallBack(JavaVM *jvm, JNIEnv *env, jobject obj) {
    this->javaVM = jvm;
    this->jniEnv = env;
    this->jobj = env->NewGlobalRef(obj);
    jclass jlz = env->GetObjectClass(jobj);
    if (!jlz) {
        LOGE("获取jclass失败");
        return;
    }
    this->callPrepare = jniEnv->GetMethodID(jlz, "onPrepare", "(II)V");
}

void CallBack::onPrepare(int w, int h) {
    jniEnv->CallVoidMethod(jobj, callPrepare,w,h);
}