package com.dawei.silkroad.dev.address.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.address.adapter.AddressAdapter;
import com.dawei.silkroad.dev.address.bean.ProvinceBean;
import com.dawei.silkroad.util.ParseUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class AddressManagerActivity extends BaseActivity {
    private ListView lv_address;
    String provinceName;
    String cityName;
    String countryName;
    List<ProvinceBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manager);
        connect();
        initView();

    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.address_manager));
        onBack(get(R.id.title_back));
        lv_address = get(R.id.lv_address);


    }

    private void connect() {
        progress.show();
        MainApplication.http.province_List(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                progress.dismiss();
                List<ProvinceBean> lists = ParseUtils.fromJsonArray(response, ProvinceBean[].class);
                lv_address.setAdapter(new AddressAdapter(lists));
                onClick(lists);
            }
        });
    }

    private void onClick(final List<ProvinceBean> lists) {
        lv_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                provinceName = lists.get(i).provinceName;
                progress.show();
                connectCityList(lists.get(i).id + "");
            }
        });
    }

    private void connectCityList(String id) {
        MainApplication.http.cityList(id, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                progress.dismiss();
                List<ProvinceBean> lists = ParseUtils.fromJsonArray(response, ProvinceBean[].class);
                lv_address.setAdapter(new AddressAdapter(lists));
                onClick1(lists);
            }
        });
    }


    private void onClick1(final List<ProvinceBean> lists) {
        lv_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                progress.show();
                cityName = lists.get(i).cityName;
                connectCountryList(lists.get(i).id + "");
            }
        });
    }

    private void connectCountryList(String id) {
        MainApplication.http.countryList(id, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                progress.dismiss();
                list = ParseUtils.fromJsonArray(response, ProvinceBean[].class);
                lv_address.setAdapter(new AddressAdapter(list));

                lv_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(AddressManagerActivity.this, AddNewAddressActivity.class);
                        if (provinceName.equals(cityName)) {
                            intent.putExtra("name", cityName + list.get(i).countyName);
                        } else {
                            intent.putExtra("name", provinceName + cityName + list.get(i).countyName);
                        }

                        setResult(2, intent);
                        finish();
                    }
                });
            }
        });
    }

}
