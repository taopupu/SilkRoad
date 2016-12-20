package com.dawei.silkroad.dev.order.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.order.OrderBeen;

import java.util.List;

/**
 * Created by yuanbaojun on 2016/12/20.
 */

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderItemHolder>{

    List<OrderBeen> datas;
    Context context;

    public OrderListAdapter(List<OrderBeen> datas) {
        this.datas = datas;
    }

    @Override
    public OrderItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) context = parent.getContext();
        return new OrderItemHolder(LayoutInflater.from(context).inflate(R.layout.item_order_list,parent,false));
    }

    @Override
    public void onBindViewHolder(OrderItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }

    public class OrderItemHolder extends RecyclerView.ViewHolder{

        public OrderItemHolder(View itemView) {
            super(itemView);
        }
    }
}
