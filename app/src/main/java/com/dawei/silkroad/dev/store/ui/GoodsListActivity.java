package com.dawei.silkroad.dev.store.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.store.ui.adapter.GoodsListAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class GoodsListActivity extends BaseActivity {
    private XRecyclerView rv_goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.goods_list));
        onBack(get(R.id.title_back));
        rv_goodsList = get(R.id.goods_list);
        rv_goodsList.setLayoutManager(new GridLayoutManager(this, 2));
        rv_goodsList.setAdapter(new GoodsListAdapter());
    }
}
