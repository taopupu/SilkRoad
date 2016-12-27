package com.dawei.silkroad.dev.address.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.address.adapter.ReceiveAddressAdapter;
import com.dawei.silkroad.view.DialogStringChoose;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends BaseActivity implements View.OnClickListener {
    RelativeLayout rl_add;
    ListView list_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.address));
        rl_add = get(R.id.rl_add);
        list_address = get(R.id.list_address);
        list_address.setAdapter(new ReceiveAddressAdapter());
        rl_add.setOnClickListener(this);
        get(R.id.title_back).setOnClickListener(this);
        init();
    }

    private void init() {
        list_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intentActivity(MineAddressManagerActivity.class);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_add:
                intentActivity(AddNewAddressActivity.class);
//                aa();
                break;
            case R.id.title_back:
                onBackPressed();
                break;
        }
    }

    private void aa() {
        List<String> list = new ArrayList<>();
        list.add("niha");
        list.add("niha");
        list.add("niha");
        list.add("niha");
        DialogStringChoose dialogStringChoose = new DialogStringChoose(this);
        dialogStringChoose.setInitData(list);
        dialogStringChoose.show();
    }
}
