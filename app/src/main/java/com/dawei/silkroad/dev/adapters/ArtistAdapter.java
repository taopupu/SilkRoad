package com.dawei.silkroad.dev.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.AddressManagerActivity;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyHolder> {
    Context context;


    public ArtistAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artist_header, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((BaseActivity.screenWidth / 3) - 30, BaseActivity.screenWidth / 3 - 30);
        holder.img_header.setLayoutParams(params);
        holder.img_header.setImageResource(R.mipmap.welcome);
        holder.img_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, AddressManagerActivity.class));
            }
        });
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
