package com.example.liyang.youhobuy;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

import com.example.liyang.youhobuy.Listener.SimpleAnimatorListener;

public class SecondSplashActivity extends BaseActivity implements ValueAnimator.AnimatorUpdateListener {

    private RelativeLayout secondsplash;
    private android.view.View mark;
    private RelativeLayout activitysecondsplash;
    private ValueAnimator animator;
    private ObjectAnimator objectAnimator;
    private boolean isSkip;
    private long lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_splash);
        this.activitysecondsplash = (RelativeLayout) findViewById(R.id.activity_second_splash);
        this.mark = (View) findViewById(R.id.mark);
        secondsplash = (RelativeLayout) findViewById(R.id.activity_second_splash);
        beginMarkBg();
        beginScale();
    }
    public void click(View v){
        isSkip = true;
        GoToChooseActivity();
    }
    private void GoToChooseActivity() {
        clearAnimator();
        startActivity(new Intent(this,ChooseActivity.class));
        finish();
    }

    private void beginScale() {
        secondsplash.setScaleX(1.1f);
        secondsplash.setScaleY(1.1f);
        PropertyValuesHolder holder = PropertyValuesHolder.ofFloat("scaleX",1.1f,1.0f);
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleY",1.1f,1.0f);
        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(secondsplash,holder,holder1);
        objectAnimator.setDuration(3000);
        objectAnimator.addListener(new ScaleListener());
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setEvaluator(new FloatEvaluator());
    }

    public void beginMarkBg(){
        animator = ValueAnimator.ofInt(Color.parseColor("#ee333333"),Color.parseColor("#00333333"));
        animator.setDuration(3000);
        animator.addUpdateListener(this);
        animator.addListener(new MarkListener());
        animator.setInterpolator(new LinearInterpolator());
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        int animatedValue = (int) animation.getAnimatedValue();
        mark.setBackgroundColor(animatedValue);
    }
    public void clearAnimator(){
        objectAnimator.cancel();
        animator.cancel();
    }
    class MarkListener extends SimpleAnimatorListener {
        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            Log.e("tag","MarkEnd------");
            objectAnimator.start();
        }
    }
    class ScaleListener extends SimpleAnimatorListener{
        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);//是否点击了跳过按钮，点击了要提前clearAnimator
            if (!isSkip){
                GoToChooseActivity();
            }
        }
    }

    @Override
    public void onBackPressed() {
        clearAnimator();
        if (System.currentTimeMillis()- lastTime <1500){
            clearAnimator();
            finish();
        }else {
            toast("再按一次退出程序");
        }
        lastTime = System.currentTimeMillis();
    }
}
