package com.dawei.silkroad.dev.store.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.store.adapter.CommodityAdapter;
import com.dawei.silkroad.dev.store.adapter.ExamplePagerAdapter;
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
    private RecyclerView rv_commodity;
    private static final String[] CHANNELS = new String[]{"最新", "美术", "工美", "非遗", "文创", "特产"};
    private List<String> mDataList = Arrays.asList(CHANNELS);
    private List<View> lists = new ArrayList<>();
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        addView();
        initView();
    }

    private void addView() {

        for (int i = 0; i < CHANNELS.length; i++) {
            View view1 = LayoutInflater.from(this).inflate(R.layout.layout_mall_item, null);
            lists.add(view1);
        }
    }

    private void initView() {
        viewPager = get(R.id.vp_type);
        ExamplePagerAdapter mExamplePagerAdapter = new ExamplePagerAdapter(mDataList, lists);
        viewPager.setAdapter(mExamplePagerAdapter);
        initMagicIndicator();
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

    private void initMagicIndicator() {
        MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.mi_mall);

        magicIndicator.setBackgroundColor(getResources().getColor(R.color.colorMain));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setLeftPadding(BaseActivity.screenWidth / 2);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setNormalColor(Color.parseColor("#88ffffff"));
                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(getResources().getColor(R.color.colorWhite));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

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

    List<String> geturl() {
        List<String> list = new ArrayList<>();
        list.add("http://img2.scimg.cn/userupload/auction/items/886/449768/orig/5e8fad57736feadccb605f224e228e51.jpg");
        list.add("http://pic24.nipic.com/20121024/310438_162351346110_2.jpg");
        list.add("http://img005.hc360.cn/y2/M03/D5/92/wKhQdFSNOSmEdLsAAAAAADPD-BI808.jpg");
        list.add("http://img2.scimg.cn/userupload/auction/items/4250/655905/orig/cc9e00c31ac423f4bd4a58c92c0b57ee.jpg");
        list.add("http://img2.scimg.cn/userupload/auction/items/2943/512032/orig/6f3778b7fff6e1b0ccc97a710821c0a8.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=3869282230,125610845&fm=214&gp=0.jpg");
        list.add("http://imagecdn.edeng.cn/uimages/6/46/64/152614044.gif");
        list.add("http://pic26.nipic.com/20121225/310438_133115625143_2.jpg");
        list.add("http://file5.gucn.com/file2/CurioPicfile/20130408/Gucn_2013040881940152015Pic2.jpg");
        list.add("http://s13.sinaimg.cn/mw690/001Oel7Hgy6YGhEvfK44c");
        list.add("http://s13.sinaimg.cn/mw690/4e5ada0egcfff256ad4ec&690");
        list.add("http://www.7wchina.com/upload_files/other/43827_20150212140242_qst8m.jpg");
        list.add("http://www.jzshsc.com/data/files/store_3327/goods_142/201503160905425623.jpg");
        list.add("http://pic.58pic.com/58pic/14/87/99/22s58PICQJU_1024.jpg");
        list.add("http://s7.sinaimg.cn/mw690/001J0CiIty6SOGHF89w16&690");
        return list;
    }
}
