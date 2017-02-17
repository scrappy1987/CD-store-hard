package com.qa.cdstore.service;

public interface CDService {

	String getAllCDs();

	String addNewCD(String cdJson);

	String replaceCD(Long cdId, String updatedCD);

	String deleteCD(Long cdId);
	
}
