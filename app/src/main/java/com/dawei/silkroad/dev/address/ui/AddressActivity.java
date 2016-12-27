package com.dawei.silkroad.dev.address.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.address.adapter.ReceiveAddressAdapter;
import com.dawei.silkroad.dev.address.bean.ReceiveAddressList;
import com.dawei.silkroad.util.ParseUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class AddressActivity extends BaseActivity implements View.OnClickListener {
    RelativeLayout rl_add;
    ListView list_address;
    List<ReceiveAddressList> lists = new ArrayList<>();
    ReceiveAddressAdapter addressAdapter;

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
        addressAdapter = new ReceiveAddressAdapter(lists);
        list_address.setAdapter(addressAdapter);
        rl_add.setOnClickListener(this);
        get(R.id.title_back).setOnClickListener(this);
        init();
        connectHttp();
    }

    private void init() {
        list_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intentActivity(MineAddressManagerActivity.class);
            }
        });
    }

    private void connectHttp() {
        MainApplication.http.receiveAddress("1527", new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                List<ReceiveAddressList> lists = ParseUtils.fromJsonArray(response, ReceiveAddressList[].class);
                if (lists != null && lists.size() != 0) {
                    addressAdapter.addList(lists);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_add:
                intentActivity(AddNewAddressActivity.class);
                break;
            case R.id.title_back:
                onBackPressed();
                break;
        }
    }
}
