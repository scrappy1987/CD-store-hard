package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@ApplicationScoped
@Alternative
public class MAPCDServiceImp implements CDService{

	private static final Logger LOGGER = Logger.getLogger(MAPCDServiceImp.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> cdMap;
	private int ID;
	
	@Inject JSONUtil util;
	
	public MAPCDServiceImp(){
		this.cdMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		initCDStore();
	}

	@Override
	public String getAllCDs() {
		return util.getJSONForObject(cdMap.values());
	}

	@Override
	public String addCD(String jsonCD) {
		ID++;
		CD newCD = util.getObjectForJSON(jsonCD, CD.class);
		LOGGER.info("New CD about to be added to map");
		cdMap.put(ID, newCD);
		LOGGER.info("New CD has been added to the map");
		return jsonCD;
	}

	@Override
	public String updateCD(Integer cdId, String jsonCDUpdated) {
		CD newCD = util.getObjectForJSON(jsonCDUpdated, CD.class);
		if(cdMap.get(cdId) == null){
			LOGGER.info("Given CD ID not found, adding new CD");
		} else {
			LOGGER.info("Given CD found, updating CD");
		}
		cdMap.put(cdId, newCD);
		return jsonCDUpdated;
	}

	@Override
	public String deleteCD(Integer cdId) {
		LOGGER.info("Finding selected CD ready to delete");
		if(cdMap.get(cdId) == null){
			LOGGER.info("Selected CD not removed: ID not found");
			return "{\"message\": \"Given cd not found\"}";
		} else {
			cdMap.remove(cdId);
			LOGGER.info("Selected CD successfully removed");
			return "{\"message\": \"CD sucessfully removed\"}";
		}
	}
	
	private void initCDStore() {
		CD aCD = new CD("Infected Mushroom", "Suliman", "Goa-Trance");
		cdMap.put(aCD.getId(), aCD);
		aCD = new CD("Savant", "Protos", "Savant");
		cdMap.put(aCD.getId(), aCD);
		aCD = new CD("Avenged Sevenfold", "Avenged Sevenfold", "Metal");
		cdMap.put(aCD.getId(), aCD);
	}
	
}
