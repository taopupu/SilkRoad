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
    //收货地址
    public static final String ReceiveAddress = BASE_URL + "myAddressAction/getMyAddressList";
    //获取省份列表
    public static final String ProvinceList = BASE_URL + "areaAction/getProvinceList";
    //获取市列表
    public static final String CITYLIST = BASE_URL + "areaAction/getCityList";
    //获取县区列表
    public static final String COUNTRYLIST = BASE_URL + "areaAction/getCountyList";
// 查看个人信息   http://192.168.3.107:8093/appInter/userAction/getUserBaseInfoDetail?id=1110
// 推荐作品列表   http://192.168.3.107:8093/appInter/homePageAction/getAreaRecommenIdGoodsList?prefectureRecommenId=9
// 版本更新   http://192.168.3.107:8093/appInter/systemVersionAcion/addSystemVersion?version=0.0.4&versionCode=4&systemType=111
// 商品详情   http://192.168.3.107:8093/appInter/goodsAction/getGoodDetail?goodId=1260
}