package com.example.liyang.youhobuy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class ChooseActivity extends BaseActivity implements View.OnClickListener {

    private android.widget.RadioButton boys;
    private android.widget.RadioButton girls;
    private android.widget.RadioButton kids;
    private android.widget.RadioButton life;
    private android.widget.RadioGroup radioGroup;
    private android.widget.RelativeLayout activitychoose;
    private long lastTime;
    List<View> btns = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        initViews();
        initListener();
    }

    private void initListener() {
        for (View v:btns){
            v.setOnClickListener(this);
        }
    }

    private void initViews() {
        this.activitychoose = (RelativeLayout) findViewById(R.id.activity_choose);
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        this.life = (RadioButton) findViewById(R.id.life);
        this.kids = (RadioButton) findViewById(R.id.kids);
        this.girls = (RadioButton) findViewById(R.id.girls);
        this.boys = (RadioButton) findViewById(R.id.boys);
        btns.add(boys);
        btns.add(girls);
        btns.add(kids);
        btns.add(life);
    }

    @Override
    public void onBackPressed() {
        boolean b = System.currentTimeMillis() - lastTime < 1500;
        Log.e("tag",b+"");
        if (b){

            finish();
        }else{
            toast("再按一次退出");
        }
        lastTime = System.currentTimeMillis();
    }

    @Override
    public void onClick(View v) {
         startActivity(new Intent(this,MainActivity.class));
        overridePendingTransition(R.anim.main_in,R.anim.choose_out);
        finish();
    }
}
