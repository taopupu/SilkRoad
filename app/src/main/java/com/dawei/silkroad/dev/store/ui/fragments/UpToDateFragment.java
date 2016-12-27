package com.dawei.silkroad.dev.store.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.store.ui.GoodsListActivity;

public class UpToDateFragment extends Fragment implements View.OnClickListener {
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
            view = inflater.inflate(R.layout.layout_mall_item, null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        view.findViewById(R.id.view_more).setOnClickListener(this);
        view.findViewById(R.id.view2_more).setOnClickListener(this);
        view.findViewById(R.id.view3_more).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_more:
       getActivity().startActivity(new Intent(getActivity(), GoodsListActivity.class));
                break;
            case R.id.view2_more:
                startActivity(new Intent(getActivity(), GoodsListActivity.class));
                break;
            case R.id.view3_more:
                startActivity(new Intent(getActivity(), GoodsListActivity.class));
                break;
        }
    }
}
