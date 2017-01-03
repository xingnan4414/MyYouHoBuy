package com.example.liyang.youhobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.liyang.youhobuy.Event.GoToEvent;
import com.example.liyang.youhobuy.view.MyPanelLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity {
    private com.example.liyang.youhobuy.view.MyPanelLayout sliding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;
        this.sliding = (MyPanelLayout) findViewById(R.id.sliding);
        sliding.requestDisallowInterceptTouchEvent(true);
    }
    public void begin(View view){
        toggleMenu(view);
    }
    public void toggleMenu(View view){
        if (sliding.isOpen()){

            sliding.closePane();
        }else {
            sliding.openPane();
        }
    }

    @Override
    public void onBackPressed() {
        goToChoose(null);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void goToChoose(GoToEvent event) {
        startActivity(new Intent(this,ChooseActivity.class));
        overridePendingTransition(R.anim.choose_in,R.anim.main_out);
        finish();
    }


}
