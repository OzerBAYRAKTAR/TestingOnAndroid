package com.bayraktar.shopapp

import android.content.Context

class ResourceComparer {

    fun isEqual(context: Context, resID : Int,string: String):Boolean{
        return context.getString(resID) == string
    }
}