package com.dawei.silkroad.dev.logic;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class ForgetPwdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        initView();
    }

    private void initView() {
        ImageView img_back = get(R.id.title_back);
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.forget_password));
        onBack(img_back);
    }
}
