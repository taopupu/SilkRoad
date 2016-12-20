package com.dawei.silkroad.dev.store.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.store.ui.ProductDetailsActivity;
import com.dawei.silkroad.util.Logs;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.CommodityHolder> {
    Context context;
    List<String> datas;
    private Map<Integer,Integer> mHeights = new HashMap<>();
    public CommodityAdapter(List<String> datas) {
        this.datas = datas;
        for (int i=0;i<datas.size();i++){
            mHeights.put(i,0);
        }
    }

    @Override
    public CommodityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) context = parent.getContext();
        return new CommodityHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_commodity, parent, false));
    }

    @Override
    public void onBindViewHolder(final CommodityHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ProductDetailsActivity.class));
            }
        });
        ImageLoader.getInstance().displayImage(datas.get(position), holder.imageView, MainApplication.baseImageOptions, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {}
            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {}

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                RelativeLayout.LayoutParams lp;
                if (mHeights.get(position) < 0) {
                    lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, mHeights.get(position));
                    holder.imageView.setLayoutParams(lp);
                }else {
                    int h = (bitmap.getHeight() * BaseActivity.screenWidth / 2 -30) /bitmap.getWidth();
                    lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, h);
                    holder.imageView.setLayoutParams(lp);
                    mHeights.put(position,h);
                }
                Logs.e("bitmap","Height:"+holder.imageView.getHeight()+" :"+position);
                ((ImageView)view).setImageBitmap(bitmap);
            }
            @Override
            public void onLoadingCancelled(String s, View view) {}
        });
    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }

    public class CommodityHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public CommodityHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_goods);
        }
    }
}
