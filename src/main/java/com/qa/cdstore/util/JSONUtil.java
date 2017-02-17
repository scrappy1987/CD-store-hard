package com.qa.cdstore.util;
import com.google.gson.Gson;

public class JSONUtil {
	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String convertToJSON(Object obj) {
		return gson.toJson(obj);
	}
	
	public <T> T convertToObject(String JSONToConvert, Class<T> object){
		return gson.fromJson(JSONToConvert, object);
	}
}
