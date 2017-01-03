package com.example.liyang.youhobuy.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by liyang on 2016/12/27.
 */

public abstract class BaseFragment extends Fragment {

    public Activity a;
    public View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView==null) {
            rootView = initView(inflater, container);
            initData();
            initAdapter();
        }
        return rootView;
    }
    public void toast(String msg){
        Toast.makeText(a,msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        a = activity;
    }

    protected  void initData(){

    };

    protected  void initAdapter(){

    };

    protected abstract View initView(LayoutInflater inflater, ViewGroup container) ;
}
