package com.dawei.silkroad.dev.artists;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;


public class WorksAdapter extends RecyclerView.Adapter<WorksAdapter.WorksHolder> {
    @Override
    public WorksHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WorksHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_works, parent, false));
    }

    @Override
    public void onBindViewHolder(WorksHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class WorksHolder extends RecyclerView.ViewHolder {
        public WorksHolder(View itemView) {
            super(itemView);
        }
    }
}
