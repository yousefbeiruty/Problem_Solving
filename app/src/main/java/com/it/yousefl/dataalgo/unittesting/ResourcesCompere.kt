package com.it.yousefl.dataalgo.unittesting

import android.content.Context

class ResourcesCompere {

    fun isEqual(context: Context,resId:Int,string: String):Boolean{
        return context.getString(resId)==string
    }
}