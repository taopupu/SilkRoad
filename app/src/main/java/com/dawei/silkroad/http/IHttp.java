package com.dawei.silkroad.http;

import com.zhy.http.okhttp.callback.Callback;

/**
 * Created by yuanbaojun on 2016/12/19.
 */

public interface IHttp {
    void login(String name, String password, Callback callback);
}
