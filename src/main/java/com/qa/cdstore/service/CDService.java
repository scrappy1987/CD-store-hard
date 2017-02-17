package com.qa.cdstore.service;

import org.apache.log4j.Logger;

public interface CDService {

	static final Logger LOGGER =  Logger.getLogger(CDService.class);
	final int INITIAL_COUNT = 1;
	
	int currentID = INITIAL_COUNT;
	
	String getCDs();
	
	String replaceCD(Integer id, String cdToUpdate);
	
	String addCD(String object);
	
	String deleteCD(Integer id);
	String getSingleCD(Integer id);

}
