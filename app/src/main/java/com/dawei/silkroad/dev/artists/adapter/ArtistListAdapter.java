package com.dawei.silkroad.dev.artists.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;


public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.MyHolder> {
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artist_header, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((BaseActivity.screenWidth / 3) - 60, BaseActivity.screenWidth / 3 - 60);
        holder.img_header.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView img_header;

        public MyHolder(View itemView) {
            super(itemView);
            img_header = (ImageView) itemView.findViewById(R.id.img_header);
        }
    }
}
