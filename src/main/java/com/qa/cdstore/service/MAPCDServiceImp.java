package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;;

@ApplicationScoped
@Alternative
public class MAPCDServiceImp  implements CDServiceInterface{

	private static final Logger LOGGER = Logger.getLogger(CDServiceInterface.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> cdMap;
	private int ID;

	@Inject
	private JSONUtil util;
	
	public MAPCDServiceImp() {
		this.cdMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		initCDStore();
	}
	
	private void initCDStore() {
		// TODO Auto-generated method stub
		CD aCD = new CD(1, "Imagine Dragons", "Demons", "Indie Rock");
		cdMap.put(1, aCD);
	}

	@Override
	public String getAllCDs() {
		return util.ObjectToJSON(cdMap.values());
	}

	@Override
	public String addNewCD(String cdJson) {
		ID++;
		CD newCD = util.JSONToObject(cdJson, CD.class);
		LOGGER.info("About to add a CD to the map");
		cdMap.put(ID, newCD);
		LOGGER.info("CD added to the map");
		return cdJson;
	}

	@Override
	public String replaceCD(Integer id, String updatedCD) {
		CD newCD = util.JSONToObject(updatedCD, CD.class);
		cdMap.put(id, newCD);
		return updatedCD;
	}

	@Override
	public String deleteCD(Integer id) {
		LOGGER.info("About to delete a CD from the map");
		cdMap.remove(id);
		LOGGER.info("CD deleted from the map");
		return "CD successfully deleted";
	}
	

}
