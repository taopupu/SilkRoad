package com.dawei.silkroad.dev.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.artists.ui.ArtistActivity;
import com.dawei.silkroad.dev.store.ui.ProductDetailsActivity;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    List<Integer> list;
    Context context;
    List<String> mv_list;

    public HomeAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
        mv_list = new ArrayList<>();
        mv_list.add("丝路汇平台是西安国家级对外文化贸易基地");
        mv_list.add("全国文化产品跨境电商综合试点项目");

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
            shopHolder.marqueeView.startWithList(mv_list);
        } else if (list.get(position) == 2) {
            ArtistHolder artistHolder = (ArtistHolder) holder;
            artistHolder.rv_artist.setLayoutManager(new GridLayoutManager(context, 3));
            artistHolder.rv_artist.setAdapter(new ArtistAdapter(context));
            artistHolder.lin_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ArtistActivity.class));
                }
            });
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
        MarqueeView marqueeView;

        public ShopHolder(View itemView) {
            super(itemView);
            rv_product = (RelativeLayout) itemView.findViewById(R.id.rl_product);
            marqueeView = (MarqueeView) itemView.findViewById(R.id.marqueeView);
        }
    }

    class ArtistHolder extends RecyclerView.ViewHolder {
        RecyclerView rv_artist;
        LinearLayout lin_more;

        public ArtistHolder(View itemView) {
            super(itemView);
            rv_artist = (RecyclerView) itemView.findViewById(R.id.rv_artist);
            lin_more = (LinearLayout) itemView.findViewById(R.id.view_more);
        }
    }
}
