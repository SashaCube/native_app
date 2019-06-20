//
// Created by cube on 20.06.19.
//


#ifndef NATIVE_APP_STOREUTIL_H
#define NATIVE_APP_STOREUTIL_H

#include <jni.h>
#include "Store.h"

bool isEntryValid(JNIEnv* pEnv, StoreEntry* pEntry, StoreType pType);

StoreEntry* allocateEntry(JNIEnv* pEnv, Store* pStore, jstring pKey);

StoreEntry* findEntry(JNIEnv* pEnv, Store* pStore, jstring pKey);

void releaseEntryValue(JNIEnv* pEnv, StoreEntry* pEntry);

void throwNoKeyException(JNIEnv* pEnv);

#endif //NATIVE_APP_STOREUTIL_H