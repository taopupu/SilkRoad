package com.dawei.silkroad.dev.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.adapters.HomeAdapter;
import com.dawei.silkroad.dev.artists.ArtistOfficialActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class HomePagerFragment extends Fragment {
    private ConvenientBanner convenientBanner;
    private List<Integer> list;
    private List<Integer> content;
    private XRecyclerView rv_content;
    View view;

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
        list = new ArrayList<>();
        content = new ArrayList<>();

        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        content.add(1);
        content.add(2);
        rv_content = (XRecyclerView) getActivity().findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(getActivity()));
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.item_header_view, null);
        view1.findViewById(R.id.artist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ArtistOfficialActivity.class));
            }
        });
        rv_content.addHeaderView(view1);
        rv_content.setAdapter(new HomeAdapter(content, getActivity()));
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("丝路汇");
        view.findViewById(R.id.title_back).setVisibility(View.GONE);
        convenientBanner = (ConvenientBanner) view1.findViewById(R.id.convenientBanner);
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

    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }
}
