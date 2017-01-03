package com.example.liyang.youhobuy.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liyang.youhobuy.R;
import com.example.liyang.youhobuy.view.PullToRefresh;
import com.example.liyang.youhobuy.view.SuperRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liyang on 2016/12/27.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.pullfresh)
    PullToRefresh pullfresh;
    private View root;
    private SuperRecyclerView recyclerView;
    List<String > recyclelist = new ArrayList<>();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        recyclerView = (SuperRecyclerView) pullfresh.getChildAt(2);
        return root;
    }

    @Override
    protected void initData() {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        String[] stringArray = getResources().getStringArray(R.array.testData);
        List<String> list = Arrays.asList(stringArray);
        recyclelist.addAll(list);
    }

    @Override
    protected void initAdapter() {
        recyclerView.setAdapter(new MyAdapter());
    }

   class MyAdapter extends RecyclerView.Adapter<MyHolder>{

       @Override
       public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           return new MyHolder(View.inflate(getContext(),android.R.layout.simple_list_item_1,null));
       }

       @Override
       public void onBindViewHolder(MyHolder holder, int position) {
           holder.tv.setText(recyclelist.get(position));
       }

       @Override
       public int getItemCount() {
           return recyclelist.size();
       }
   }

    private class MyHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
             tv = (TextView) itemView;
        }
    }
}
