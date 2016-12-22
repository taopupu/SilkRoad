package com.dawei.silkroad.dev.news;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class NewsPagerAdapter extends PagerAdapter {
    private ArrayList<View> viewContainter;//tab对应的视图
    private ArrayList<String> titleContainer;//tab的标题

    public NewsPagerAdapter(ArrayList<View> viewContainter, ArrayList<String> titleContainer) {
        this.viewContainter = viewContainter;
        this.titleContainer = titleContainer;
    }


    @Override
    public int getCount() {
        return viewContainter.size();
    }

    /*
    * 初始化item
    *   做了两件事，第一：将当前视图添加到container中，第二：返回当前View
    *
    *   这个函数的实现的功能是创建指定位置的页面视图。
    *   适配器有责任增加即将创建的View视图到这里给定的container中，
    *   这是为了确保在finishUpdate(viewGroup)返回时this is be done!

    返回值：返回一个代表新增视图页面的Object（Key），这里没必要非要返回视图本身，
        也可以这个页面的其它容器。其实我的理解是可以代表当前页面的任意值，
        只要你可以与你增加的View一一对应即可，比如position变量也可以做为Key
    * */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(viewContainter.get(position));
        return viewContainter.get(position);
    }

    /*滑动切换的时候销毁当前组件
    *   从当前container中删除指定位置（position）的View;
    * */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(viewContainter.get(position));
    }

    /*
    * */
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    /*为每个页面提供页面标题*/
    @Override
    public CharSequence getPageTitle(int position) {
        return titleContainer.get(position);
    }

    /*
    * 该函数用来判断instantiateItem(ViewGroup, int)
    *   函数所返回来的Key与一个页面视图是否是代表的同一个视图(即它俩是否是对应的，对应的表示同一个View)
    *
    *返回值：如果对应的是同一个View，返回True，否则返回False。
    * */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;  //官方提示这样写
    }
}
