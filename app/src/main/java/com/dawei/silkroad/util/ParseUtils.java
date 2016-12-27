package com.dawei.silkroad.util;

import android.text.TextUtils;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.callback.HttpData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;


public class ParseUtils {
    private static final Gson GSON;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        GSON = gsonBuilder.create();
    }


    public static <T> T fromJson(String content, Class<T> clazz) {
        if (TextUtils.isEmpty(content)) {
            ToastUtils.makeTextShort(MainApplication.application.getString(R.string.network_request_failed));
            return null;
        }
        try {
            HttpData been = HttpData.getHttpData(content);
            if (been.flag) {
                return GSON.fromJson(been.data, clazz);
            } else {
                ToastUtils.makeTextShort(been.info);
//                MyApp.getAppToken();
                return null;
            }
        } catch (Exception e) {
            ToastUtils.makeTextShort(MainApplication.application.getString(R.string.request_fail));
            return null;
        }
    }

    public static <T> List<T> fromJsonArray(String content, Class<T[]> clazz) {
        if (TextUtils.isEmpty(content)) {
            ToastUtils.makeTextShort(MainApplication.application.getString(R.string.network_request_failed));
            return null;
        }
        try {
            HttpData been = HttpData.getHttpData(content);
            if (been.flag) {
                return Arrays.asList(GSON.fromJson(been.data, clazz));
            } else {
                ToastUtils.makeTextShort(been.info);
//                MyApp.getAppToken();
                return null;
            }
        } catch (Exception e) {
            ToastUtils.makeTextShort(MainApplication.application.getString(R.string.temporarily_no_data));
            return null;
        }
    }

}
