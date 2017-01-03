package com.example.liyang.youhobuy.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.liyang.youhobuy.Event.GoToEvent;
import com.example.liyang.youhobuy.R;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liyang on 2016/12/27.
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.shouye)
    RadioButton shouye;
    @BindView(R.id.fenlei)
    RadioButton fenlei;
    @BindView(R.id.guang)
    RadioButton guang;
    @BindView(R.id.gouwuche)
    RadioButton gouwuche;
    @BindView(R.id.wode)
    RadioButton wode;
    @BindView(R.id.naviGroup)
    RadioGroup naviGroup;
    @BindView(R.id.fragmentContainer)
    FrameLayout fragmentContainer;
    private View root;
    private List<View> list;
    private HomeFragment homeFragment;
    private CateFragment cateFragment;
    private GuangFragment guangFragment;
    private ShopBuyFragment shopBuyFragment;
    private MineFragment mineFragment;
    private int currentId;
    private int currentPosition;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        list = new ArrayList<>();
        list.add(shouye);
        list.add(fenlei);
        list.add(guang);
        list.add(gouwuche);
        list.add(wode);
        return root;
    }

    @Override
    protected void initData() {
        initFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit();
        currentPosition = 0;
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        cateFragment = new CateFragment();
        guangFragment = new GuangFragment();
        shopBuyFragment = new ShopBuyFragment();
        mineFragment = new MineFragment();
    }

    @OnClick({R.id.shouye, R.id.fenlei, R.id.guang, R.id.gouwuche, R.id.wode})
    public void onClick(View view) {
                if (view.getId() == getCurrentId()) {
                    if (currentPosition == 0) {
                        EventBus.getDefault().post(new GoToEvent());
                        return;
                    }
                }
        switch (view.getId()) {
            case R.id.shouye:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit();
                currentPosition = 0;
                break;
            case R.id.fenlei:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, cateFragment).commit();
                currentPosition = 1;
                break;
            case R.id.guang:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, guangFragment).commit();
                currentPosition = 2;
                break;
            case R.id.gouwuche:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, shopBuyFragment).commit();
                currentPosition = 3;
                break;
            case R.id.wode:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, mineFragment).commit();
                currentPosition = 4;
                break;
        }
    }

    public int getCurrentId() {
        return list.get(currentPosition).getId();
    }
}
