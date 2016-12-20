package com.dawei.silkroad.dev.store.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.dawei.silkroad.R;

/**
 * Created by 56890 on 2016/12/19.
 */

public class PopWindow extends PopupWindow {

    View view;

    public PopWindow(Context context) {
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
        view = layoutInflater.inflate(R.layout.layout_popwindow, null);
        setContentView(view);
    }

}
