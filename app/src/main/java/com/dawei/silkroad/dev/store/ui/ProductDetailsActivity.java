package com.dawei.silkroad.dev.store.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.shops.ui.ShopHomeActivity;
import com.dawei.silkroad.view.LocalImageHolderView;
import com.dawei.silkroad.view.SharePopWindow;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends BaseActivity implements View.OnClickListener {
    private ConvenientBanner convenientBanner;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        TextView share = get(R.id.tv_titleRight);
        share.setOnClickListener(this);
        get(R.id.tv_offical).setOnClickListener(this);
        get(R.id.btn_buy).setOnClickListener(this);
        tv_title.setText(getResources().getText(R.string.detail));
        share.setText(getResources().getText(R.string.share));
        onBack(get(R.id.title_back));
        convenientBanner = (ConvenientBanner) findViewById(R.id.product_cb);
        list = new ArrayList<>();
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        carousel();
    }

    private void carousel() {
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, list)
                .setPageIndicator(new int[]{R.drawable.point_2, R.drawable.point_1})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).startTurning(5000).
                setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_titleRight:
                showPopWindow(null);
                break;
            case R.id.btn_buy:
                intentActivity(FirmOrderActivity.class);
                break;
            case R.id.tv_offical:
                intentActivity(ShopHomeActivity.class);
                break;
        }
    }

    private void showPopWindow(View view) {
        final SharePopWindow sharePopWindow = new SharePopWindow(this);
        sharePopWindow.backgroundAlpha(0.5f, getWindow());
        sharePopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                sharePopWindow.backgroundAlpha(1.0f, getWindow());
            }
        });
    }
}
