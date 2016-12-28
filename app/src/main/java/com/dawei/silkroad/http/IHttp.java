package com.dawei.silkroad.http;

import com.dawei.silkroad.callback.HttpCallBack;
import com.zhy.http.okhttp.callback.Callback;


public interface IHttp {
    void login(String name, String password, Callback callback);

    void sms(String phoneNumber, Callback callback);

    void register(String phoneNumber, String password, String smsCode, Callback callback);

    void changePwd(int id, String oldPwd, String newPwd, String RePwd, Callback callback);

    void forgetPwd(String phoneNumber, String password, String smsCode, Callback callback);

    void receiveAddress(String uid, Callback callback);

    void province_List(Callback callback);

    void cityList(String id, Callback callback);

    void countryList(String id, Callback callback);
}
