package com.dawei.silkroad.callback;

import com.dawei.silkroad.dev.user.User;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * Created by yuanbaojun on 2016/12/19.
 */

public abstract class UserCallBack extends Callback<User>{

    @Override
    public User parseNetworkResponse(Response response, int id) throws Exception {
        HttpData data = HttpData.getHttpData(response.message());


        User user = new User();
        return user;
    }

}
