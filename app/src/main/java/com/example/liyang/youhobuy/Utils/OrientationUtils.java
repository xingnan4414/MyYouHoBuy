package com.example.liyang.youhobuy.Utils;

import android.graphics.Point;
import android.view.ViewConfiguration;

import com.example.liyang.youhobuy.MyApplication;

/**
 * Created by liyang on 2016/12/28.
 */

public class OrientationUtils {
   static ViewConfiguration configuration = ViewConfiguration.get(MyApplication.app);
    public static boolean isVerticalScroll(Point start, Point end){
        int scaledTouchSlop = configuration.getScaledTouchSlop();
        return Math.abs(end.y-start.y)>Math.abs(end.x-start.x)&&Math.abs(end.y-start.y)>scaledTouchSlop;
    }
    public static boolean isHorizontalScroll(Point start, Point end){
        int scaledTouchSlop = configuration.getScaledTouchSlop();
        return Math.abs(end.y-start.y)<Math.abs(end.x-start.x)&&Math.abs(end.x-start.x)>scaledTouchSlop;
    }
}
