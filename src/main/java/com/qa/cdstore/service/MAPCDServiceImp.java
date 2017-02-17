package com.qa.cdstore.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

import java.util.Map;
import java.util.HashMap;

@ApplicationScoped
@Alternative
public class MAPCDServiceImp implements CDService {
	
	private static final Logger LOGGER = Logger.getLogger(MAPCDServiceImp.class);
	private final long INITIAL_COUNT = 1;
	private Map<Long, CD> cdMap;
	private long ID;

	@Inject
	private JSONUtil util;

	public MAPCDServiceImp() {
		this.cdMap = new HashMap<Long, CD>();
		ID = INITIAL_COUNT;
		initCDStore();
	}

	@Override
	public String getAllCDs() {
		return util.getJSONForObject(cdMap.values());
	}

	@Override
	public String addNewCD(String cdJson) {
		ID++;
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		LOGGER.info("In add cd method about to add to map");
		cdMap.put(ID, newCD);
		LOGGER.info("In add cd method book added to map");
		return cdJson;
	}

	@Override
	public String replaceCD(Long cdId, String updatedCD) {
		CD newCD = util.getObjectForJSON(updatedCD, CD.class);
		cdMap.put(cdId, newCD);
		return updatedCD;
	}

	@Override
	public String deleteCD(Long cdId) {
		LOGGER.info("In delete cd method about to remove cd");
		cdMap.remove(cdId);
		LOGGER.info("In delete cd method book removed");
		return "{\"message\": \"book sucessfully removed\"}";
	}

	private void initCDStore() {
		CD aCD = new CD("Adele", "25", "Pop");
		cdMap.put((long)1, aCD);
	}

}
