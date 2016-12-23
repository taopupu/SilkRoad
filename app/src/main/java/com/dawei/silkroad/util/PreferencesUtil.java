package com.dawei.silkroad.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PreferencesUtil {

    private static final String TAG = "PreferencesUtil";

    /**
     * 数据存储
     */
    public static void save(Object o, Context context) {
        // 类
        Class<?> classObject = o.getClass();
        // 共享数据
        SharedPreferences mSharedPreferences = getPreferences(classObject, context);
        // 编辑
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        // 字段
        Field[] fields = classObject.getDeclaredFields();
        try {
            for (Field field : fields) {
                writePreferences(field, edit, o);
            }
        } catch (Exception e) {
            Log.e(TAG, "写入共享数据错误");
        }
        edit.commit();
    }

    private static SharedPreferences getPreferences(Class<?> classObject, Context ctx) {
        return ctx.getSharedPreferences(classObject.getSimpleName(), ctx.MODE_PRIVATE);
    }

    private static void writePreferences(Field field, SharedPreferences.Editor mEditor, Object o) throws IllegalArgumentException, IllegalAccessException {
        // 字段可访问
        field.setAccessible(true);
        // 类别
        Class<?> fildType = field.getType();
        if (String.class == fildType || Character.class == fildType) {
            mEditor.putString(field.getName(), String.valueOf(field.get(o)));
        } else if (Integer.TYPE == fildType || Integer.class == fildType) {
            mEditor.putInt(field.getName(), field.getInt(o));
        } else if (Boolean.TYPE == fildType || Boolean.class == fildType) {
            mEditor.putBoolean(field.getName(), field.getBoolean(o));
        } else if (Long.class == fildType || Long.TYPE == fildType) {
            mEditor.putLong(field.getName(), field.getLong(o));
        } else if (Float.class == fildType || Float.TYPE == fildType) {
            mEditor.putFloat(field.getName(), field.getFloat(o));
        }
    }
    /**
     * 清除数据
     */
    public static void clear(Object o, Context ctx) {
        Class<?> classObject = o.getClass();
        SharedPreferences mPreferences = getPreferences(classObject, ctx);
        SharedPreferences.Editor edit = mPreferences.edit();
        edit.clear();
        edit.commit();
    }
    /**
     * 载入数据
     */
    public static void loadData(Object o, Context ctx) {
        try {
            Class<?> classObject = o.getClass();
            SharedPreferences mPreferences = getPreferences(classObject, ctx);
            Field[] fields = classObject.getDeclaredFields();
            for (Field field : fields) {
                String val = getFieldFromSp(field, mPreferences);
                // 如果key值，都不存在，就不用在进行赋值了
                if (val == null) {
                    continue;
                }
                setValueToField(field, o, val);
            }
        } catch (Exception ex) {
            Log.v(TAG, "loadData Error：" + ex.getMessage());
        }
    }

    @SuppressLint("SimpleDateFormat")
    private static void setValueToField(Field field, Object object, String fieldvalue) throws IllegalArgumentException, IllegalAccessException, Exception {
        // 允许插入
        field.setAccessible(true);
        // 属性的类型
        Class<?> fieldType = field.getType();
        if (String.class == fieldType) { // string
            field.set(object, fieldvalue);
        } else if (Integer.TYPE == fieldType || Integer.class == fieldType) { // int
            Integer value = Integer.parseInt(fieldvalue);
            field.set(object, value);
        } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) { // long
            Long value = Long.parseLong(fieldvalue);
            field.set(object, value);
        } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) { // float
            Float value = Float.parseFloat(fieldvalue);
            field.set(object, value);
        } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) { // short
            Short value = Short.parseShort(fieldvalue);
            field.set(object, value);
        } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) { // double
            Double value = Double.parseDouble(fieldvalue);
            field.set(object, value);
        } else if (Character.TYPE == fieldType) { // char
            Character value = Character.valueOf(fieldvalue.charAt(0));
            field.set(object, value);
        } else if (Date.class == fieldType) { // date
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = df.parse(fieldvalue);
            field.set(object, date);
        } else if (Boolean.TYPE == fieldType || Boolean.class == fieldType) {
            field.setBoolean(object, (Boolean.parseBoolean(String.valueOf(fieldvalue))));
        }
    }

    /**
     * 根据field字段获取Preferences值
     */
    private static String getFieldFromSp(Field field, SharedPreferences mPreferences) {
        field.setAccessible(true);
        Class<?> fieldType = field.getType();
        String result = null;
        if (!mPreferences.contains(field.getName())) {
            return result;
        }
        if (String.class == fieldType || Charset.class == fieldType) {
            result = mPreferences.getString(field.getName(), "");
        } else if (Integer.TYPE == fieldType || Integer.class == fieldType) {
            result = String.valueOf(mPreferences.getInt(field.getName(), 0));
        } else if (Boolean.TYPE == fieldType || Boolean.class == fieldType) {
            result = String.valueOf(mPreferences.getBoolean(field.getName(), false));
        } else if (Long.class == fieldType || Long.TYPE == fieldType) {
            result = String.valueOf(mPreferences.getLong(field.getName(), 0L));
        } else if (Float.class == fieldType || Float.TYPE == fieldType) {
            result = String.valueOf(mPreferences.getFloat(field.getName(), 0F));
        }
        return result;
    }
}
