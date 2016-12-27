package com.dawei.silkroad.dev.user.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.artists.ui.ArtistDataActivity;
import com.dawei.silkroad.dev.artists.ui.ArtistOfficialActivity;
import com.dawei.silkroad.dev.cooperative.CooperationOpportunityActivity;
import com.dawei.silkroad.dev.cooperative.CooperativeActivity;
import com.dawei.silkroad.dev.cooperative.CooperativeStoreActivity;
import com.dawei.silkroad.dev.message.MessageActivity;
import com.dawei.silkroad.dev.order.ui.OrderActivity;
import com.dawei.silkroad.dev.setting.SettingActivity;
import com.dawei.silkroad.dev.shops.ui.OpenShopActivity;
import com.dawei.silkroad.dev.store.ui.StoreInformationActivity;
import com.dawei.silkroad.dev.logic.LoginActivity;

public class MineFragment extends Fragment implements View.OnClickListener {
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
            view = inflater.inflate(R.layout.fragment_mine, null);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        textView.setText(getResources().getText(R.string.mine));
        view.findViewById(R.id.title_back).setVisibility(View.GONE);
        TextView tv_setting = (TextView) view.findViewById(R.id.tv_titleRight);
        tv_setting.setText(getResources().getText(R.string.setting));
        tv_setting.setOnClickListener(this);
        view.findViewById(R.id.btn_messages).setOnClickListener(this);
        view.findViewById(R.id.btn_order).setOnClickListener(this);
        view.findViewById(R.id.apply_artist).setOnClickListener(this);
        view.findViewById(R.id.open_store).setOnClickListener(this);
        view.findViewById(R.id.cooperative_artist).setOnClickListener(this);
        view.findViewById(R.id.btn_cooperative_store).setOnClickListener(this);
        view.findViewById(R.id.lin_login).setOnClickListener(this);
        view.findViewById(R.id.coo_opportunity).setOnClickListener(this);
        view.findViewById(R.id.art_official).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_titleRight:
                startActivity(new Intent(getContext(), SettingActivity.class));
                break;
            case R.id.btn_messages:
                startActivity(new Intent(getContext(), MessageActivity.class));
                break;
            case R.id.apply_artist:
                startActivity(new Intent(getContext(), ArtistDataActivity.class));
                break;
            case R.id.open_store:
                startActivity(new Intent(getContext(), OpenShopActivity.class));
                break;
            case R.id.cooperative_artist:
                startActivity(new Intent(getContext(), CooperativeActivity.class));
                break;
            case R.id.btn_cooperative_store:
                startActivity(new Intent(getContext(), CooperativeStoreActivity.class));
                break;
            case R.id.lin_login:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.coo_opportunity:
                startActivity(new Intent(getContext(), CooperationOpportunityActivity.class));
                break;
            case R.id.btn_order:
                startActivity(new Intent(getContext(), OrderActivity.class));
                break;
            case R.id.art_official:
                startActivity(new Intent(getContext(), ArtistOfficialActivity.class));
                break;
        }
    }
}
