package com.qa.cdstore.util;

import com.google.gson.Gson;

public class JSONUtil {
	
	private Gson gson;

	public JSONUtil() {
		gson = new Gson();
	}
	
	public String convertToJSON (Object obj) {
		return gson.toJson(obj);
	}
	
	public <T> T convertFromJSON (String json, Class<T> obj) {
		return gson.fromJson(json, obj);
	}
	
}
