package com.qa.cdstore.service;

public interface CDService {
		
	String getCDAll();
	String getCDByID(int id);
	String updateCD(int id, String updatedCDJSON);
	String deleteCD(int id);
	String createCD(String newCDJSON);

}
