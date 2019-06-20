//
// Created by cube on 20.06.19.
//

#ifndef NATIVE_APP_STORE_H
#define NATIVE_APP_STORE_H



#include <cstdint>
#include "jni.h"

#define STORE_MAX_CAPACITY 16

typedef enum {
    StoreType_Float,
    StoreType_String,
    StoreType_Integer,
    StoreType_Object,
    StoreType_Boolean,
    StoreType_Short,
    StoreType_Long,
    StoreType_Double,
    StoreType_Byte,
} StoreType;

typedef union {
    float mFloat;
    int32_t mInteger;
    char* mString;
    jobject mObject;
    jboolean mBoolean;
    jshort mShort;
    jlong mLong;
    jdouble mDouble;
    jbyte mByte;
} StoreValue;

typedef struct {
    char* mKey;
    StoreType mType;
    StoreValue mValue;
} StoreEntry;

typedef struct {
    StoreEntry mEntries[STORE_MAX_CAPACITY];
    int32_t mLength;
} Store;

#endif //NATIVE_APP_STORE_H
