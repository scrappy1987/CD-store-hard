package com.qa.student.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.util.JSONUtil;
import com.qa.cdstore.model.CD;
import com.qa.student.cdstore.service.CdServiceImpl;

@ApplicationScoped
@Alternative
public class CdServiceImpl implements CdService{

	
	private static final Logger LOGGER = Logger.getLogger(CdServiceImpl.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> cdMap;
	
	private int ID;
	
	@Inject
	private JSONUtil jutil;

	public CdServiceImpl() {
		this.cdMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		initCdStore();
	}
	

	@Override
	public String getAllCDs() {
		LOGGER.info("Retrieved all cds");
		return jutil.getJSONForObject(cdMap.values());
	}

	@Override
	public String addNewCDs(String cdJson) {
		ID++;
		CD newCd = jutil.getObjectForJSON(cdJson, CD.class);
		LOGGER.info("In add cd method about to add to map");
		cdMap.put(ID, newCd);
		LOGGER.info("In add cd method cd added to map");
		return cdJson;
	}

	@Override
	public String replaceCD(Integer cdId, String updatedCd) {
		LOGGER.info("replaceCd in store");
		CD newCd = jutil.getObjectForJSON(updatedCd, CD.class);
		cdMap.put(cdId, newCd);
		return updatedCd;
	}

	@Override
	public String deleteCD(Integer CdId) {
		LOGGER.info("In delete cd method about to remove cd");
		cdMap.remove(CdId);
		LOGGER.info("In delete cd method cd removed");
		return "{\"message\": \"cd sucessfully removed\"}";
	}

	private void initCdStore() {
		LOGGER.info("Initialised cd store with default cd");
		CD aCd = new CD("Russell Claxton", "AyLmao", "DankMemes");
		cdMap.put(1, aCd);
	}
	
	
}
