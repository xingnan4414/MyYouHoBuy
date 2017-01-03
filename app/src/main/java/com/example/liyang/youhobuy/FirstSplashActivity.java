package com.example.liyang.youhobuy;

import android.content.Intent;
import android.os.Bundle;

public class FirstSplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_splash);
        delayHandler.postDelayed(new MyRun(),1500);
    }

    private class MyRun implements Runnable {
        @Override
        public void run() {
            startActivity(new Intent(FirstSplashActivity.this,SecondSplashActivity.class));
            finish();
        }
    }
}
