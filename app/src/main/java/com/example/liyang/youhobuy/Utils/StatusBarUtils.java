package com.example.liyang.youhobuy.Utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

/**
 * Created by liyang on 2016/12/26.
 */

public class StatusBarUtils {
    public static void setStatusBarTrans(Activity a){
        View decorView = a.getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            a.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }else {

        }
    }
}
