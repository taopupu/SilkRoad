package com.dawei.silkroad.dev;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.adapters.AddressAdapter;

public class AddressManagerActivity extends BaseActivity {
    private ListView lv_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manager);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.address_manager));
        onBack(get(R.id.title_back));
        lv_address = get(R.id.lv_address);
        lv_address.setAdapter(new AddressAdapter());
        lv_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intentActivity(MineAddressActivity.class);
                finish();
            }
        });
    }
}
