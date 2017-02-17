package com.qa.cdstore.util;

import com.google.gson.Gson;

public class JSONUtil {
	
	private Gson gson;
	
	public JSONUtil(){
		this.gson = new Gson();
	}
	
	public String ObjectToJSON(Object obj) {
		return gson.toJson(obj);
	}
	
	public <T> T JSONToObject (String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}
		
}
