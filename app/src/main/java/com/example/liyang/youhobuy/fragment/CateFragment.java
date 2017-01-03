package com.example.liyang.youhobuy.fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by liyang on 2016/12/27.
 */

public class CateFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        TextView textView = new TextView(getContext());
        textView.setText(getClass().getSimpleName());
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(26);
        return textView;
    }
}
