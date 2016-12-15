package com.dawei.silkroad.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.dawei.silkroad.R;

public class LoadProgress extends Dialog{
    private static LoadProgress LoadProgress = null;

    public LoadProgress(Context context) {
        super(context);
    }

    public LoadProgress(Context context, int theme) {
        super(context, theme);
    }

    public static LoadProgress createDialog(Context context) {
        LoadProgress = new LoadProgress(context, R.style.CustomProgressDialog2);
        LoadProgress.setContentView(R.layout.custom_progress);
        LoadProgress.getWindow().getAttributes().gravity = Gravity.CENTER;
        LoadProgress.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        return LoadProgress;
    }

    public LoadProgress setTitile(String strTitle) {
        return LoadProgress;
    }
    @Override
    public void show() {
        Animation operatingAnim = AnimationUtils.loadAnimation(getContext(), R.anim.loading);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        if (operatingAnim != null) {
            ImageView iv = (ImageView) LoadProgress.findViewById(R.id.loading);
            iv.startAnimation(operatingAnim);
        }
        super.show();
    }

    @Override
    public void dismiss() {
        ImageView iv = (ImageView) LoadProgress.findViewById(R.id.loading);
        iv.clearAnimation();
        super.dismiss();
    }
}
