package com.example.liyang.youhobuy;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.liyang.youhobuy.Utils.StatusBarUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by liyang on 2016/12/26.
 */

public class BaseActivity extends AppCompatActivity {
    protected Handler delayHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setStatusBarTrans(this);
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {

        }
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        delayHandler.removeCallbacksAndMessages(null);
        try {
            EventBus.getDefault().unregister(this);
        } catch (Exception e) {

        }

    }

}
