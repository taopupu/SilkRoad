package com.dawei.silkroad.dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.adapters.CommodityAdapter;
import com.dawei.silkroad.view.PopWindow;

public class MallActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView rv_commodity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.mall));
        onBack(get(R.id.title_back));
        TextView tv_filter = get(R.id.tv_titleRight);
        tv_filter.setText(getResources().getText(R.string.filter));
        tv_filter.setOnClickListener(this);
        rv_commodity = get(R.id.commodity);
        rv_commodity.setLayoutManager(new GridLayoutManager(this, 2));
        rv_commodity.setAdapter(new CommodityAdapter(this));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_titleRight:
                pop(get(R.id.title));
                break;
        }
    }


    private void pop(View view) {
        final PopWindow popWindow = new PopWindow(this);
        popWindow.backgroundAlpha(0.5f,getWindow());
        popWindow.showAsDropDown(view);
       popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
           @Override
           public void onDismiss() {
               popWindow.backgroundAlpha(1.0f,getWindow());
           }
       });

    }
}
