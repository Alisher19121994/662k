package com.example.a662k.utils

import android.util.Log
import com.example.a662k.volleyNetWorkHttp.VolleyNetworkHttp

class Logger {

    companion object {
        fun d(tag: String, msg: String) {
            if (VolleyNetworkHttp.IS_TESTER) {
                Log.d(tag, msg)
            }
        }
    }
}