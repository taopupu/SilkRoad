package com.dawei.silkroad.dev;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonalCenterActivity extends BaseActivity {
    XRecyclerView xRecyclerView;
    List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
    }

    private void initView() {
        xRecyclerView = get(R.id.rv_view);
        for (int i = 0; i < 20; i++) {
            list.add(R.mipmap.ic_launcher);
        }
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
