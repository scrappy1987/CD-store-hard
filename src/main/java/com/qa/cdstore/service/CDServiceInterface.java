package com.qa.cdstore.service;

public interface CDServiceInterface {

	public String getAllCDs();
	
	public String addNewCD(String cdJson);
	
	public String replaceCD(Integer id, String updatedCD);

	public String deleteCD(Integer id);
	
}
