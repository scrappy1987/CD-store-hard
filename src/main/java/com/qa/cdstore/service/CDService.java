package com.qa.cdstore.service;

public interface CDService {
	String getAllCDs();
	
	String addCD(String jsonCD);
	
	String updateCD(Integer cdId, String jsonCDUpdated);
	
	String deleteCD(Integer cdId);
}
