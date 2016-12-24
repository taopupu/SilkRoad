package com.dawei.silkroad.dev.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.aboutUs.AboutUsActivity;
import com.dawei.silkroad.dev.address.ui.AddressActivity;
import com.dawei.silkroad.dev.home.ui.HomePagerActivity;
import com.dawei.silkroad.dev.logic.ChangePwdActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

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
        get(R.id.address_manage).setOnClickListener(this);
        get(R.id.rv_change_pwd).setOnClickListener(this);
        get(R.id.sign_out).setOnClickListener(this);
        get(R.id.about_us).setOnClickListener(this);
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
            case R.id.sign_out:
                user.flag=false;
                user.id=0;
                user.save();
                MainApplication.application.killBefore();
                intentActivity(HomePagerActivity.class);
                finish();
                break;
        }
    }
}
