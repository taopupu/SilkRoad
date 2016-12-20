package com.dawei.silkroad.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GsonUtil
{
	private static final Gson GSON;

	static
	{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        GSON = gsonBuilder.create();
	}

	public static String toJson(Object object)
	{
		return GSON.toJson(object);
	}

	public static <T> T fromJson(String json, TypeToken<T> token)
	{
		if (TextUtils.isEmpty(json))
			return null;
		return GSON.fromJson(json, token.getType());
	}

	public static <T> T fromJson(String content, Class<T> clazz)
	{
		if (TextUtils.isEmpty(content))
			return null;
		return GSON.fromJson(content, clazz);
	}

	public static <T> List<T> fromJsonArray(String content, Class<T[]> clazz)
	{
		T[] arr = GSON.fromJson(content, clazz);
		return Arrays.asList(arr);
	}
	

	/**
	 * Json 转成 Map<>
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, String> getStringMapForJson(String jsonStr){
		JSONObject jsonObject ;
		try {
			jsonObject = new JSONObject(jsonStr);
			
			Iterator<String> keyIter= jsonObject.keys();
			String key;
			String value ;
			Map<String, String> valueMap = new HashMap<String, String>();
			while (keyIter.hasNext()) {
				key = keyIter.next();
				value = (String) jsonObject.get(key);
				valueMap.put(key, value);
			}
			return valueMap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.e("Gson", e.toString());
		}
		return null;
	}
	
	/**
	 * Json 转成 Map<>
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, Object> getMapForJson(String jsonStr){
		JSONObject jsonObject ;
		try {
			jsonObject = new JSONObject(jsonStr);
			
			Iterator<String> keyIter= jsonObject.keys();
			String key;
			Object value ;
			Map<String, Object> valueMap = new HashMap<String, Object>();
			while (keyIter.hasNext()) {
				key = keyIter.next();
				value = jsonObject.get(key);
				valueMap.put(key, value);
			}
			return valueMap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.e("Gson", e.toString());
		}
		return null;
	}
	/**
	 * Json 转成 List<Map<>>
	 * @param jsonStr
	 * @return
	 */
	public static List<Map<String, Object>> getlistForJson(String jsonStr){
		List<Map<String, Object>> list = null;
		try {
			JSONArray jsonArray = new JSONArray(jsonStr);
			JSONObject jsonObj ;
			list = new ArrayList<Map<String,Object>>();
			for(int i = 0 ; i < jsonArray.length() ; i ++){
				jsonObj = (JSONObject)jsonArray.get(i);
				list.add(getMapForJson(jsonObj.toString()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	
}