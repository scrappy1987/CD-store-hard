package com.qa.cdstore.service;

public interface CDService {

	String getAllCDs();
	String addNewCD(String cdJson);
	String updateCD(int cdId, String updatedCD);
	String deleteCD(int cdId);
}
