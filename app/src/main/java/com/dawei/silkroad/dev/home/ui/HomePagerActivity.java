package com.dawei.silkroad.dev.home.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.user.ui.MineFragment;

/**
 * 主页面(首页、我的等)
 */
public class HomePagerActivity extends BaseActivity implements View.OnClickListener {
    private FragmentManager manager;
//    private Fragment[] fragment;
    private HomePagerFragment f1;
    private MineFragment f2;
    private FragmentTransaction transaction;
    private LinearLayout lin_home, lin_mine;

    private Fragment showFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pager);
        initView();
    }

    private void buildFragmentView() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
//        fragment = new Fragment[2];
//        f1 = new HomePagerFragment();
//        fragment[0] = f1;
//        transaction.add(R.id.fg, fragment[0]);
//        transaction.commit();
        showFragment = f1;
        transaction.add(R.id.fg, f1);
        transaction.commit();
    }

    private void initView() {
        lin_home = (LinearLayout) findViewById(R.id.lin_home);
        lin_mine = (LinearLayout) findViewById(R.id.lin_mine);
        lin_mine.setOnClickListener(this);
        lin_home.setOnClickListener(this);
        f1 = new HomePagerFragment();
        f2 = new MineFragment();
        buildFragmentView();
    }


    @Override
    public void onClick(View view) {
        transaction = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.lin_home:
                switchContent(showFragment,f1,transaction,manager);
                break;
            case R.id.lin_mine:
                switchContent(showFragment,f2,transaction,manager);
                break;
        }
        transaction.commit();
    }

    public void switchContent(Fragment from, Fragment to,FragmentTransaction ft,
                              FragmentManager fm) {
        if (from != null) {
            ft = fm.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                ft.hide(from).add(R.id.fg, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                ft.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
        showFragment = to;
    }

}