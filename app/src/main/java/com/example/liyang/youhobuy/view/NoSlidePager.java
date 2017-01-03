package com.example.liyang.youhobuy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Scroller;

import com.example.liyang.youhobuy.Utils.LogUtils;

/**
 * Created by liyang on 2016/12/27.
 */

public class NoSlidePager extends FrameLayout {

    private Scroller scroller;

    public NoSlidePager(Context context) {
        super(context);
    }

    public NoSlidePager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        scroller = new Scroller(getContext());
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
        for (int i=0;i<getChildCount();i++){
            getChildAt(i).layout(i*getMeasuredWidth(),0,(i+1)*getMeasuredWidth(),getMeasuredHeight());
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
    public void setCurrentItem(int currentItem){
        LogUtils.log("gra",currentItem+"");
        if (getCurrentItem()!=currentItem&&scroller.isFinished()){
            int i = currentItem - getCurrentItem();
            scroller.startScroll(getScrollX(),0,i*getWidth(),0,1000);
            postInvalidate();
        }
    }
    public int getCurrentItem(){
        return getScrollX()/getMeasuredWidth();
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()){
            int currX = scroller.getCurrX();
            scrollTo(currX,0);
        invalidate();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
