package com.dawei.silkroad.dev.artists.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.artists.adapter.TabAdapter;

import java.util.ArrayList;
import java.util.List;

public class ArtistOfficialActivity extends BaseActivity {

    private TabLayout tab_artist;
    private ViewPager vp_artist;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_official);
        addFragment();
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        TextView share = get(R.id.tv_titleRight);
        tv_title.setText("崔振宽");
        share.setText(getResources().getText(R.string.share));
        onBack(get(R.id.title_back));
        tab_artist = get(R.id.tab_artist);
        vp_artist = get(R.id.vp_artist);
        FragmentManager manager = getSupportFragmentManager();
        TabAdapter adapter = new TabAdapter(manager, list);
        vp_artist.setAdapter(adapter);
        vp_artist.setCurrentItem(0);
        tab_artist.setupWithViewPager(vp_artist);
        tab_artist.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorMain));
        tab_artist.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.colorMain));
        tab_artist.getTabAt(0).setText(getResources().getText(R.string.works));
        tab_artist.getTabAt(1).setText(getResources().getText(R.string.information));
        tab_artist.getTabAt(2).setText(getResources().getText(R.string.personal_point));
    }

    private void addFragment() {
        list = new ArrayList<>();
        list.add(new WorksFragment());
        list.add(new InformationFragment());
        list.add(new PersonalPointFragment());
    }
}
