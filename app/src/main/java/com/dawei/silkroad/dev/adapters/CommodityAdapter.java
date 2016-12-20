package com.dawei.silkroad.dev.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.ProductDetailsActivity;


public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.CommodityHolder> {
    Context context;

    public CommodityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CommodityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommodityHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_commodity, parent, false));
    }

    @Override
    public void onBindViewHolder(CommodityHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ProductDetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class CommodityHolder extends RecyclerView.ViewHolder {
        public CommodityHolder(View itemView) {
            super(itemView);
        }
    }
}
