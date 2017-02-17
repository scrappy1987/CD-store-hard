package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@ApplicationScoped
@Alternative
public class MAPCDServiceImp implements CDService{

	private Map<Integer,CD> cdMap;
	private int id;
	
	@Inject
	private JSONUtil util;
	
	public MAPCDServiceImp()
	{
		cdMap = new HashMap<Integer,CD>();
		id = 1;
		populateCds();
	}
	
	@Override
	public String getAllCds() {
	
		return util.objectToJSON(cdMap.values());
	}

	@Override
	public String getSingleCD(int id) {
		
		return util.objectToJSON(cdMap.get(id));
	}

	@Override
	public String deleteCD(int id) {
		cdMap.remove(id);
		return "CD Removed";
	}

	@Override
	public String addCD(String objJSON) {
		id++;
		CD cd = util.jsonToObject(objJSON, CD.class);
		cdMap.put(id, cd);
		return "CD Added";
	}

	@Override
	public String updateCD(int id, String objSJON) {
		CD cd = util.jsonToObject(objSJON, CD.class);
		cdMap.put(id, cd);
		return "CD Updated";
	}
	
	private  void populateCds()
	{
		CD cd = new CD(1,"Placebo","Pure Morning","Rock");
		cdMap.put(1,cd);
	}

}
