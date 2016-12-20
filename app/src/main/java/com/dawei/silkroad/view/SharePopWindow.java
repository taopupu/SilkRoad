package com.dawei.silkroad.view;


import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.dawei.silkroad.R;

public class SharePopWindow extends PopupWindow implements View.OnClickListener {
    View view;

    public SharePopWindow(Context context) {
        super(context);
        init(context);
    }

    public void backgroundAlpha(float bgAlpha, Window window) {
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = bgAlpha;
        window.setAttributes(lp);
    }

    private void init(Context context) {
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setOutsideTouchable(true);
        this.setFocusable(true);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.layout_share, null);
        setContentView(view);
        showAtLocation(view, Gravity.BOTTOM, 0, 0);
        initView();
    }

    private void initView() {
        view.findViewById(R.id.share_weixin).setOnClickListener(this);
        view.findViewById(R.id.share_friends).setOnClickListener(this);
        view.findViewById(R.id.share_qq).setOnClickListener(this);
        view.findViewById(R.id.share_qq_zone).setOnClickListener(this);
        view.findViewById(R.id.share_weibo).setOnClickListener(this);
        view.findViewById(R.id.share_people).setOnClickListener(this);
        view.findViewById(R.id.cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share_weixin:
                break;
            case R.id.share_friends:
                break;
            case R.id.share_qq:
                break;
            case R.id.share_qq_zone:
                break;
            case R.id.share_people:
                break;
            case R.id.share_weibo:
                break;
            case R.id.cancel:
                dismiss();
                break;
        }
    }
}
