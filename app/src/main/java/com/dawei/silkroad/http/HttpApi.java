package com.dawei.silkroad.http;


public class HttpApi {
    public static final String BASE_URL = "http://192.168.3.107:8093/appInter/";
    //短信验证
    public static final String SMS = BASE_URL + "userAction/getPsmsSend";
    //注册
//    public static final String REGISTER = BASE_URL + "userAction/userRegister?account=ceshi001&password=123456";
    //登陆
    public static final String LOGIN = BASE_URL + "userAction/loginUser";
    //
    public static final String register = BASE_URL + "userAction/userRegister";
    public static final String CHANGE_PWD = BASE_URL+"userAction/updateUserPassWords";
}