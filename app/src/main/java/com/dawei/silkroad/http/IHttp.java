package com.dawei.silkroad.http;

import com.dawei.silkroad.callback.HttpCallBack;
import com.zhy.http.okhttp.callback.Callback;


public interface IHttp {
    void login(String name, String password, Callback callback);

    void sms(String phoneNumber, Callback callback);

    void register(String phoneNumber, String password, String smsCode, Callback callback);
}
