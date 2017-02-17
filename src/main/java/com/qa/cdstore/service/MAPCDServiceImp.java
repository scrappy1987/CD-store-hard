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
	private final int INITIAL_COUNT =1;
	private Map<Integer,CD> cdMap;
	private int ID;
	
	@Inject
	private JSONUtil util;
	
	public MAPCDServiceImp() {
		this.cdMap = new HashMap<Integer,CD>();
		this.ID = INITIAL_COUNT;
		initCDStore();
	}
	
	
	@Override
	public String getAllCDs() {
		LOGGER.info("in getAllCDs method");
		return util.getJSONForObject(cdMap.values());
	}

	@Override
	public String getSingleCD(int id) {
		LOGGER.info("in getSingleCD method");
		String single = "";
		for(CD cd : cdMap.values()){
			LOGGER.info("in getSingleCD method: looping through list");
			if(id == cd.getId()){
				LOGGER.info("in getSingleCD method: getting JSON for cd");
				single += util.getJSONForObject(cd);
			}
		}
		return single;
	}

	@Override
	public String deleteCD(int id) {
		LOGGER.info("in deleteCD method");
		cdMap.remove(id);
		LOGGER.info("cd removed from list");
		return "{\"message\": \"cd sucessfully removed\"}";
	}

	@Override
	public String addNewCD(String jsonCD) {
		ID++;
		CD newCD = util.getObjectForJSON(jsonCD, CD.class);
		LOGGER.info("in addNewCD method to add a new cd");
		cdMap.put(ID, newCD);
		LOGGER.info("in add cd method: cd added to map");
		return jsonCD;
	}

	@Override
	public String updateCD(Integer cdId, String updateCD) {
		CD newCD = util.getObjectForJSON(updateCD, CD.class);
		LOGGER.info("in updateCD method to update a CD");
		cdMap.put(cdId, newCD);
		LOGGER.info("in updateCD method: CD updated");
		return updateCD;
	}
		
	
	public void initCDStore(){
		CD aCD = new CD("nightmares on wax","les nuits","electronica");
		cdMap.put(1, aCD);
	}

	


}
