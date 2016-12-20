package com.dawei.silkroad.callback;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.util.GsonUtil;

/**
 * Created by yuanbaojun on 2016/12/19.
 */

public class HttpData {
    public boolean flag ;
    public String data;
    public String info;


    public static HttpData getHttpData(String json){
        try {
            return GsonUtil.fromJson(json,HttpData.class);
        }catch (Exception e){
            HttpData httpData = new HttpData();
            httpData.flag = false;
            httpData.data = "";
            httpData.info = MainApplication.application.getResources().getString(R.string.request_fail);
            return httpData;
        }
    }
}
