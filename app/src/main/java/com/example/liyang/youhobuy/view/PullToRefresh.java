package com.example.liyang.youhobuy.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.liyang.youhobuy.R;
import com.example.liyang.youhobuy.Utils.DimenUtils;
import com.example.liyang.youhobuy.Utils.IDUtils;

/**
 * Created by liyang on 2016/12/28.
 */

public class PullToRefresh extends RelativeLayout {

    private int[] images;
    private ImageView footer;
    private ImageView header;
    private GestureDetector detector;
    private float startX;
    private float startY;
    private LayoutParams headParams;
    private LayoutParams footerParams;
    private int lastTop;
    private int lastBottom;
    int dimen=DimenUtils.getDimension(25);
    private RecyclerView recyclerView;

    public PullToRefresh(Context context) {
        super(context);
        init();
    }

    public PullToRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PullToRefresh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initImages();
        initHead();
        initFooter();
        initContent();
        detector = new GestureDetector(getContext(),new MyGesture());
    }
    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            float v = e2.getRawY() - e1.getRawY();
            if (v>0&&){//xiala
                headParams.topMargin = (int) Math.max(lastTop+v/2,-dimen);
                header.setLayoutParams(headParams);
            }else if (v<0){
                headParams.bottomMargin = Math.min()
            }

            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }
    private void initContent() {
        recyclerView = new RecyclerView(getContext());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(ABOVE,R.id.footer);
        params.addRule(BELOW,R.id.header);
        recyclerView.setLayoutParams(params);
        addView(recyclerView);
    }

    private void initFooter() {
        footer = new ImageView(getContext());
        footer.setImageResource(images[0]);
        footer.setId(R.id.footer);
        footerParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DimenUtils.getDimension(25));
        footerParams.addRule(CENTER_HORIZONTAL);
        footerParams.addRule(ALIGN_PARENT_BOTTOM);
        footerParams.bottomMargin=-DimenUtils.getDimension(25);
        footer.setLayoutParams(footerParams);
        addView(footer);
    }

    private void initHead() {
        header = new ImageView(getContext());
        header.setImageResource(images[0]);
        header.setId(R.id.header);
        headParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, DimenUtils.getDimension(25));
        headParams.addRule(CENTER_HORIZONTAL);
        headParams.topMargin=-DimenUtils.getDimension(25);
        header.setLayoutParams(headParams);
        addView(header);
    }

    private void initImages() {
        images = new int[13];
        for (int i=1;i<=13;i++) {
            images[i-1]=IDUtils.getDrawableId("js_classify_images_loading_icon_loading_frame_" + i);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = event.getRawX();
                startY = event.getRawY();
                lastTop = headParams.topMargin;
                lastBottom = footerParams.bottomMargin;
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = event.getRawX();
                startY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(event);
    }
}
