package com.example.liyang.youhobuy.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.liyang.youhobuy.R;
import com.example.liyang.youhobuy.Utils.LogUtils;
import com.example.liyang.youhobuy.view.NoSlidePager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyang on 2016/12/27.
 */

public class SlideFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private NoSlidePager root;
    List<View> list = new ArrayList<>();
    private ListView left;
    private ListView right;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        root = (NoSlidePager) inflater.inflate(R.layout.fragment_menu, container, false);
        return root;
    }

    @Override
    protected void initData() {
//        ViewPager
        left = (ListView) root.getChildAt(0);
        LogUtils.log("hahah",root.getChildAt(0)+"");
        right = (ListView) root.getChildAt(1);
        left.setOnItemClickListener(this);
        right.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LogUtils.log("gat","conin");
        if (left==parent){
            if (position==left.getCount()-1){
                root.setCurrentItem(1);
                LogUtils.log("gat","left");
            }
        }else {
            if (position==0){
                root.setCurrentItem(0);
                LogUtils.log("gat","right");
            }
        }
    }
}
