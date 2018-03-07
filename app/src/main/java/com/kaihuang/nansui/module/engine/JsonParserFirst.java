package com.kaihuang.nansui.module.engine;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParserFirst {

//	public static List<HotTJ> parser_HotTJ(String json) {
//		List<HotTJ> list = new ArrayList<HotTJ>();
//
//		return list;
//	}

	/**
	 * 获取返回码
	 * 
	 * @param json
	 * @return
	 */
	public static int getRetCode(String json) {
		int code = -1;
//		String msg = null;
		if (json == null || json.isEmpty()) {
			return code;
		}
		try {
			JSONObject obj = new JSONObject(json);
			JSONObject status = new JSONObject(obj.getString("status"));
			code = Integer.parseInt(status.getString("code"));

		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return code;
		}
	}

	/**
	 * 获取返回的文字详细信息
	 * 
	 * @param json
	 * @return
	 */
	public static String getRetMsg(String json) {
		String msg = "";
		if (json == null || json.isEmpty()) {
			return msg;
		}
		try {
			JSONObject obj = new JSONObject(json);
			JSONObject status = new JSONObject(obj.getString("status"));
			msg = status.getString("msg");
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return msg;
		}
	}
	/**
	 * 获取返回的文字详细信息
	 *如：提交图片
	 * @param json
	 * @return
	 */
	public static String getRetMsgByKey(String json, String key) {
		String msg = "";
		if (json == null || json.isEmpty()) {
			return msg;
		}
		try {
			JSONObject obj = new JSONObject(json);
			JSONObject status = new JSONObject(obj.getString( "data"));
			msg = status.getString(key);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return msg;
		}
	}/**
	 * 获取返回的文字详细信息
	 *如：提交图片
	 * @param json
	 * @return
	 */
	public static int getRetDataByKey(String json, String key) {
		int msg = 0;
		if (json == null || json.isEmpty()) {
			return msg;
		}
		try {
			JSONObject obj = new JSONObject(json);
			JSONObject status = new JSONObject(obj.getString( "data"));
			msg = status.getInt(key);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return msg;
		}
	}


}
