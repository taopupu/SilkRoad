package com.dawei.silkroad.dev.store.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;

/**
 * Created by 56890 on 2016/12/27.
 */

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.MyHolder> {
    Context context;

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) context = parent.getContext();
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.layout_recommend, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
