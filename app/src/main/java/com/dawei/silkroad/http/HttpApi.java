package com.dawei.silkroad.http;


public class HttpApi {
    public static final String BASE_URL = "http://192.168.3.107:8093/appInter/";
    //短信验证
    public static final String SMS = BASE_URL + "userAction/getPsmsSend";
    //登陆
    public static final String LOGIN = BASE_URL + "userAction/loginUser";
    //注册
    public static final String register = BASE_URL + "userAction/userRegister";
    //修改密码
    public static final String CHANGE_PWD = BASE_URL + "userAction/updateUserPassWords";
    //忘记密码
    public static final String forgetPwd = BASE_URL + "userAction/forgetPwdSuc";

}