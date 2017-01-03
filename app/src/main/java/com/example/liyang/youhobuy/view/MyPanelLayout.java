package com.example.liyang.youhobuy.view;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by liyang on 2016/12/27.
 */

public class MyPanelLayout extends SlidingPaneLayout {
    public MyPanelLayout(Context context) {
        super(context);

    }

    public MyPanelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        ;
    }

    public MyPanelLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isOpen()) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }
    }
}
