package com.dawei.silkroad.dev.artists.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.artists.adapter.ArtistListAdapter;

public class ArtistActivity extends BaseActivity {
    RecyclerView rv_artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist2);
        initView();
        artistList();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.artists));
        onBack(get(R.id.title_back));
    }

    private void artistList() {
        rv_artist = get(R.id.rv_artist);
        rv_artist.setLayoutManager(new GridLayoutManager(this, 3));
        rv_artist.setAdapter(new ArtistListAdapter());
    }
}
