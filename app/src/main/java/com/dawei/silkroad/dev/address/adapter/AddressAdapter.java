package com.dawei.silkroad.dev.address.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.address.bean.ProvinceBean;
import com.dawei.silkroad.dev.address.ui.CityListActivity;
import com.dawei.silkroad.util.StringUtils;

import java.util.List;

public class AddressAdapter extends BaseAdapter {

    List<ProvinceBean> list;
    Context context;

    public AddressAdapter(List<ProvinceBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (context == null) context = viewGroup.getContext();
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_address, viewGroup, false);
        TextView tv_address = (TextView) view.findViewById(R.id.tv_address);

        if (StringUtils.isEmpty(list.get(i).provinceName) && StringUtils.isEmpty(list.get(i).cityName)) {
            tv_address.setText(list.get(i).countyName);
        } else {
            if (StringUtils.isEmpty(list.get(i).provinceName)) {
                tv_address.setText(list.get(i).cityName);
            } else {
                tv_address.setText(list.get(i).provinceName);
            }
        }
        return view;
    }
}
