package com.dawei.silkroad.dev.address.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.address.bean.ReceiveAddressList;

import java.util.List;

public class ReceiveAddressAdapter extends BaseAdapter {

    List<ReceiveAddressList> lists;

    public ReceiveAddressAdapter(List<ReceiveAddressList> lists) {
        this.lists = lists;
    }

    private void addAddress(ReceiveAddressList receiveAddressList) {
        lists.add(receiveAddressList);
        notifyDataSetChanged();
    }

    public void addList(List<ReceiveAddressList> lists) {
        for (int i = 0; i < lists.size(); i++) {
            addAddress(lists.get(i));
        }
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_address, viewGroup, false);
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
        TextView address = (TextView) view.findViewById(R.id.address);
        tv_name.setText(lists.get(i).addName);
        tv_phone.setText(lists.get(i).addMobile);
        address.setText(lists.get(i).provinceName+lists.get(i).countyName+lists.get(i).addAddress);
        return view;
    }
}
