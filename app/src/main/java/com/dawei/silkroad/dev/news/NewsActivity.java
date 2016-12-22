package com.dawei.silkroad.dev.news;

import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

import java.util.ArrayList;

public class NewsActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    ViewPager vp_news;
    PagerTabStrip pager_title;
    ArrayList<View> viewContainter = new ArrayList<>();//tab对应的视图
    ArrayList<String> titleContainer = new ArrayList<>();//tab的标题

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.news));
        onBack(get(R.id.title_back));
        vp_news = get(R.id.vp_news);
        pager_title = get(R.id.pager_title);
        pager_title.setBackgroundColor(getResources().getColor(R.color.colorMain));
        pager_title.setTabIndicatorColor(getResources().getColor(R.color.colorWhite));
        pager_title.setPadding(180, 0, 180, 0);
        pager_title.setTextColor(getResources().getColor(R.color.colorWhite));
        View view1 = LayoutInflater.from(this).inflate(R.layout.layout_opportunity, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layout_opportunity, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.layout_opportunity, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.layout_opportunity, null);
        View view5 = LayoutInflater.from(this).inflate(R.layout.layout_opportunity, null);
        View view6 = LayoutInflater.from(this).inflate(R.layout.layout_opportunity, null);
        //从ViewPager开始添加View
        viewContainter.add(view1);
        viewContainter.add(view2);
        viewContainter.add(view3);
        viewContainter.add(view4);
        viewContainter.add(view5);
        viewContainter.add(view6);
        //页签项
        titleContainer.add("全部");
        titleContainer.add("头条");
        titleContainer.add("快讯");
        titleContainer.add("各地动态");
        titleContainer.add("展览");
        titleContainer.add("图片");
        vp_news.setAdapter(new NewsPagerAdapter(viewContainter, titleContainer));
        vp_news.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
