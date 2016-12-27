package com.dawei.silkroad.dev.shops.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.store.ui.StoreInformationActivity;

public class OpenShopActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_shop);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.open_preface));
        onBack(get(R.id.title_back));
        get(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentActivity(StoreInformationActivity.class);
            }
        });
    }
}
