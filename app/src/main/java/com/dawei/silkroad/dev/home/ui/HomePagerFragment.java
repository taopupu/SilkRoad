package com.dawei.silkroad.dev.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.store.ui.MallActivity;
import com.dawei.silkroad.dev.news.NewsActivity;
import com.dawei.silkroad.dev.home.adapter.HomeAdapter;
import com.dawei.silkroad.dev.artists.ui.ArtistActivity;
import com.dawei.silkroad.view.LocalImageHolderView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class HomePagerFragment extends Fragment implements View.OnClickListener {
    private ConvenientBanner convenientBanner;
    private List<Integer> list;
    private List<Integer> content;
    private XRecyclerView rv_content;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (null != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        if (null == view) {
            view = inflater.inflate(R.layout.fragment_home_pager, null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("丝路汇");
        view.findViewById(R.id.title_back).setVisibility(View.GONE);
        rv_content = (XRecyclerView) getActivity().findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        content = new ArrayList<>();
        list.add(R.mipmap.production1);
        list.add(R.mipmap.production2);
        list.add(R.mipmap.production3);
        list.add(R.mipmap.production4);
        content.add(1);
        content.add(2);
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.item_header_view, null);
        view1.findViewById(R.id.artist).setOnClickListener(this);
        view1.findViewById(R.id.lin_mall).setOnClickListener(this);
        view1.findViewById(R.id.news).setOnClickListener(this);
        view1.findViewById(R.id.auction).setOnClickListener(this);
        rv_content.addHeaderView(view1);
        rv_content.setAdapter(new HomeAdapter(content, getActivity()));
        convenientBanner = (ConvenientBanner) view1.findViewById(R.id.convenientBanner);
        carousel();

    }

    private void carousel() {
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, list)
                .setPageIndicator(new int[]{R.drawable.point_2, R.drawable.point_1})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT).startTurning(5000).
                setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_mall:
                startActivity(new Intent(getContext(), MallActivity.class));
                break;
            case R.id.artist:
                startActivity(new Intent(getContext(), ArtistActivity.class));
                break;
            case R.id.news:
                startActivity(new Intent(getContext(), NewsActivity.class));
                break;
            case R.id.auction:
                break;
        }
    }
}
