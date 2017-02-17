package com.qa.cdstore.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;
	
	public JSONUtil()
	{
		this.gson = new Gson();
	}
	
	public String objectToJSON(Object obj)
	{
		return gson.toJson(obj);
	}
	
	public <C> C jsonToObject(String json, Class<C> objClass)
	{
		return gson.fromJson(json, objClass);
		
	}
	
}
