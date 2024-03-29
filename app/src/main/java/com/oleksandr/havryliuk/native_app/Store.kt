package com.oleksandr.havryliuk.native_app

import android.util.Log
import java.lang.IllegalArgumentException


interface StoreListener {

    fun onIntegerSet(key: String, value: Int)

    fun onStringSet(key: String, value: String)

}

class Store : StoreListener {

    val listeners = mutableListOf<StoreListener>()

    override fun onIntegerSet(key: String, value: Int) {
        listeners.forEach { it.onIntegerSet(key, value) }
        Log.i("store", "onIntegerSet")
    }

    override fun onStringSet(key: String, value: String) {
        listeners.forEach { it.onStringSet(key, value) }
        Log.i("store", "onStringSet")
    }

    external fun getCount(): Int

    @Throws(IllegalArgumentException::class)
    external fun getString(pKey: String): String

    @Throws(IllegalArgumentException::class)
    external fun getInteger(pKey: String): Int

    @Throws(IllegalArgumentException::class)
    external fun getFloat(pKey: String): Float

    @Throws(IllegalArgumentException::class)
    external fun getBoolean(pKey: String): Boolean

    @Throws(IllegalArgumentException::class)
    external fun getShort(pKey: String): Short

    @Throws(IllegalArgumentException::class)
    external fun getObject(pKey: String): Any

    @Throws(IllegalArgumentException::class)
    external fun getLong(pKey: String): Long

    @Throws(IllegalArgumentException::class)
    external fun getDouble(pKey: String): Double

    @Throws(IllegalArgumentException::class)
    external fun getByte(pKey: String): Byte

    external fun setString(pKey: String, pString: String)

    external fun setInteger(pKey: String, pInt: Int)

    external fun setFloat(pKey: String, pFloat: Float)

    external fun setBoolean(pKey: String, pBoolean: Boolean)

    external fun setShort(pKey: String, pShort: Short)

    external fun setObject(pKey: String, pObject: Any)

    external fun setByte(pKey: String, pByte: Byte)

    external fun setLong(pKey: String, pLong: Long)

    external fun setDouble(pKey: String, pDouble: Double)

    external fun hasEntry(pKey: String): Boolean

    companion object {
        init {
            System.loadLibrary("Store")
        }
    }
}