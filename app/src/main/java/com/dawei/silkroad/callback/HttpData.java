package com.dawei.silkroad.callback;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.util.GsonUtil;
import com.google.gson.JsonObject;

import org.json.JSONObject;


public class HttpData {
    public boolean flag;
    public String data;
    public String info;

    public static HttpData getHttpData(String json) {
        try {
            HttpData data = new HttpData();
            JSONObject jsonObject = new JSONObject(json);
            data.flag = jsonObject.optBoolean("flag",false);
            data.data = jsonObject.optString("data","");
            data.info = jsonObject.optString("info","");
            return data;
        } catch (Exception e) {
            HttpData httpData = new HttpData();
            httpData.flag = false;
            httpData.data = "";
            httpData.info = MainApplication.application.getResources().getString(R.string.request_fail);
            return httpData;
        }
    }
}
