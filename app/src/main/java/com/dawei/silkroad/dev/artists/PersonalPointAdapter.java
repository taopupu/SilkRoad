package com.dawei.silkroad.dev.artists;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;


public class PersonalPointAdapter extends RecyclerView.Adapter<PersonalPointAdapter.PointHolder> {
    @Override
    public PointHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PointHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_personal_point,parent,false));
    }

    @Override
    public void onBindViewHolder(PointHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class PointHolder extends RecyclerView.ViewHolder {
        public PointHolder(View itemView) {
            super(itemView);
        }
    }
}
