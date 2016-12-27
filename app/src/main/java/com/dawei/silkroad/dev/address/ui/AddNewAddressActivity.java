package com.dawei.silkroad.dev.address.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class AddNewAddressActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_address);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.add_new_address));
        onBack(get(R.id.title_back));
        TextView tv_save = get(R.id.tv_titleRight);
        tv_save.setText(getResources().getText(R.string.save));
    }
}
