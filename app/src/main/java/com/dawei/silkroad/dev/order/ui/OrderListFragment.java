package com.dawei.silkroad.dev.order.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.order.OrderBeen;
import com.dawei.silkroad.dev.order.adapter.OrderListAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanbaojun on 2016/12/20.
 */

public class OrderListFragment extends Fragment{
    int state;
    View view;
    XRecyclerView recyclerView;
    List<OrderBeen> list = new ArrayList<>();


    public OrderListFragment(int state) {
        this.state = state;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (null != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        if (null == view) {
            view = inflater.inflate(R.layout.fragment_order_list, null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        recyclerView = (XRecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.add(new OrderBeen());
        list.add(new OrderBeen());
        list.add(new OrderBeen());
        list.add(new OrderBeen());
        list.add(new OrderBeen());
        recyclerView.setAdapter(new OrderListAdapter(list));
    }

}
