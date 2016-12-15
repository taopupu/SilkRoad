package com.dawei.silkroad.dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class AddressActivity extends BaseActivity implements View.OnClickListener {
    RelativeLayout rl_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.address_manager));
        rl_add = get(R.id.rl_add);
        rl_add.setOnClickListener(this);
        get(R.id.title_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_add:
                intentActivity(AddressManagerActivity.class);
                break;
            case R.id.title_back:
                onBackPressed();
                break;
        }
    }
}
