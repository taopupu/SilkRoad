package com.dawei.silkroad.dev.setting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.aboutUs.AboutUsActivity;
import com.dawei.silkroad.dev.address.ui.AddressActivity;
import com.dawei.silkroad.dev.logic.ChangePwdActivity;
import com.dawei.silkroad.util.DataCleanManager;
import com.dawei.silkroad.view.SweetDialog;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    TextView cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.setting));
        onBack(get(R.id.title_back));
        cache = get(R.id.tv_cache);
        try {
            cache.setText(DataCleanManager.getTotalCacheSize(getApplicationContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        get(R.id.address_manage).setOnClickListener(this);
        get(R.id.rv_change_pwd).setOnClickListener(this);
        get(R.id.sign_out).setOnClickListener(this);
        get(R.id.about_us).setOnClickListener(this);
        get(R.id.clean).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.address_manage:
                intentActivity(AddressActivity.class);
                break;
            case R.id.rv_change_pwd:
                intentActivity(ChangePwdActivity.class);
                break;
            case R.id.about_us:
                intentActivity(AboutUsActivity.class);
                break;
            case R.id.clean:
                init();
                break;
            case R.id.sign_out:
                user.flag = false;
                user.id = 0;
                user.save();
                MainApplication.application.killBefore();
                finish();
                break;
        }
    }

    private void init() {
        new SweetDialog(this).setConfirmClickListener(new SweetDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetDialog sweetDialog) {
                DataCleanManager.clearAllCache(getApplicationContext());
                try {
                    cache.setText(DataCleanManager.getTotalCacheSize(getApplicationContext()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).show();
    }

}
