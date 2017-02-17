package com.qa.cdstore.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class CDServiceImp implements CDService{
	private static Logger lggr = Logger.getLogger(CDServiceImp.class);
	private Map<Integer, CD> cdMap;
	private int Key = 1;
	
	@Inject
	private JSONUtil util;
	
	@Inject
	private static DBWrapper dbw;

	public CDServiceImp(){
		cdMap = new HashMap<Integer, CD>();
		init();
	}
	
	@Override
	public String getAllCDs() {
		return util.getJSONForObject(cdMap.values());
	}

	@Override
	public String addNewCD(String cdJSON) {
		CD newCD = util.getObjectForJSON(cdJSON, CD.class);
		lggr.info("add cd to map");
		cdMap.put(Key, newCD);

		return cdJSON;
	}

	@Override
	public String replaceCD(Integer Key, String cdUpdate) {
		CD newCD = util.getObjectForJSON(cdUpdate, CD.class);
		cdMap.put(Key, newCD);
		return cdUpdate;
	}

	@Override
	public String deleteCD(Integer Key) {
		cdMap.remove(Key);
		return "{\"message\": \"cd sucessfully removed\"}";
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(dbw.ConnectionURL(), dbw.getDbUSR(), dbw.getDbPWD());
		}catch(Exception exx){
			lggr.info(exx.toString());
		}
		return conn;
	}
	
	private void init(){
		Statement str = null;
		ResultSet rst = null;
		Connection conn = getConnection();
		CD cds;
		
		try{
			str = conn.createStatement();
			rst = str.executeQuery("SELECT * FROM " + dbw.getDbName());
			
			while(rst.next()){
				Integer key = rst.getInt("ID");
				Long cdID = rst.getLong("ID");
				String cdArtist = rst.getString("artist");
				String cdSong = rst.getString("song");;
				String cdGenre = rst.getString("genre");
				
				cds = new CD(cdID, cdArtist, cdSong, cdGenre);
				
				cdMap.put(key, cds);
	
			}
		}catch(Exception exx){
			lggr.info(exx.toString());
		}
		
		for(Integer I : cdMap.keySet()){
			CD cd = cdMap.get(I);
		}
	}
}