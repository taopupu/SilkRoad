package com.dawei.silkroad.dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.adapters.AddressAdapter;

import java.util.List;

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
        lv_address = get(R.id.lv_address);
        lv_address.setAdapter(new AddressAdapter());
    }
}
