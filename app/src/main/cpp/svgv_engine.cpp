#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_vectorvision_svgv_MainActivity_stringFromJNI(JNIEnv* env, jobject /* this */) {
    // This is where the geometric path math will eventually sit [cite: 2026-02-07]
    std::string hello = "SVGV Engine Initialized: Ready for Path Extraction";
    return env->NewStringUTF(hello.c_str());
}
