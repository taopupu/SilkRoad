package com.dawei.silkroad.callback;

import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;


public abstract class HttpCallBack extends Callback<HttpData> {

    @Override
    public HttpData parseNetworkResponse(Response response, int id) throws Exception {
        HttpData data = HttpData.getHttpData(response.body().string());
        return data;
    }

}
