package com.dawei.silkroad.dev.store.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.artists.adapter.TabAdapter;
import com.dawei.silkroad.dev.order.ui.OrderListFragment;
import com.dawei.silkroad.dev.store.adapter.CommodityAdapter;
import com.dawei.silkroad.dev.store.adapter.ExamplePagerAdapter;
import com.dawei.silkroad.dev.store.ui.fragments.CulturalCreationFragment;
import com.dawei.silkroad.dev.store.ui.fragments.FineArtsFragment;
import com.dawei.silkroad.dev.store.ui.fragments.IndustrialArtFragment;
import com.dawei.silkroad.dev.store.ui.fragments.NonCulturalHeritageFragment;
import com.dawei.silkroad.dev.store.ui.fragments.SpecialtyFragment;
import com.dawei.silkroad.dev.store.ui.fragments.UpToDateFragment;
import com.dawei.silkroad.dev.store.view.PopWindow;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MallActivity extends BaseActivity implements View.OnClickListener {
    //    private static final String[] CHANNELS = new String[]{"最新", "美术", "工美", "非遗", "文创", "特产"};
//    private List<String> mDataList = Arrays.asList(CHANNELS);
//    private List<View> lists = new ArrayList<>();
    ViewPager viewPager;
    TabLayout tab_mall;
    List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        addFragment();
        init();
    }

//    private void addView() {
//
//        for (int i = 0; i < CHANNELS.length; i++) {
//            View view1 = LayoutInflater.from(this).inflate(R.layout.layout_mall_item, null);
//            lists.add(view1);
//        }
//    }

    private void initView() {
//        viewPager = get(R.id.vp_type);
//        ExamplePagerAdapter mExamplePagerAdapter = new ExamplePagerAdapter(mDataList, lists);
//        viewPager.setAdapter(mExamplePagerAdapter);
//        initMagicIndicator();
//        TextView tv_title = get(R.id.tv_title);
//        tv_title.setText(getResources().getText(R.string.mall));
//        onBack(get(R.id.title_back));
//        TextView tv_filter = get(R.id.tv_titleRight);
//        tv_filter.setText(getResources().getText(R.string.filter));
//        tv_filter.setOnClickListener(this);
//        rv_commodity = get(R.id.commodity);
//        rv_commodity.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
//        rv_commodity.setAdapter(new CommodityAdapter(geturl ()));

    }

    private void init() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.mall));
        onBack(get(R.id.title_back));
        tab_mall = get(R.id.tab_mall_type);
        viewPager = get(R.id.vp_type);
        FragmentManager manager = getSupportFragmentManager();
        TabAdapter adapter = new TabAdapter(manager, list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        tab_mall.setupWithViewPager(viewPager);
        tab_mall.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorMain));
        tab_mall.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.colorMain));
        tab_mall.getTabAt(0).setText("最新");
        tab_mall.getTabAt(1).setText("美术");
        tab_mall.getTabAt(2).setText("工美");
        tab_mall.getTabAt(3).setText("非遗");
        tab_mall.getTabAt(4).setText("文创");
        tab_mall.getTabAt(5).setText("特产");
    }

    private void addFragment() {
        list = new ArrayList<>();
        list.add(new UpToDateFragment());
        list.add(new FineArtsFragment());
        list.add(new IndustrialArtFragment());
        list.add(new NonCulturalHeritageFragment());
        list.add(new CulturalCreationFragment());
        list.add(new SpecialtyFragment());
    }
//    private void initMagicIndicator() {
//        MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.mi_mall);
//
//        magicIndicator.setBackgroundColor(getResources().getColor(R.color.colorMain));
//        CommonNavigator commonNavigator = new CommonNavigator(this);
//        commonNavigator.setLeftPadding(BaseActivity.screenWidth / 2);
//        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
//            @Override
//            public int getCount() {
//                return mDataList == null ? 0 : mDataList.size();
//            }
//
//            @Override
//            public IPagerTitleView getTitleView(Context context, final int index) {
//                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
//                simplePagerTitleView.setText(mDataList.get(index));
//                simplePagerTitleView.setNormalColor(Color.parseColor("#88ffffff"));
//                simplePagerTitleView.setSelectedColor(Color.WHITE);
//                simplePagerTitleView.setTextSize(15);
//                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        viewPager.setCurrentItem(index);
//                    }
//                });
//                return simplePagerTitleView;
//            }
//
//            @Override
//            public IPagerIndicator getIndicator(Context context) {
//                LinePagerIndicator indicator = new LinePagerIndicator(context);
//                indicator.setColors(getResources().getColor(R.color.colorWhite));
//                return indicator;
//            }
//        });
//        magicIndicator.setNavigator(commonNavigator);
//        ViewPagerHelper.bind(magicIndicator, viewPager);
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.tv_titleRight:
//                pop(get(R.id.title));
//                break;
        }
    }

    private void pop(View view) {
        final PopWindow popWindow = new PopWindow(this);
        popWindow.backgroundAlpha(0.5f, getWindow());
        popWindow.showAsDropDown(view);
        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popWindow.backgroundAlpha(1.0f, getWindow());
            }
        });

    }

}
