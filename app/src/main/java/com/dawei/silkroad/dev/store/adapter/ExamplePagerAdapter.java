package com.dawei.silkroad.dev.store.adapter;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dawei.silkroad.R;

import java.util.List;

public class ExamplePagerAdapter extends PagerAdapter {
    private List<String> mDataList;
    private List<View> list;

    public ExamplePagerAdapter(List<String> mDataList, List<View> list) {
        this.mDataList = mDataList;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(list.get(position));
    }

    @Override
    public int getItemPosition(Object object) {
//        TextView textView = (TextView) object;
//        String text = textView.getText().toString();
//        int index = list.indexOf(text);
//        if (index >= 0) {
//            return index;
//        }
//        return POSITION_NONE;
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position);
    }
}
