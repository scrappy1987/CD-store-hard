package com.qa.cdstore.util;

import com.google.gson.Gson;

public class UtilJSON {
	private Gson gson;
	
	public UtilJSON() {
		this.gson = new Gson();
	}
	
	public String toJson(Object obj) {
		return gson.toJson(obj);
	}
	
	public <T> T fromJson(String json, Class<T> classType) {
		return gson.fromJson(json, classType);
	}
}
