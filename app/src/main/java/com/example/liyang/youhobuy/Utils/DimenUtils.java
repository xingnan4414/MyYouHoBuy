package com.example.liyang.youhobuy.Utils;

import com.example.liyang.youhobuy.MyApplication;

/**
 * Created by liyang on 2016/12/27.
 */

public class DimenUtils {
    public static int getDimension(int dp){
        return (int) (MyApplication.app.getResources().getDisplayMetrics().density*dp+0.5f);
    }
}
