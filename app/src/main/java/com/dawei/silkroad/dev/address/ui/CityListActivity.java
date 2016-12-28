package com.dawei.silkroad.dev.address.ui;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class CityListActivity extends BaseActivity {
    private ListView lv_address;
    String id;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        receive();
        initView();
        connect();
    }

    private void receive() {
        id = getIntent().getStringExtra("idKey");
        name = getIntent().getStringExtra("namekey");
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.address_manager));
        onBack(get(R.id.title_back));
        lv_address = get(R.id.lv_address);

    }

    private void connect() {

    }
}
