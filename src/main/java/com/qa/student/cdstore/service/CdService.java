package com.qa.student.cdstore.service;

public interface CdService {

	String getAllCDs();

	String getCD(Integer cdID);
	
	String addNewCDs(String cdJson);

	String replaceCD(Integer cdId, String updatedCd);

	String deleteCD(Integer cdId);
	
	
}
