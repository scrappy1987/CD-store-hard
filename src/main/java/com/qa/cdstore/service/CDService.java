package com.qa.cdstore.service;

public interface CDService {
	
	public String getAllCDs();
	
	public String addNewCD(String cdJson);
	
	public String replaceCD(Integer id, String updatedCD);
	
	public String deleteCD(Integer id);


}
