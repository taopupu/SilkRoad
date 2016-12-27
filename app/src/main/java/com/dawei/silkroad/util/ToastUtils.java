package com.dawei.silkroad.util;


import android.widget.Toast;

import com.dawei.silkroad.MainApplication;

public class ToastUtils {
    public static void makeTextShort(String str) {
        Toast.makeText(MainApplication.application, str, Toast.LENGTH_SHORT).show();
    }
}
