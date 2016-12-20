package com.dawei.silkroad.dev.store.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class FirmOrderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firm_order2);
        initView();
    }

    private void initView() {
        TextView rv_title = get(R.id.tv_title);
        rv_title.setText(getResources().getText(R.string.firm_order));
        onBack(get(R.id.title_back));
    }
}
