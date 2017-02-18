package com.qa.cdstore.util;

import com.google.gson.Gson;
import com.qa.cdstore.model.CD;

public class JSONUtility {
	
	private Gson gson;
	
	public JSONUtility() {
		this.gson = new Gson();
	}
	
	public String getObjectAsJSON(Object toJSONify) {
		return gson.toJson(toJSONify, CD.class);
	}
	
	public CD getJSONAsObject(String toCDify) {
		return gson.fromJson(toCDify, CD.class);
	}

}
