package com.dawei.silkroad.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    //判断字符串是否为空 ，空 true，否 false
    public static boolean isEmpty(String param) {
        if (param != null && !("".equals(param)) && !("null".equals(param))) {
            return false;
        } else {
            return true;
        }
    }

    //判断手机号码是否正确，是：true，否false
    public static boolean isPhone(String param) {
        boolean isFlag = false;
        if (param.trim().length() == 11 && '1' == param.trim().charAt(0)) {
            isFlag = true;
        }
        return isFlag;
    }

    //判断密码是否合理 否：true，是 false
    public static boolean isNotValidePwd(String pwd) {
        if (isEmpty(pwd)) {
            return true;
        } else {
            if (pwd.length() < 6 || pwd.length() > 20) {
                return true;
            }
        }
        return false;
    }
   //判断邮箱是否合理 是：true，否false
    public static boolean isAEmail(String email) {
        if (null == email || "".equals(email)) return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
