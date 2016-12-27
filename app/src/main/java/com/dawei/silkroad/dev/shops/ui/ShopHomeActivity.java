package com.dawei.silkroad.dev.shops.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.artists.adapter.TabAdapter;
import com.dawei.silkroad.dev.shops.ui.RecommendedWorksFragment;
import com.dawei.silkroad.dev.shops.ui.ShopIntroductionFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopHomeActivity extends BaseActivity {
    TabLayout tab_shop;
    ViewPager vp_shop;
    List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_home);
        addFragment();
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.shop_home));
        onBack(get(R.id.title_back));
        tab_shop = get(R.id.shop_tab);
        vp_shop = get(R.id.store_detail);
        FragmentManager manager = getSupportFragmentManager();
        TabAdapter adapter = new TabAdapter(manager, list);
        vp_shop.setAdapter(adapter);
        vp_shop.setCurrentItem(0);
        tab_shop.setupWithViewPager(vp_shop);
        tab_shop.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorMain));
        tab_shop.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.colorMain));
        tab_shop.getTabAt(0).setText(getResources().getText(R.string.shop_introduction));
        tab_shop.getTabAt(1).setText(getResources().getText(R.string.recommended_works));
    }

    private void addFragment() {
        list = new ArrayList<>();
        list.add(new ShopIntroductionFragment());
        list.add(new RecommendedWorksFragment());
    }
}
