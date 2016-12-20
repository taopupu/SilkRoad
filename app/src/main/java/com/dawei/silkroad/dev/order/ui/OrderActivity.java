package com.dawei.silkroad.dev.order.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.artists.adapter.TabAdapter;
import com.dawei.silkroad.dev.artists.ui.InformationFragment;
import com.dawei.silkroad.dev.artists.ui.PersonalPointFragment;
import com.dawei.silkroad.dev.artists.ui.WorksFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends BaseActivity {

    private TabLayout tab_order;
    private ViewPager vp_order;
    private List<Fragment> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        addFragment();
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getString(R.string.my_order));
        onBack(get(R.id.title_back));
        tab_order = get(R.id.tab_order);
        vp_order = get(R.id.vp_order);
        FragmentManager manager = getSupportFragmentManager();
        TabAdapter adapter = new TabAdapter(manager, list);
        vp_order.setAdapter(adapter);
        vp_order.setCurrentItem(0);
        tab_order.setupWithViewPager(vp_order);
        tab_order.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorMain));
        tab_order.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.colorMain));
        tab_order.getTabAt(0).setText(getResources().getText(R.string.all));
        tab_order.getTabAt(1).setText(getResources().getText(R.string.waiting_payment));
        tab_order.getTabAt(2).setText(getResources().getText(R.string.waiting_delivery));
        tab_order.getTabAt(3).setText(getResources().getText(R.string.waiting_goods_receipt));
        tab_order.getTabAt(4).setText(getResources().getText(R.string.waiting_evaluate));
    }

    private void addFragment() {
        list = new ArrayList<>();
        list.add(new OrderListFragment(0));
        list.add(new OrderListFragment(1));
        list.add(new OrderListFragment(2));
        list.add(new OrderListFragment(3));
        list.add(new OrderListFragment(4));
    }
}
