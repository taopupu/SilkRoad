package com.dawei.silkroad.view;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.dawei.silkroad.R;

public class SweetDialog extends Dialog {
    public SweetDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);
    }
}
