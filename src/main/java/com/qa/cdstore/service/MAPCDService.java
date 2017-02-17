package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtility;

public class MAPCDService implements CDService {
	
	private Map<Integer, CD> cds;
	private int ID;
	
	@Inject
	private JSONUtility jsonUtil;
	
	public MAPCDService() {
		this.cds = new HashMap<Integer, CD>();
		ID = 0;
		initCDs();
	}
	
	public String getCDAll() {
		return jsonUtil.getObjectAsJSON(cds.values());
	}
	
	public String getCDByID(int id) {
		CD foundCD = cds.get(id);
		return jsonUtil.getObjectAsJSON(foundCD);
		
	}
	
	public String updateCD(int id, String updatedCDJSON) {
		CD updatedCD = jsonUtil.getJSONAsObject(updatedCDJSON);
		cds.replace(id, updatedCD);
		return updatedCDJSON;
		
	}
	
	public String deleteCD(int id) {
		cds.remove(id);
		return "{\"message\":\"CD successfully deleted\"}";
		
	}
	
	public String createCD(String newCDJSON) {
		CD newCD = jsonUtil.getJSONAsObject(newCDJSON);
		return newCDJSON;
		
	}
	
	public void initCDs() {
		
	}
	

}
