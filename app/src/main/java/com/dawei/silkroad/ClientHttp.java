package com.dawei.silkroad;

import com.dawei.silkroad.callback.UserCallBack;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;

public class ClientHttp {
//


    /**
     *
     * @param str
     */
    public static void getRequest(String str) {
        OkHttpUtils.get().url(str)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }
        });

    }

    public static void postRequest(String url, String username, String pwd) {
        OkHttpUtils.post().url(url).addParams("username", username)
                .addParams("password", pwd)
                .build()
                .execute(new UserCallBack() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(User response, int id) {

                    }
                });
    }
}
