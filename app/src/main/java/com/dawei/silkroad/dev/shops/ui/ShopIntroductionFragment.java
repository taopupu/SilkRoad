package com.dawei.silkroad.dev.shops.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.shops.adapter.ShopArtAdapter;

public class ShopIntroductionFragment extends Fragment {
    View view;
    RecyclerView rv_art;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (null != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        if (null == view) {
            view = inflater.inflate(R.layout.fragment_shop_introduction, null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        rv_art = (RecyclerView) view.findViewById(R.id.rv_art);
        rv_art.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_art.setAdapter(new ShopArtAdapter());
    }
}
