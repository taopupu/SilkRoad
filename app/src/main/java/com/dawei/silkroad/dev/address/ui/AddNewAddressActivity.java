package com.dawei.silkroad.dev.address.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class AddNewAddressActivity extends BaseActivity implements View.OnClickListener {
    TextView address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_address);
        initView();
    }

    private void initView() {
        address = get(R.id.add_newaddress_location);
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.add_new_address));
        onBack(get(R.id.title_back));
        TextView tv_save = get(R.id.tv_titleRight);
        tv_save.setText(getResources().getText(R.string.save));
        tv_save.setOnClickListener(this);
        get(R.id.region_selection).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_titleRight:
                finish();
                break;
            case R.id.region_selection:
                startActivityForResult(new Intent(this, AddressManagerActivity.class), 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 2:
                address.setText(data.getStringExtra("name"));

        }
    }
}
