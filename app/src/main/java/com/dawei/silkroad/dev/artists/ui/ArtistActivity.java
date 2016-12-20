package com.dawei.silkroad.dev.artists.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class ArtistActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist2);
        initView();
    }
    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        TextView tv_filter = get(R.id.tv_titleRight);
        tv_title.setText(getResources().getText(R.string.artists));
        tv_filter.setText(getResources().getText(R.string.filter));
        onBack(get(R.id.title_back));
    }
}
