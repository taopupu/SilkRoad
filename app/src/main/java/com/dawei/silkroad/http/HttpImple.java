package com.dawei.silkroad.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.dawei.silkroad.callback.HttpCallBack;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


public class HttpImple extends HttpApi implements IHttp {

    @Override
    public void login(String name, String password, Callback callback) {
        OkHttpUtils.get().url(HttpApi.LOGIN).addParams("account", name)
                .addParams("password", password).build().execute(callback);
    }

    @Override
    public void sms(String phoneNumber, Callback callBack) {
        OkHttpUtils.get().url(HttpApi.SMS).addParams("mobileNumber", phoneNumber).build().execute(callBack);
    }

    @Override
    public void register(String phoneNumber, String password, String smsCode, Callback callback) {
        OkHttpUtils.get().url(HttpApi.register).addParams("account", phoneNumber)
                .addParams("password", password).addParams("smsCode", smsCode).build().execute(callback);
    }

    @Override
    public void changePwd(int id, String oldPwd, String newPwd, String rePwd, Callback callback) {
        OkHttpUtils.get().url(HttpApi.CHANGE_PWD).addParams("id", id + "").addParams("passWords", oldPwd)
                .addParams("newPassWords", newPwd).addParams("newRePassWords", rePwd).build().execute(callback);
    }

    @Override
    public void forgetPwd(String phoneNumber, String password, String smsCode, Callback callback) {
        OkHttpUtils.get().url(HttpApi.forgetPwd).addParams("mobileNumber", phoneNumber)
                .addParams("newPassWords", password).addParams("smsCode", smsCode).build().execute(callback);
    }

    @Override
    public void receiveAddress(String uid, Callback callback) {
        OkHttpUtils.get().url(HttpApi.ReceiveAddress).addParams("userId", uid).build().execute(callback);
    }

    @Override
    public void province_List(Callback callback) {
        OkHttpUtils.get().url(HttpApi.ProvinceList).build().execute(callback);
    }

    @Override
    public void cityList(String id, Callback callback) {
        OkHttpUtils.get().url(HttpApi.CITYLIST).addParams("provinceId", id).build().execute(callback);
    }

    @Override
    public void countryList(String id, Callback callback) {
        OkHttpUtils.get().url(HttpApi.COUNTRYLIST).addParams("cityId", id).build().execute(callback);
    }


}
