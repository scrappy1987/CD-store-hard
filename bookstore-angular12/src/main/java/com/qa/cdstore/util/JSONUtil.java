package com.qa.cdstore.util;

import java.util.List;

import com.google.gson.Gson;
import com.qa.cdstore.model.CD;

public class JSONUtil
{
	private Gson gson; {this.gson = new Gson();}

	public String getJSONFfromEntity(Object entity)
	{
		return gson.toJson(entity);
	}

	public <T> T getEntityFromJSON(String jsonString, Class<T> outputClass)
	{
		return gson.fromJson(jsonString, outputClass);
	}
}
