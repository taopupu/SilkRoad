package com.dawei.silkroad.dev.home.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.user.ui.MineFragment;

/**
 * 主页面(首页、我的等)
 */
public class HomePagerActivity extends BaseActivity{
    private FragmentManager manager;
    private HomePagerFragment f1;
    private MineFragment f2;
    private FragmentTransaction transaction;

    private Fragment showFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pager);
        initView();
    }


    private void initView() {

        f1 = new HomePagerFragment();
        f2 = new MineFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        showFragment = f1;
        transaction.add(R.id.fg, f1);
        transaction.commit();
        ((RadioButton)get(R.id.lin_home)).setChecked(true);

        ((RadioGroup)get(R.id.icon_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.lin_home){
                    switchContent(showFragment,f1,transaction,manager);
                }else {
                    switchContent(showFragment,f2,transaction,manager);
                }
            }
        });
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