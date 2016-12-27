package com.dawei.silkroad.view;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dawei.silkroad.R;

public class SweetDialog extends Dialog implements View.OnClickListener {
    private TextView title, content;
    private TextView btn_cancel, btn_ok;
    private String titleText;
    private String contentText;
    private OnSweetClickListener mCancelClickListener;
    private OnSweetClickListener mConfirmClickListener;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ok:
                mConfirmClickListener.onClick(this);
                dismiss();
                break;
            case R.id.cancel:
                dismiss();
                break;
        }
    }

    public interface OnSweetClickListener {
        void onClick(SweetDialog sweetDialog);
    }

    public void setContentText(String contentTexts) {
        this.contentText = contentTexts;
        if (contentText != null && content != null) {
            content.setText(contentText);
        }
    }

    public void setTitleText(String titles) {
        this.titleText = titles;
        if (titleText != null && title != null) {
            title.setText(titles);
        }
    }

    public SweetDialog setCancelClickListener(OnSweetClickListener listener) {
        mCancelClickListener = listener;
        return this;
    }

    public SweetDialog setConfirmClickListener(OnSweetClickListener listener) {
        mConfirmClickListener = listener;
        return this;
    }

    public SweetDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);
        initView();

    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        btn_cancel = (TextView) findViewById(R.id.cancel);
        btn_ok = (TextView) findViewById(R.id.ok);
        btn_ok.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }


}
