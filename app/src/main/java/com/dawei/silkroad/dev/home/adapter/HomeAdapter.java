package com.dawei.silkroad.dev.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.store.ui.ProductDetailsActivity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    List<Integer> list;
    Context context;

    public HomeAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new ShopHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_silk, parent, false));
        } else if (viewType == 2) {
            return new ArtistHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artist, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (list.get(position) == 1) {
            ShopHolder shopHolder = (ShopHolder) holder;
            shopHolder.rv_product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ProductDetailsActivity.class));
                }
            });
        } else if (list.get(position) == 2) {
            ArtistHolder artistHolder = (ArtistHolder) holder;
            artistHolder.rv_artist.setLayoutManager(new GridLayoutManager(context, 3));
            artistHolder.rv_artist.setAdapter(new ArtistAdapter(context));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ShopHolder extends RecyclerView.ViewHolder {
        RelativeLayout rv_product;

        public ShopHolder(View itemView) {
            super(itemView);
            rv_product = (RelativeLayout) itemView.findViewById(R.id.rl_product);
        }
    }

    class ArtistHolder extends RecyclerView.ViewHolder {
        RecyclerView rv_artist;

        public ArtistHolder(View itemView) {
            super(itemView);
            rv_artist = (RecyclerView) itemView.findViewById(R.id.rv_artist);
        }
    }
}
