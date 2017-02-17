package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

//Imports

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

//Importing Packages
import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@ApplicationScoped
public class CDServiceImpl implements CDService{
	
	//Attributes
	private static final Logger LOGGER = Logger.getLogger(CDServiceImpl.class);//Logging this class
	private final int CD_COUNT = 1;
	private int ID;
	private Map<Integer, CD> cdMap;
	
	@Inject
	private JSONUtil util;	
	
	
	//Constructors
	public CDServiceImpl(){
		this.cdMap = new HashMap<Integer, CD>();
		ID = CD_COUNT;
		initCDStore();
	}
	
	//Methods
	@Override
	public String getAllCDs(){
		return util.getJSONForObject(cdMap.values());
	}
	
	@Override
	public String addNewCD(String cdJson){
		ID++;
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		LOGGER.info("Within addCD, method about to add to the map");
		cdMap.put(ID, newCD);
		LOGGER.info("Within addCD, CD added to map");
		return cdJson;
	}
	
	@Override
	public String deleteCD(int cdID){
		LOGGER.info("Within deleteCD, about to remove CD");
		cdMap.remove(cdID);
		LOGGER.info("Within deleteCD, cd removed");
		return "{\"message\": \"cd sucessfully removed\"}";
	}
	
	@Override
	public String updateCD(int cdID, String updatedCD){
		CD newCD = util.getObjectForJSON(updatedCD,  CD.class);
		cdMap.put(cdID, newCD);
		return updatedCD;
	}
	
	private void initCDStore(){
		CD aCd = new CD(1, "Placebo", "Running Up That Hill", "Rock");//1, "Placebo", 12, "Rock"
		cdMap.put(1, aCd);
	}
	

	/*public static void main(String[] args) {
		CDService cds = new CDService();
		JSONUtil util = new JSONUtil();
		System.out.println(util.getJSONForObject(cds.getCdMap().get(Integer.valueOf(0)).getSongs()));
	}*/
	
	/*private Map<Integer, CD> getCdMap() {
		cdMap.put(0, new CD(0, "bob", 0, "bob"));
		return cdMap;
	}*/
	
	/*public String getAllSongs(int cdID)
	{
		return util.getJSONForObject(cdMap.get(Integer.valueOf(cdID)).getSongs());
	}
	*/
}
