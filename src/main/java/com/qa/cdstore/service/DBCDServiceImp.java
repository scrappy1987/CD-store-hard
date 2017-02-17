package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Alternative
public class DBCDServiceImp implements CDService {

	private static final Logger CD_LOGGER = Logger.getLogger(CDService.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer,CD> cdMap;
	private int ID;
	
	@Inject
	private JSONUtil util;
	
	public DBCDServiceImp() {
		this.cdMap = new HashMap<Integer,CD>();
		ID = INITIAL_COUNT;
		initCDLibrary();
	}
	
	@Override
	public String getAllCDs() {
		return util.getJSONForObject(cdMap.values());
	}

	@Override
	public String addNewCD(String cdJson) {
		ID++;
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		CD_LOGGER.info("CD prepared to be added to map");
		cdMap.put(ID,newCD);
		CD_LOGGER.info("Added new CD to map");
		return cdJson;
	}

	@Override
	public String replaceCD(Integer id, String updatedCD) {
		CD newCD = util.getObjectForJSON(updatedCD,CD.class);
		cdMap.put(id,newCD);
		return updatedCD;
		
	}

	@Override
	public String deleteCD(Integer id) {
		CD_LOGGER.info("Delete CD from map");
		cdMap.remove(id);
		CD_LOGGER.info("CD deleted successfully");
		return "{\"message\": \"CD has been removed\"}";
	}

	private void initCDLibrary() {
		CD aCD = new CD(3,"Britney Spears", "Stronger","Pop");
		cdMap.put(1, aCD);
	}
	
}
