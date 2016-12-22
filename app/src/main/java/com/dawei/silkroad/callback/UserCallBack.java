package com.dawei.silkroad.callback;

import android.widget.Toast;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.dev.user.bean.User;
import com.dawei.silkroad.util.GsonUtil;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

public abstract class UserCallBack extends Callback<User> {

    @Override
    public User parseNetworkResponse(Response response, int id) throws Exception {
        HttpData data = HttpData.getHttpData(response.body().string());
        if (!data.flag) {
            Toast.makeText(MainApplication.application, data.info, Toast.LENGTH_SHORT).show();
            return null;
        }
        try {
            return GsonUtil.fromJson(data.data, User.class);
        } catch (Exception e) {
            Toast.makeText(MainApplication.application, MainApplication.application.getResources().getString(R.string.request_fail), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

}
