package com.example.liyang.youhobuy.Utils;

import android.util.Log;

import com.example.liyang.youhobuy.MyApplication;

/**
 * Created by liyang on 2016/12/27.
 */

public class LogUtils {
    public static void log(String tag,String value){
        if (MyApplication.isDebug)
        Log.e(tag,value);
    }
}
