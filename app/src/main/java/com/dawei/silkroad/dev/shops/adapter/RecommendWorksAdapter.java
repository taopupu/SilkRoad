package com.dawei.silkroad.dev.shops.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;

public class RecommendWorksAdapter extends RecyclerView.Adapter<RecommendWorksAdapter.MyHolder> {
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recommend, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
