package com.dawei.silkroad;

import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

public abstract class UserCallBack extends Callback<User> {
    @Override
    public User parseNetworkResponse(Response response, int id) throws Exception {
        String str = response.body().string();
        User user = new User();
        return user;
    }
}
